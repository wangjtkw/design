package com.example.design.controller;

import com.example.design.DesignApplication;
import com.example.design.common.ErrorCode;
import com.example.design.common.MyResponseBody;
import com.example.design.common.UploadUtils;
import com.example.design.entity.requestbean.server.ServerUnitLogin;
import com.example.design.entity.requestbean.server.ServerUnitRegister;
import com.example.design.entity.requestbean.server.ServerUnitServicesAdd;
import com.example.design.entity.responsebean.ServerUnitServicesDetail;
import com.example.design.entity.server.*;
import com.example.design.service.server.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/server")
public class ServerUnitController {
    private final Log log = LogFactory.getLog(DesignApplication.class);

    @Autowired
    private ServerUnitAccountService serverUnitAccountService;

    @Autowired
    private ServerUnitCompanyService serverUnitCompanyService;

    @Autowired
    private ServerUnitServicesService serverUnitServicesService;

    @Autowired
    private ServerUnitServicesAirTourService serverUnitServicesAirTourService;

    @Autowired
    private ServerUnitServicesCharteredAirplaneService serverUnitServicesCharteredAirplaneService;

    @Autowired
    private ServerUnitServicesParachuteFlightService serverUnitServicesParachuteFlightService;

    @Autowired
    private ServerUnitServicesArtificialRainfallService serverUnitServicesArtificialRainfallService;

    @Autowired
    private ServerUnitServicesHelicopterRentalService serverUnitServicesHelicopterRentalService;

    /**
     * 需要做账号、密码、邮箱的格式检查
     */
    @PostMapping("/register")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object register(ServerUnitRegister serverUnitRegister) {
        this.log.info(serverUnitRegister.toString());
        this.log.info(serverUnitRegister.toString());
        //账户、密码、邮箱、企业名称、基地、机场、资本、法人姓名、法人联系方式、经营范围、企业类型、有效期
        if (serverUnitRegister.getServerUnitAccountAccount() == null
                || serverUnitRegister.getServerUnitAccountPassword() == null
                || serverUnitRegister.getServerUnitAccountEmail() == null
                || serverUnitRegister.getServerUnitCompanyName() == null
                || serverUnitRegister.getServerUnitCompanyBase() == null
                || serverUnitRegister.getServerUnitCompanyAirport() == null
                || serverUnitRegister.getServerUnitCompanyCapital() == null
                || serverUnitRegister.getServerUnitCompanyLegalRepresentativeName() == null
                || serverUnitRegister.getServerUnitCompanyLegalRepresentativePhone() == null
                || serverUnitRegister.getServerUnitCompanyScope() == null
                || serverUnitRegister.getServerUnitCompanyType() == null
                || serverUnitRegister.getServerUnitCompanyValidityTerm() == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE);
        }
        //如果账户已存在
        if (serverUnitAccountService.getServerUnitAccountByAccount(serverUnitRegister.getServerUnitAccountAccount()) != null) {
            return new MyResponseBody(ErrorCode.DUPLICATE_ACCOUNT_NUMBER_CODE, ErrorCode.DUPLICATE_ACCOUNT_NUMBER_DESCRIBE);
        }
        ServerUnitAccount serverUnitAccount = new ServerUnitAccount(
                serverUnitRegister.getServerUnitAccountAccount(),
                serverUnitRegister.getServerUnitAccountPassword(),
                serverUnitRegister.getServerUnitAccountEmail());
        ServerUnitCompany serverUnitCompany = new ServerUnitCompany(
                serverUnitRegister.getServerUnitCompanyName(),
                serverUnitRegister.getServerUnitCompanyBase(),
                serverUnitRegister.getServerUnitCompanyAirport(),
                serverUnitRegister.getServerUnitCompanyType(),
                serverUnitRegister.getServerUnitCompanyCapital(),
                serverUnitRegister.getServerUnitCompanyLegalRepresentativeName(),
                serverUnitRegister.getServerUnitCompanyLegalRepresentativePhone(),
                serverUnitRegister.getServerUnitCompanyValidityTerm(),
                serverUnitRegister.getServerUnitCompanyScope(),
                "待审批");
        serverUnitCompanyService.insert(serverUnitCompany);
        serverUnitAccount.setServerUnitCompanyId(serverUnitCompany.getServerUnitCompanyId());
        serverUnitAccountService.insert(serverUnitAccount);

