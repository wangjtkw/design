package com.example.design.controller;

import com.example.design.common.ErrorCode;
import com.example.design.common.MyResponseBody;
import com.example.design.entity.admin.AdministratorsAccount;
import com.example.design.entity.requestbean.admin.AdminLogin;
import com.example.design.entity.responsebean.ServerUnitServicesDetail;
import com.example.design.entity.server.IServerUnitService;
import com.example.design.entity.server.ServerUnitCompany;
import com.example.design.entity.server.ServerUnitServices;
import com.example.design.service.admin.AdminService;
import com.example.design.service.server.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

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


    @PostMapping("/login")
    @ResponseBody
    public Object login(AdminLogin adminLogin) {
        if (adminLogin == null
                || adminLogin.getAdminAccount() == null
                || adminLogin.getAdminAccount().equals("")
                || adminLogin.getAdminPW() == null
                || adminLogin.getAdminPW().equals("")) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "账号或密码错误");
        }
        AdministratorsAccount account = adminService.getAccount(adminLogin.getAdminAccount());
        if (account == null || !account.getAdministratorsAccountPassword().equals(adminLogin.getAdminPW())) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "账号或密码错误");
        }
        return new MyResponseBody(200, "OK");
    }

    @GetMapping("/get/company/list")
    @ResponseBody
    public Object getCompanyList() {
        return new MyResponseBody(200, "OK", serverUnitCompanyService.selectByStatus("待审批"));
    }

    @GetMapping("/get/company/detail")
    @ResponseBody
    public Object getCompanyDetail(int companyId) {
        ServerUnitCompany company = serverUnitCompanyService.select(companyId);
        if (company == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "企业编号不存在");
        }
        return new MyResponseBody(200, "OK", company);
    }

    @GetMapping("/update/company/adopt")
    @ResponseBody
    public Object updateCompanyAdopt(int companyId) {
        ServerUnitCompany company = serverUnitCompanyService.select(companyId);
        if (company == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "企业编号不存在");
        }
        company.setServerUnitCompanyAuditStatus("审批通过");
        serverUnitCompanyService.update(company);
        return new MyResponseBody(200, "OK");
    }

    @GetMapping("/update/company/refuse")
    @ResponseBody
    public Object updateCompanyRefuse(int companyId) {
        ServerUnitCompany company = serverUnitCompanyService.select(companyId);
        if (company == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "企业编号不存在");
        }
        company.setServerUnitCompanyAuditStatus("审批未通过");
        serverUnitCompanyService.update(company);
        return new MyResponseBody(200, "OK");
    }

    @GetMapping("/get/company/param")
    @ResponseBody
    public Object selectCompany(String param) {
        return new MyResponseBody(200, "OK", serverUnitCompanyService.selectByParam(param));
    }

    @GetMapping("/get/server/list")
    @ResponseBody
    public Object getServerList() {
        return new MyResponseBody(200, "OK", serverUnitServicesService.selectByStatus("待审批"));
    }

    @GetMapping("/get/server/detail")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object getServerDetail(int serverId) {
        ServerUnitServices services = serverUnitServicesService.select(serverId);
        if (services == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "服务编号不存在");
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

    @GetMapping("/update/server/adopt")
    @ResponseBody
    public Object updateServerAdopt(int serverId) {
        ServerUnitServices services = serverUnitServicesService.select(serverId);
        if (services == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "服务编号不存在");
        }
        services.setServerUnitServicesAuditStatus("审批通过");
        serverUnitServicesService.update(services);
        return new MyResponseBody(200, "OK");
    }

    @GetMapping("/update/server/refuse")
    @ResponseBody
    public Object updateServerRefuse(int serverId) {
        ServerUnitServices services = serverUnitServicesService.select(serverId);
        if (services == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "服务编号不存在");
        }
        services.setServerUnitServicesAuditStatus("审批未通过");
        serverUnitServicesService.update(services);
        return new MyResponseBody(200, "OK");
    }

    @GetMapping("/get/server/param")
    @ResponseBody
    public Object selectServer(String param) {
        return new MyResponseBody(200, "OK", serverUnitServicesService.selectByParam(param));
    }
}
