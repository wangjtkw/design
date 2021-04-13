package com.example.design.controller;

import com.example.design.DesignApplication;
import com.example.design.common.ErrorCode;
import com.example.design.common.MyResponseBody;
import com.example.design.common.UploadUtils;
import com.example.design.entity.requestbean.server.ServerUnitLogin;
import com.example.design.entity.requestbean.server.ServerUnitRegister;
import com.example.design.entity.requestbean.server.ServerUnitServicesAdd;
import com.example.design.entity.requestbean.server.ServerUnitUpdatePW;
import com.example.design.entity.responsebean.OrderDetailBean;
import com.example.design.entity.responsebean.ServerUnitServicesDetail;
import com.example.design.entity.responsebean.UserDetailBean;
import com.example.design.entity.responsebean.UserPayBean;
import com.example.design.entity.server.*;
import com.example.design.entity.user.*;
import com.example.design.service.server.*;
import com.example.design.service.user.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
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

    @Autowired
    private UsersOrderService usersOrderService;

    @Autowired
    private UsersOrdersConfigAirTourService usersOrdersConfigAirTourService;

    @Autowired
    private UsersOrdersConfigCharteredAirplaneService usersOrdersConfigCharteredAirplaneService;

    @Autowired
    private UsersOrdersConfigParachuteFlightService usersOrdersConfigParachuteFlightService;

    @Autowired
    private UsersAccountService usersAccountService;

    @Autowired
    private UsersEssentialInfoService usersEssentialInfoService;

    /**
     * 需要做账号、密码、邮箱的格式检查
     */
    @RequestMapping("/register")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object register(@RequestBody ServerUnitRegister serverUnitRegister) {
        this.log.info(serverUnitRegister.toString());
        this.log.info(serverUnitRegister.toString());
        //账户、密码、邮箱、企业名称、基地、机场、资本、法人姓名、法人联系方式、经营范围、企业类型、有效期
        if (serverUnitRegister.getServerUnitAccountAccount() == null
                || serverUnitRegister.getServerUnitAccountAccount().isEmpty()
                || serverUnitRegister.getServerUnitAccountPassword() == null
                || serverUnitRegister.getServerUnitAccountPassword().isEmpty()
                || serverUnitRegister.getServerUnitAccountEmail() == null
                || serverUnitRegister.getServerUnitAccountEmail().isEmpty()
                || serverUnitRegister.getServerUnitCompanyName() == null
                || serverUnitRegister.getServerUnitCompanyName().isEmpty()
                || serverUnitRegister.getServerUnitCompanyBase() == null
                || serverUnitRegister.getServerUnitCompanyBase().isEmpty()
                || serverUnitRegister.getServerUnitCompanyAirport() == null
                || serverUnitRegister.getServerUnitCompanyAirport().isEmpty()
                || serverUnitRegister.getServerUnitCompanyCapital() == null
                || serverUnitRegister.getServerUnitCompanyCapital().isEmpty()
                || serverUnitRegister.getServerUnitCompanyLegalRepresentativeName() == null
                || serverUnitRegister.getServerUnitCompanyLegalRepresentativeName().isEmpty()
                || serverUnitRegister.getServerUnitCompanyLegalRepresentativePhone() == null
                || serverUnitRegister.getServerUnitCompanyLegalRepresentativePhone().isEmpty()
                || serverUnitRegister.getServerUnitCompanyScope() == null
                || serverUnitRegister.getServerUnitCompanyScope().isEmpty()
                || serverUnitRegister.getServerUnitCompanyType() == null
                || serverUnitRegister.getServerUnitCompanyType().isEmpty()
                || serverUnitRegister.getServerUnitCompanyValidityTerm() == null
                || serverUnitRegister.getServerUnitCompanyValidityTerm().isEmpty()) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE);
        }
        //如果账户已存在
        if (serverUnitAccountService.getServerUnitAccountByAccount(
                serverUnitRegister.getServerUnitAccountAccount()) != null) {
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

    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestBody ServerUnitLogin serverUnitLogin) {
        System.out.println(serverUnitLogin);
        if (serverUnitLogin == null
                || serverUnitLogin.getServerUnitAccountAccount() == null
                || serverUnitLogin.getServerUnitAccountAccount().isEmpty()
                || serverUnitLogin.getServerUnitAccountPassword() == null
                || serverUnitLogin.getServerUnitAccountPassword().isEmpty()) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE,
                    ErrorCode.PARAMETER_ERROR_DESCRIBE);
        }
        ServerUnitAccount account = serverUnitAccountService.getServerUnitAccountByAccount(
                serverUnitLogin.getServerUnitAccountAccount());
        if (account != null && account.getServerUnitAccountPassword().equals(
                serverUnitLogin.getServerUnitAccountPassword())) {
            account.setServerUnitAccountPassword("");
            return new MyResponseBody(200, "OK", account);
        } else {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE,
                    ErrorCode.PARAMETER_ERROR_DESCRIBE + "账号或密码错误");
        }
    }

    @RequestMapping("/update/pw")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object updatePassword(@RequestBody ServerUnitUpdatePW serverUnitUpdatePW) {
        if (serverUnitUpdatePW == null
                || serverUnitUpdatePW.getServerUnitAccountId() == null
                || serverUnitUpdatePW.getOldPW() == null
                || serverUnitUpdatePW.getOldPW().isEmpty()
                || serverUnitUpdatePW.getNewPW() == null
                || serverUnitUpdatePW.getNewPW().isEmpty()) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "密码不能为空");
        }
        ServerUnitAccount account = serverUnitAccountService.selectByKey(serverUnitUpdatePW.getServerUnitAccountId());
        if (account == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "用户id不存在");
        }
        if (!account.getServerUnitAccountPassword().equals(serverUnitUpdatePW.getOldPW())) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "旧密码错误");
        }
        account.setServerUnitAccountPassword(serverUnitUpdatePW.getNewPW());
        serverUnitAccountService.update(account);
        return new MyResponseBody(200, "OK");


    }

    @RequestMapping("/company/get")
    public Object getCompanyInfo(int companyId) {
        ServerUnitCompany company = serverUnitCompanyService.select(companyId);
        if (company != null) {
            return new MyResponseBody(200, "OK", company);
        } else {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "id 错误");
        }
    }

    @RequestMapping("/company/update")
    @ResponseBody
    public Object updateCompanyInfo(@RequestBody ServerUnitCompany company) {
        this.log.info(company.toString());
        serverUnitCompanyService.update(company);
        return new MyResponseBody(200, "OK");
    }

    /**
     * 还需做数据验证
     */
    @RequestMapping("/server/add")
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
                || addInfo.getServerUnitServicesTitle().isEmpty()
                || addInfo.getServerUnitServicesDetail() == null
                || addInfo.getServerUnitServicesDetail().isEmpty()
                || addInfo.getServerUnitServicesType() == null
                || addInfo.getServerUnitServicesType().isEmpty()
                || addInfo.getServerUnitServicesPhone() == null
                || addInfo.getServerUnitServicesPhone().isEmpty()) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数未填写全");
        }
        ServerUnitServices services = new ServerUnitServices(
                addInfo.getServerUnitAccountId(),
                addInfo.getServerUnitServicesTitle(),
                imgName,
                addInfo.getServerUnitServicesDetail(),
                addInfo.getServerUnitServicesType(),
                "待审批",
                addInfo.getServerUnitServicesPhone());
        switch (addInfo.getServerUnitServicesType()) {
            case "空中游览":
                if (addInfo.getServerUnitServicesAirTourSightseeingPlaces() == null
                        || addInfo.getServerUnitServicesAirTourSightseeingPlaces().isEmpty()
                        || addInfo.getServerUnitServicesAirTourDuration() == null
                        || addInfo.getServerUnitServicesAirTourDuration().isEmpty()
                        || addInfo.getServerUnitServicesAirTourAircraftModel() == null
                        || addInfo.getServerUnitServicesAirTourAircraftModel().isEmpty()
                        || addInfo.getServerUnitServicesAirTourNumberLimit() == null
                        || addInfo.getServerUnitServicesAirTourNumberLimit().isEmpty()
                        || addInfo.getServerUnitServicesAirTourBoardingLocation() == null
                        || addInfo.getServerUnitServicesAirTourBoardingLocation().isEmpty()
                        || addInfo.getServerUnitServicesAirTourPrice() == null
                        || addInfo.getServerUnitServicesAirTourPrice().isEmpty()) {
                    return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数未填写全");
                }

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
                if (addInfo.getServerUnitServicesCharteredAirplaneStartAddress() == null
                        || addInfo.getServerUnitServicesCharteredAirplaneStartAddress().isEmpty()
                        || addInfo.getServerUnitServicesCharteredAirplaneEndAddress() == null
                        || addInfo.getServerUnitServicesCharteredAirplaneEndAddress().isEmpty()
                        || addInfo.getServerUnitServicesCharteredAirplaneAircraftModel() == null
                        || addInfo.getServerUnitServicesCharteredAirplaneAircraftModel().isEmpty()
                        || addInfo.getServerUnitServicesCharteredAirplaneSeatsNum() == null
                        || addInfo.getServerUnitServicesCharteredAirplaneSeatsNum().isEmpty()
                        || addInfo.getServerUnitServicesCharteredAirplaneBoardingLocation() == null
                        || addInfo.getServerUnitServicesCharteredAirplaneBoardingLocation().isEmpty()
                        || addInfo.getServerUnitServicesCharteredAirplanePrice() == null
                        || addInfo.getServerUnitServicesCharteredAirplanePrice().isEmpty()) {
                    return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数未填写全");
                }
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
                if (addInfo.getServerUnitServicesParachuteFlightAddress() == null
                        || addInfo.getServerUnitServicesParachuteFlightAddress().isEmpty()
                        || addInfo.getServerUnitServicesParachuteFlightAircraftModel() == null
                        || addInfo.getServerUnitServicesParachuteFlightAircraftModel().isEmpty()
                        || addInfo.getServerUnitServicesParachuteFlightPrice() == null
                        || addInfo.getServerUnitServicesParachuteFlightPrice().isEmpty()) {
                    return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数未填写全");
                }
                ServerUnitServicesParachuteFlight parachuteFlight = new ServerUnitServicesParachuteFlight(
                        addInfo.getServerUnitServicesParachuteFlightAddress(),
                        addInfo.getServerUnitServicesParachuteFlightAircraftModel(),
                        addInfo.getServerUnitServicesParachuteFlightPrice());
                serverUnitServicesParachuteFlightService.insert(parachuteFlight);
                services.setServerUnitServicesParachuteFlightId(parachuteFlight.getServerUnitServicesParachuteFlightId());
//                serverUnitServicesService.update(services);
                break;
            case "人工增雨":
                if (addInfo.getServerUnitServicesArtificialRainfallAircraftModel() == null
                        || addInfo.getServerUnitServicesArtificialRainfallAircraftModel().isEmpty()
                        || addInfo.getServerUnitServicesArtificialRainfallCatalyzer() == null
                        || addInfo.getServerUnitServicesArtificialRainfallCatalyzer().isEmpty()
                        || addInfo.getServerUnitServicesArtificialRainfallMaxDose() == null
                        || addInfo.getServerUnitServicesArtificialRainfallMaxDose().isEmpty()
                        || addInfo.getServerUnitServicesArtificialRainfallPrice() == null
                        || addInfo.getServerUnitServicesArtificialRainfallPrice().isEmpty()) {
                    return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数未填写全");
                }

                ServerUnitServicesArtificialRainfall artificialRainfall = new ServerUnitServicesArtificialRainfall(
                        addInfo.getServerUnitServicesArtificialRainfallAircraftModel(),
                        addInfo.getServerUnitServicesArtificialRainfallCatalyzer(),
                        addInfo.getServerUnitServicesArtificialRainfallMaxDose(),
                        addInfo.getServerUnitServicesArtificialRainfallPrice());
                serverUnitServicesArtificialRainfallService.insert(artificialRainfall);
                services.setServerUnitServicesArtificialRainfallId(artificialRainfall.getServerUnitServicesArtificialRainfallId());
//                serverUnitServicesService.update(services);
                break;
            case "直升机出租":
                if (addInfo.getServerUnitServicesHelicopterRentalAircraftModel() == null
                        || addInfo.getServerUnitServicesHelicopterRentalAircraftModel().isEmpty()
                        || addInfo.getServerUnitServicesHelicopterRentalPrice() == null
                        || addInfo.getServerUnitServicesHelicopterRentalPrice().isEmpty()) {

                }
                ServerUnitServicesHelicopterRental helicopterRental = new ServerUnitServicesHelicopterRental(
                        addInfo.getServerUnitServicesHelicopterRentalAircraftModel(),
                        addInfo.getServerUnitServicesHelicopterRentalPrice());
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

    @RequestMapping("/server/detail")
    @ResponseBody
    public Object getServer(int serverId) {
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

    @RequestMapping("/server/update")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object updateServer(@RequestBody(required = false) MultipartFile file, ServerUnitServicesAdd addInfo) {
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
                addInfo.getServerUnitAccountId(),
                addInfo.getServerUnitServicesTitle(),
                addInfo.getServerUnitServicesImg(),
                addInfo.getServerUnitServicesDetail(),
                addInfo.getServerUnitServicesType(),
                "待审批",
                addInfo.getServerUnitServicesPhone()
        );
        System.out.println(services.getServerUnitServicesImg());
        int result;
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
                        addInfo.getServerUnitServicesArtificialRainfallPrice()
                );
                result = serverUnitServicesArtificialRainfallService.update(artificialRainfall);
                break;
            case "直升机出租":
                ServerUnitServicesHelicopterRental helicopterRental = new ServerUnitServicesHelicopterRental(
                        addInfo.getServerUnitServicesHelicopterRentalId(),
                        addInfo.getServerUnitServicesHelicopterRentalAircraftModel(),
                        addInfo.getServerUnitServicesHelicopterRentalPrice()
                );
                result = serverUnitServicesHelicopterRentalService.update(helicopterRental);
                break;
            default:
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.DUPLICATE_ACCOUNT_NUMBER_DESCRIBE + "服务类型错误");
        }
        if (result != 1) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "服务具体类型id错误");
        }
        System.out.println("servises:" + services);
        serverUnitServicesService.update(services);
        return new MyResponseBody(200, "OK");
    }

    @RequestMapping("/server/list")
    public Object getServerList(int accountId) {
        List<ServerUnitServices> result = serverUnitServicesService.selectByAccountKey(accountId);
        return new MyResponseBody(200, "OK", result);
    }

    @RequestMapping("/test/img")
    public Object uploadImg(@RequestBody MultipartFile file) {
        if (file.isEmpty()) {
            return new MyResponseBody(ErrorCode.PICTURE_ERROR_CODE, ErrorCode.PICTURE_ERROR_DESCRIBE + "服务图片不能为空");
        }
        String imgName = UploadUtils.uploadImg(file);
        if (imgName == null) {
            return new MyResponseBody(ErrorCode.PICTURE_ERROR_CODE, ErrorCode.PICTURE_ERROR_DESCRIBE + "图片上传错误");
        }
        return new MyResponseBody(200, "OK", imgName);
    }

    @RequestMapping("/server/deleteSingle")
    public Object deleteServer(int serverId) {
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

    @RequestMapping("/server/deleteList")
    public Object deleteServer(@RequestParam(value = "serverIdList[]") List<Integer> serverIdList) {
        for (int serverId : serverIdList) {
            delete(serverId);
        }
        return new MyResponseBody(200, "OK");
    }

    @RequestMapping("/server/search")
    public Object search(int accountId, String param) {
        if (param == null || "".equals(param)) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "查询参数错误");
        }
        List<ServerUnitServices> servicesList = serverUnitServicesService.selectByAccountKeyParam(accountId, param);
        return new MyResponseBody(200, "OK", servicesList);
    }

    @RequestMapping("get/order/list")
    @ResponseBody
    public Object getOrderList(int serverUnitId) {
        List<UsersOrders> ordersList = usersOrderService.selectByServerUnitAccount(serverUnitId);
        List<OrderDetailBean> result = new ArrayList<>();
        for (UsersOrders orders : ordersList) {
            UserPayBean payBean = getUserPayBean(orders);
            if (payBean == null) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            int usersAccountId = payBean.getUsersAccountId();
            if (usersAccountId == 0) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            UserDetailBean detailBean = getUserDetail(usersAccountId);
            if (detailBean == null) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            int serverId = payBean.getServerUnitServicesId();
            if (serverId == 0) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            ServerUnitServicesDetail serverDetail = getServerUnitService(serverId);
            if (serverDetail == null) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            OrderDetailBean orderDetailBean = new OrderDetailBean();
            payBean.setUsersOrdersOrderCode(orderCodeId(payBean.getUsersOrdersId()));
            orderDetailBean.setPayBean(payBean);
            orderDetailBean.setUserDetailBean(detailBean);
            orderDetailBean.setServerUnitServicesDetail(serverDetail);
            result.add(orderDetailBean);
        }
        return new MyResponseBody(200, "OK", result);
    }

    @RequestMapping("/get/order/detail")
    @ResponseBody
    public Object getOrderDetail(int orderId) {
        UsersOrders orders = usersOrderService.selectById(orderId);
        if (orders == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "订单id错误");
        }
        UserPayBean payBean = getUserPayBean(orders);
        if (payBean == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
        }
        int usersAccountId = payBean.getUsersAccountId();
        if (usersAccountId == 0) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
        }
        UserDetailBean detailBean = getUserDetail(usersAccountId);
        if (detailBean == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
        }
        int serverId = payBean.getServerUnitServicesId();
        if (serverId == 0) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
        }
        ServerUnitServicesDetail serverDetail = getServerUnitService(serverId);
        if (serverDetail == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
        }
        OrderDetailBean orderDetailBean = new OrderDetailBean();
        payBean.setUsersOrdersOrderCode(orderCodeId(payBean.getUsersOrdersId()));
        orderDetailBean.setPayBean(payBean);
        orderDetailBean.setUserDetailBean(detailBean);
        orderDetailBean.setServerUnitServicesDetail(serverDetail);
        return new MyResponseBody(200, "OK", orderDetailBean);
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public UserPayBean getUserPayBean(UsersOrders orders) {
        if (orders == null) {
            return null;
        }
        UserPayBean payBean = new UserPayBean(
                orders.getUsersOrdersId(),
                orders.getServerUnitAccountId(),
                orders.getUsersAccountId(),
                orders.getServerUnitServicesId(),
                orders.getUsersOrdersConfigAirTourId(),
                orders.getUsersOrdersConfigCharteredAirplaneId(),
                orders.getUsersOrdersConfigParachuteFlightId(),
                orders.getUsersOrdersOrderState(),
                orders.getUsersOrdersServerType(),
                orders.getUsersOrdersMoney(),
                orders.getUsersOrdersTimeCreate(),
                orders.getUsersOrdersTimePay(),
                orders.getUsersOrdersTimeFinish(),
                orders.getUsersOrdersOrderCode()
        );

        switch (orders.getUsersOrdersServerType()) {
            case "空中游览":
                UsersOrdersConfigAirTour airTour = usersOrdersConfigAirTourService.selectById(orders.getUsersOrdersConfigAirTourId());
                if (airTour == null) {
                    return null;
                }
                payBean.setUsersOrdersConfigAirTourDuration(airTour.getUsersOrdersConfigAirTourDuration());
                payBean.setUsersOrdersConfigAirTourNumber(airTour.getUsersOrdersConfigAirTourNumber());
                payBean.setUsersOrdersConfigAirTourAircraftModel(airTour.getUsersOrdersConfigAirTourAircraftModel());
                payBean.setUsersOrdersConfigAirTourScheduledTime(airTour.getUsersOrdersConfigAirTourScheduledTime());
                break;
            case "包机飞行":
                UsersOrdersConfigCharteredAirplane charteredAirplane = usersOrdersConfigCharteredAirplaneService.selectById(orders.getUsersOrdersConfigCharteredAirplaneId());
                if (charteredAirplane == null) {
                    return null;
                }
                payBean.setUsersOrdersConfigCharteredAirplaneAircraftModel(charteredAirplane.getUsersOrdersConfigCharteredAirplaneAircraftModel());
                payBean.setUsersOrdersConfigCharteredAirplaneScheduledTime(charteredAirplane.getUsersOrdersConfigCharteredAirplaneScheduledTime());
                break;
            case "跳伞飞行":
                UsersOrdersConfigParachuteFlight parachuteFlight = usersOrdersConfigParachuteFlightService.selectById(orders.getUsersOrdersConfigParachuteFlightId());
                if (parachuteFlight == null) {
                    return null;
                }
                payBean.setUsersOrdersConfigParachuteFlightType(parachuteFlight.getUsersOrdersConfigParachuteFlightType());
                payBean.setUsersOrdersConfigParachuteFlightNeedHold(parachuteFlight.getUsersOrdersConfigParachuteFlightNeedHold());
                payBean.setUsersOrdersConfigParachuteFlightNeedTripartite(parachuteFlight.getUsersOrdersConfigParachuteFlightNeedTripartite());
                payBean.setUsersOrdersConfigAirTourScheduledTime(parachuteFlight.getUsersOrdersConfigParachuteFlightScheduledTime());
                payBean.setUsersOrdersConfigParachuteFlightPersonNum(parachuteFlight.getUsersOrdersConfigParachuteFlightPersonNum());
                break;
            default:
                return null;
        }
        return payBean;
    }

    public UserDetailBean getUserDetail(int userAccountId) {
        UsersAccount account = usersAccountService.getUserByKey(userAccountId);
        if (account == null) {
            return null;
        }
        UsersEssentialInformation essentialInformation = usersEssentialInfoService.getById(account.getUsersEssentialInformationId());
        if (essentialInformation == null) {
            return null;
        }
        return new UserDetailBean(
                account.getUsersAccountId(),
                account.getUsersEssentialInformationId(),
                account.getUsersAccountAccount(),
                account.getUsersAccountEmail(),
                essentialInformation.getUsersEssentialInformationName(),
                essentialInformation.getUsersEssentialInformationIdNumber(),
                essentialInformation.getUsersEssentialInformationCompany()
        );

    }

    public ServerUnitServicesDetail getServerUnitService(int serverId) {
        ServerUnitServices services = serverUnitServicesService.select(serverId);
        if (services == null) {
            return null;
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
                return null;
        }
        return new ServerUnitServicesDetail(services, iServerUnitService);
    }

    @RequestMapping("/delete/order")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object deleteOrder(int orderId) {
        UsersOrders orders = usersOrderService.selectById(orderId);
        if (orders != null) {
            orders.setUsersOrdersUnitDelete(true);
            usersOrderService.updateBySelective(orders);
        }
        return new MyResponseBody(200, "OK");
    }

    @RequestMapping("get/order/list/param")
    @ResponseBody
    public Object select(int serverAccountId, String param) {
        List<UsersOrders> ordersList = usersOrderService.selectByServerUnitAccountParam(serverAccountId, param);
        List<OrderDetailBean> result = new ArrayList<>();
        for (UsersOrders orders : ordersList) {
            UserPayBean payBean = getUserPayBean(orders);
            if (payBean == null) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            int usersAccountId = payBean.getUsersAccountId();
            if (usersAccountId == 0) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            UserDetailBean detailBean = getUserDetail(usersAccountId);
            if (detailBean == null) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            int serverId = payBean.getServerUnitServicesId();
            if (serverId == 0) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            ServerUnitServicesDetail serverDetail = getServerUnitService(serverId);
            if (serverDetail == null) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            OrderDetailBean orderDetailBean = new OrderDetailBean();
            payBean.setUsersOrdersOrderCode(orderCodeId(payBean.getUsersOrdersId()));
            orderDetailBean.setPayBean(payBean);
            orderDetailBean.setUserDetailBean(detailBean);
            orderDetailBean.setServerUnitServicesDetail(serverDetail);
            result.add(orderDetailBean);
        }
        return new MyResponseBody(200, "OK", result);
    }

    private String orderCodeId(int orderId) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(orderId);
        int max = 10 - stringBuilder.length();
        while (max > 0) {
            stringBuilder.insert(0, "0");
            max--;
        }
        return stringBuilder.toString();
    }
}