        this.log.info(serverUnitRegister.toString());
        return new MyResponseBody(200, "OK");
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(ServerUnitLogin serverUnitLogin) {
        if (serverUnitLogin.getServerUnitAccountAccount() == null
                || serverUnitLogin.getServerUnitAccountPassword() == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE);
        }

        ServerUnitAccount account = serverUnitAccountService.getServerUnitAccountByAccount(serverUnitLogin.getServerUnitAccountAccount());
        if (account != null && account.getServerUnitAccountPassword().equals(serverUnitLogin.getServerUnitAccountPassword())) {
            account.setServerUnitAccountPassword("");
            return new MyResponseBody(200, "OK", account);
        } else {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "账号或密码错误");
        }
    }

    @GetMapping("/company/get")
    public Object getCompanyInfo(@RequestParam int companyId) {
        ServerUnitCompany company = serverUnitCompanyService.select(companyId);
        if (company != null) {
            return new MyResponseBody(200, "OK", company);
        } else {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "id 错误");
        }
    }

    @PostMapping("/company/update")
    @ResponseBody
    public Object updateCompanyInfo(ServerUnitCompany company) {
        this.log.info(company.toString());
        serverUnitCompanyService.update(company);
        return new MyResponseBody(200, "OK");
    }

    /**
     * 还需做数据验证
     */
    @PostMapping("/server/add")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object addServer(@RequestParam MultipartFile file, ServerUnitServicesAdd addInfo) {
        System.out.println(addInfo);
        if (file == null || file.isEmpty()) {
            return new MyResponseBody(ErrorCode.PICTURE_ERROR_CODE, ErrorCode.PICTURE_ERROR_DESCRIBE + "服务图片不能为空");
        }
        String imgName = UploadUtils.uploadImg(file);
        if (imgName == null) {
            return new MyResponseBody(ErrorCode.PICTURE_ERROR_CODE, ErrorCode.PICTURE_ERROR_DESCRIBE + "图片上传错误");
        }

        if (addInfo.getServerUnitAccountId() == null
                || addInfo.getServerUnitServicesTitle() == null
                || addInfo.getServerUnitServicesDetail() == null
                || addInfo.getServerUnitServicesType() == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数未填写全");
        }
        ServerUnitServices services = new ServerUnitServices(
                addInfo.getServerUnitAccountId(),
                addInfo.getServerUnitServicesTitle(),
                imgName,
                addInfo.getServerUnitServicesDetail(),
                addInfo.getServerUnitServicesType(),
                "待审批");
        switch (addInfo.getServerUnitServicesType()) {
            case "空中游览":
                ServerUnitServicesAirTour servicesAirTour = new ServerUnitServicesAirTour(
                        addInfo.getServerUnitServicesAirTourSightseeingPlaces(),
                        addInfo.getServerUnitServicesAirTourDuration(),
                        addInfo.getServerUnitServicesAirTourAircraftModel(),
                        addInfo.getServerUnitServicesAirTourNumberLimit(),
                        addInfo.getServerUnitServicesAirTourBoardingLocation(),
                        addInfo.getServerUnitServicesAirTourPrice());
                serverUnitServicesAirTourService.insert(servicesAirTour);
                services.setServerUnitServicesAirTourId(servicesAirTour.getServerUnitServicesAirTourId());
//                serverUnitServicesService.update(services);
                break;
            case "包机飞行":
                ServerUnitServicesCharteredAirplane charteredAirplane = new ServerUnitServicesCharteredAirplane(
                        addInfo.getServerUnitServicesCharteredAirplaneStartAddress(),
                        addInfo.getServerUnitServicesCharteredAirplaneEndAddress(),
                        addInfo.getServerUnitServicesCharteredAirplaneAircraftModel(),
                        addInfo.getServerUnitServicesCharteredAirplaneSeatsNum(),
                        addInfo.getServerUnitServicesCharteredAirplaneBoardingLocation(),
                        addInfo.getServerUnitServicesCharteredAirplanePrice());
                serverUnitServicesCharteredAirplaneService.insert(charteredAirplane);
                services.setServerUnitServicesCharteredAirplaneId(charteredAirplane.getServerUnitServicesCharteredAirplaneId());
//                serverUnitServicesService.update(services);
                break;
            case "跳伞飞行":
                ServerUnitServicesParachuteFlight parachuteFlight = new ServerUnitServicesParachuteFlight(
                        addInfo.getServerUnitServicesParachuteFlightAddress(),
                        addInfo.getServerUnitServicesParachuteFlightAircraftModel(),
                        addInfo.getServerUnitServicesParachuteFlightPrice());
                serverUnitServicesParachuteFlightService.insert(parachuteFlight);
                services.setServerUnitServicesParachuteFlightId(parachuteFlight.getServerUnitServicesParachuteFlightId());
//                serverUnitServicesService.update(services);
                break;
            case "人工增雨":
                ServerUnitServicesArtificialRainfall artificialRainfall = new ServerUnitServicesArtificialRainfall(
                        addInfo.getServerUnitServicesArtificialRainfallAircraftModel(),
                        addInfo.getServerUnitServicesArtificialRainfallCatalyzer(),
                        addInfo.getServerUnitServicesArtificialRainfallMaxDose(),
                        addInfo.getServerUnitServicesArtificialRainfallPrice(),
                        addInfo.getServerUnitServicesArtificialRainfallPhone());
                serverUnitServicesArtificialRainfallService.insert(artificialRainfall);
                services.setServerUnitServicesArtificialRainfallId(artificialRainfall.getServerUnitServicesArtificialRainfallId());
//                serverUnitServicesService.update(services);
                break;
            case "直升机出租":
                ServerUnitServicesHelicopterRental helicopterRental = new ServerUnitServicesHelicopterRental(

                        addInfo.getServerUnitServicesHelicopterRentalAircraftModel(),
                        addInfo.getServerUnitServicesHelicopterRentalPrice(),
                        addInfo.getServerUnitServicesHelicopterRentalPhone());
                serverUnitServicesHelicopterRentalService.insert(helicopterRental);
                services.setServerUnitServicesHelicopterRentalId(helicopterRental.getServerUnitServicesHelicopterRentalId());
//                serverUnitServicesService.update(services);
                break;
            default:
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "类型错误");
        }
        serverUnitServicesService.insert(services);
        return new MyResponseBody(200, "OK");
    }

    @GetMapping("/server/detail")
    @ResponseBody
    public Object getServer(@RequestParam int serverId) {
        ServerUnitServices services = serverUnitServicesService.select(serverId);
        if (services == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "id 不合法");
        }
        IServerUnitService iServerUnitService;
        switch (services.getServerUnitServicesType()) {
            case "空中游览":
                iServerUnitService = serverUnitServicesAirTourService.select(services.getServerUnitServicesAirTourId());
                break;
            case "包机飞行":
                iServerUnitService = serverUnitServicesCharteredAirplaneService.select(services.getServerUnitServicesCharteredAirplaneId());
                break;
            case "跳伞飞行":
                iServerUnitService = serverUnitServicesParachuteFlightService.select(services.getServerUnitServicesParachuteFlightId());
                break;
            case "人工增雨":
                iServerUnitService = serverUnitServicesArtificialRainfallService.select(services.getServerUnitServicesArtificialRainfallId());
                break;
            case "直升机出租":
                iServerUnitService = serverUnitServicesHelicopterRentalService.select(services.getServerUnitServicesHelicopterRentalId());
                break;
            default:
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "id错误");
        }
        return new MyResponseBody(200, "OK", new ServerUnitServicesDetail(services, iServerUnitService));
    }

    @PostMapping("/server/update")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object updateServer(@RequestParam(required = false) MultipartFile file, ServerUnitServicesAdd addInfo) {
        if (file != null) {
            String imgName = UploadUtils.uploadImg(file);
            if (imgName == null) {
                return new MyResponseBody(ErrorCode.PICTURE_ERROR_CODE, ErrorCode.PICTURE_ERROR_DESCRIBE + "图片上传错误");
            }
            addInfo.setServerUnitServicesImg(imgName);
        }
//        System.out.println(addInfo.getServerUnitServicesImg());

        if (addInfo.getServerUnitServicesId() == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "必须附带服务id");
        }
        ServerUnitServices services = new ServerUnitServices(
                addInfo.getServerUnitServicesId(),
                addInfo.getServerUnitServicesTitle(),
                addInfo.getServerUnitServicesImg(),
                addInfo.getServerUnitServicesDetail(),
                addInfo.getServerUnitServicesType(),
                "待审批"
        );
        System.out.println(services.getServerUnitServicesImg());
        int result = -1;
        switch (addInfo.getServerUnitServicesType()) {
            case "空中游览":
                ServerUnitServicesAirTour airTour = new ServerUnitServicesAirTour(
                        addInfo.getServerUnitServicesAirTourId(),
                        addInfo.getServerUnitServicesAirTourSightseeingPlaces(),
                        addInfo.getServerUnitServicesAirTourDuration(),
                        addInfo.getServerUnitServicesAirTourAircraftModel(),
                        addInfo.getServerUnitServicesAirTourNumberLimit(),
                        addInfo.getServerUnitServicesAirTourBoardingLocation(),
                        addInfo.getServerUnitServicesAirTourPrice()
                );
                result = serverUnitServicesAirTourService.update(airTour);
                break;
            case "包机飞行":
                ServerUnitServicesCharteredAirplane charteredAirplane = new ServerUnitServicesCharteredAirplane(
                        addInfo.getServerUnitServicesCharteredAirplaneId(),
                        addInfo.getServerUnitServicesCharteredAirplaneStartAddress(),
                        addInfo.getServerUnitServicesCharteredAirplaneEndAddress(),
                        addInfo.getServerUnitServicesCharteredAirplaneAircraftModel(),
                        addInfo.getServerUnitServicesCharteredAirplaneSeatsNum(),
                        addInfo.getServerUnitServicesCharteredAirplaneBoardingLocation(),
                        addInfo.getServerUnitServicesCharteredAirplanePrice()
                );
                result = serverUnitServicesCharteredAirplaneService.update(charteredAirplane);
                break;
            case "跳伞飞行":
                ServerUnitServicesParachuteFlight serverUnitServicesParachuteFlight = new ServerUnitServicesParachuteFlight(
                        addInfo.getServerUnitServicesParachuteFlightId(),
                        addInfo.getServerUnitServicesParachuteFlightAddress(),
                        addInfo.getServerUnitServicesParachuteFlightAircraftModel(),
                        addInfo.getServerUnitServicesParachuteFlightPrice()
                );
                result = serverUnitServicesParachuteFlightService.update(serverUnitServicesParachuteFlight);
                break;
            case "人工增雨":
                ServerUnitServicesArtificialRainfall artificialRainfall = new ServerUnitServicesArtificialRainfall(
                        addInfo.getServerUnitServicesArtificialRainfallId(),
                        addInfo.getServerUnitServicesArtificialRainfallAircraftModel(),
                        addInfo.getServerUnitServicesArtificialRainfallCatalyzer(),
                        addInfo.getServerUnitServicesArtificialRainfallMaxDose(),
                        addInfo.getServerUnitServicesArtificialRainfallPrice(),
                        addInfo.getServerUnitServicesArtificialRainfallPhone()
                );
                result = serverUnitServicesArtificialRainfallService.update(artificialRainfall);
                break;
            case "直升机出租":
                ServerUnitServicesHelicopterRental helicopterRental = new ServerUnitServicesHelicopterRental(
                        addInfo.getServerUnitServicesHelicopterRentalId(),
                        addInfo.getServerUnitServicesHelicopterRentalAircraftModel(),
                        addInfo.getServerUnitServicesHelicopterRentalPrice(),
                        addInfo.getServerUnitServicesHelicopterRentalPhone()
                );
                result = serverUnitServicesHelicopterRentalService.update(helicopterRental);
                break;
            default:
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.DUPLICATE_ACCOUNT_NUMBER_DESCRIBE + "服务类型错误");
        }
        if (result != 1) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "服务具体类型id错误");
        }
        serverUnitServicesService.update(services);
        return new MyResponseBody(200, "OK");
    }

    @GetMapping("/server/list")
    public Object getServerList(@RequestParam int accountId) {
        List<ServerUnitServices> result = serverUnitServicesService.selectByAccountKey(accountId);
        return new MyResponseBody(200, "OK", result);
    }

