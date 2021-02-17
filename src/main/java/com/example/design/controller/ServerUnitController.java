package com.example.design.controller;

import com.example.design.DesignApplication;
import com.example.design.common.ErrorCode;
import com.example.design.common.MyResponseBody;
import com.example.design.entity.*;
import com.example.design.entity.requestbean.ServerUnitLogin;
import com.example.design.entity.requestbean.ServerUnitRegister;
import com.example.design.entity.requestbean.ServerUnitServicesAdd;
import com.example.design.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
    public Object register(@RequestBody ServerUnitRegister serverUnitRegister) {
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
        serverUnitAccountService.insert(serverUnitAccount);
        serverUnitCompany.setServerUnitAccountId(serverUnitAccount.getServerUnitAccountId());
        serverUnitCompanyService.insert(serverUnitCompany);
        serverUnitAccount.setServerUnitCompanyId(serverUnitCompany.getServerUnitCompanyId());
        serverUnitAccountService.update(serverUnitAccount);

        this.log.info(serverUnitRegister.toString());
        return new MyResponseBody(200, "OK");
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody ServerUnitLogin serverUnitLogin) {
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
    public Object getCompanyInfo(@RequestParam int id) {
        ServerUnitCompany company = serverUnitCompanyService.select(id);
        if (company != null) {
            return new MyResponseBody(200, "OK", company);
        } else {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "id 错误");
        }
    }

    @PostMapping("/company/update")
    @ResponseBody
    public Object updateCompanyInfo(@RequestBody ServerUnitCompany company) {
        this.log.info(company.toString());
        serverUnitCompanyService.update(company);
        return new MyResponseBody(200, "OK");
    }

    /**
     * 还需做数据验证
     */
    @PostMapping("/server/add")
    @ResponseBody
    public Object addServer(@RequestBody ServerUnitServicesAdd addInfo) {
        if (addInfo.getServerUnitServicesTitle() == null
                || addInfo.getServerUnitServicesImg() == null
                || addInfo.getServerUnitServicesDetail() == null
                || addInfo.getServerUnitServicesType() == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数未填写全");
        }
        ServerUnitServices services = new ServerUnitServices(
                addInfo.getServerUnitServicesTitle(),
                addInfo.getServerUnitServicesImg(),
                addInfo.getServerUnitServicesDetail(),
                addInfo.getServerUnitServicesType(),
                "待审核");
        serverUnitServicesService.insert(services);
        switch (addInfo.getServerUnitServicesType()) {
            case "空中游览":
                ServerUnitServicesAirTour servicesAirTour = new ServerUnitServicesAirTour(
                        services.getServerUnitServicesId(),
                        addInfo.getServerUnitServicesAirTourSightseeingPlaces(),
                        addInfo.getServerUnitServicesAirTourDuration(),
                        addInfo.getServerUnitServicesAirTourAircraftModel(),
                        addInfo.getServerUnitServicesAirTourNumberLimit(),
                        addInfo.getServerUnitServicesAirTourBoardingLocation(),
                        addInfo.getServerUnitServicesAirTourPrice());
                serverUnitServicesAirTourService.insert(servicesAirTour);
                services.setServerUnitServicesAirTourId(servicesAirTour.getServerUnitServicesAirTourId());
                serverUnitServicesService.update(services);
                break;
            case "包机飞行":
                ServerUnitServicesCharteredAirplane charteredAirplane = new ServerUnitServicesCharteredAirplane(
                        services.getServerUnitServicesId(),
                        addInfo.getServerUnitServicesCharteredAirplaneStartAddress(),
                        addInfo.getServerUnitServicesCharteredAirplaneEndAddress(),
                        addInfo.getServerUnitServicesCharteredAirplaneAircraftModel(),
                        addInfo.getServerUnitServicesCharteredAirplaneSeatsNum(),
                        addInfo.getServerUnitServicesCharteredAirplaneBoardingLocation(),
                        addInfo.getServerUnitServicesCharteredAirplanePrice());
                serverUnitServicesCharteredAirplaneService.insert(charteredAirplane);
                services.setServerUnitServicesCharteredAirplaneId(charteredAirplane.getServerUnitServicesCharteredAirplaneId());
                serverUnitServicesService.update(services);
                break;
            case "跳伞飞行":
                ServerUnitServicesParachuteFlight parachuteFlight = new ServerUnitServicesParachuteFlight(
                        services.getServerUnitServicesId(),
                        addInfo.getServerUnitServicesParachuteFlightAddress(),
                        addInfo.getServerUnitServicesParachuteFlightAircraftModel(),
                        addInfo.getServerUnitServicesParachuteFlightPrice());
                serverUnitServicesParachuteFlightService.insert(parachuteFlight);
                services.setServerUnitServicesParachuteFlightId(parachuteFlight.getServerUnitServicesParachuteFlightId());
                serverUnitServicesService.update(services);
                break;
            case "人工增雨":
                ServerUnitServicesArtificialRainfall artificialRainfall = new ServerUnitServicesArtificialRainfall(
                        services.getServerUnitServicesId(),
                        addInfo.getServerUnitServicesArtificialRainfallAircraftModel(),
                        addInfo.getServerUnitServicesArtificialRainfallCatalyzer(),
                        addInfo.getServerUnitServicesArtificialRainfallMaxDose(),
                        addInfo.getServerUnitServicesArtificialRainfallPrice(),
                        addInfo.getServerUnitServicesArtificialRainfallPhone());
                serverUnitServicesArtificialRainfallService.insert(artificialRainfall);
                services.setServerUnitServicesArtificialRainfallId(artificialRainfall.getServerUnitServicesArtificialRainfallId());
                serverUnitServicesService.update(services);
                break;
            case "直升机出租":
                ServerUnitServicesHelicopterRental helicopterRental = new ServerUnitServicesHelicopterRental(
                        services.getServerUnitServicesId(),
                        addInfo.getServerUnitServicesHelicopterRentalAircraftModel(),
                        addInfo.getServerUnitServicesHelicopterRentalPrice(),
                        addInfo.getServerUnitServicesHelicopterRentalPhone());
                serverUnitServicesHelicopterRentalService.insert(helicopterRental);
                services.setServerUnitServicesHelicopterRentalId(helicopterRental.getServerUnitServicesHelicopterRentalId());
                serverUnitServicesService.update(services);
                break;
            default:
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "类型错误");
        }
        return new MyResponseBody(200, "OK");
    }


}