//    @GetMapping("/test/img")
//    public Object uploadImg(@RequestParam MultipartFile file) {
//        if (file.isEmpty()) {
//            return new MyResponseBody(ErrorCode.PICTURE_ERROR_CODE, ErrorCode.PICTURE_ERROR_DESCRIBE + "服务图片不能为空");
//        }
//        String imgName = UploadUtils.uploadImg(file);
//        if (imgName == null) {
//            return new MyResponseBody(ErrorCode.PICTURE_ERROR_CODE, ErrorCode.PICTURE_ERROR_DESCRIBE + "图片上传错误");
//        }
//        return new MyResponseBody(200, "OK", imgName);
//    }

    @GetMapping("/server/deleteSingle")
    public Object deleteServer(@RequestParam int serverId) {
        delete(serverId);
        return new MyResponseBody(200, "OK");
    }

    @Transactional
    void delete(int serverId) {
        ServerUnitServices services = serverUnitServicesService.select(serverId);
        if (services == null) return;
        serverUnitServicesService.delete(serverId);
        switch (services.getServerUnitServicesType()) {
            case "空中游览":
//                serverUnitServicesAirTourService
                serverUnitServicesAirTourService.delete(services.getServerUnitServicesAirTourId());
                break;
            case "包机飞行":
//                serverUnitServicesCharteredAirplaneService
                serverUnitServicesCharteredAirplaneService.delete(services.getServerUnitServicesCharteredAirplaneId());

                break;
            case "跳伞飞行":
//                serverUnitServicesParachuteFlightService
                serverUnitServicesParachuteFlightService.delete(services.getServerUnitServicesParachuteFlightId());

                break;
            case "人工增雨":
//                serverUnitServicesArtificialRainfallService
                serverUnitServicesArtificialRainfallService.delete(services.getServerUnitServicesArtificialRainfallId());

                break;
            case "直升机出租":
//                serverUnitServicesHelicopterRentalService
                serverUnitServicesHelicopterRentalService.delete(services.getServerUnitServicesHelicopterRentalId());
                break;
            default:
                break;
        }

    }

    @GetMapping("/server/deleteList")
    public Object deleteServer(@RequestParam(value = "serverIdList[]") List<Integer> serverIdList) {
        for (int serverId : serverIdList) {
            delete(serverId);
        }
        return new MyResponseBody(200, "OK");
    }

    @GetMapping("/server/search")
    public Object search(@RequestParam int accountId, String param) {
        if (param == null || "".equals(param)) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "查询参数错误");
        }
        List<ServerUnitServices> servicesList = serverUnitServicesService.selectByAccountKeyParam(accountId, param);
        return new MyResponseBody(200, "OK", servicesList);
    }

}
