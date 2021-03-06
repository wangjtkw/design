package com.example.design.controller;

import com.example.design.common.ErrorCode;
import com.example.design.common.MyResponseBody;
import com.example.design.entity.admin.AdministratorsAccount;
import com.example.design.entity.requestbean.admin.AdminLogin;
import com.example.design.entity.responsebean.UserDetailBean;
import com.example.design.entity.responsebean.ServerUnitServicesDetail;
import com.example.design.entity.responsebean.UserServerItemDetailBean;
import com.example.design.entity.responsebean.UserServerTypeItemBean;
import com.example.design.entity.server.IServerUnitService;
import com.example.design.entity.server.ServerUnitAccount;
import com.example.design.entity.server.ServerUnitCompany;
import com.example.design.entity.server.ServerUnitServices;
import com.example.design.entity.user.UsersAccount;
import com.example.design.entity.user.UsersEssentialInformation;
import com.example.design.service.admin.AdminService;
import com.example.design.service.server.*;
import com.example.design.service.user.UsersAccountService;
import com.example.design.service.user.UsersEssentialInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

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
    private UsersAccountService usersAccountService;

    @Autowired
    private UsersEssentialInfoService usersEssentialInfoService;

    @PostMapping("/login")
    @ResponseBody
    public Object login(AdminLogin adminLogin) {
        if (adminLogin == null
                || adminLogin.getAdminAccount() == null
                || adminLogin.getAdminAccount().isEmpty()
                || adminLogin.getAdminPW() == null
                || adminLogin.getAdminPW().isEmpty()) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "账号或密码错误");
        }
        AdministratorsAccount account =
                adminService.getAccount(
                        adminLogin.getAdminAccount());


        if (account == null ||
                !account.getAdministratorsAccountPassword()
                        .equals(adminLogin.getAdminPW())) {


            return new MyResponseBody(
                    ErrorCode.PARAMETER_ERROR_CODE,
                    ErrorCode.PARAMETER_ERROR_DESCRIBE + "账号或密码错误");
        }

        return new MyResponseBody(200, "OK");
    }

    @GetMapping("/get/company/list")
    @ResponseBody
    public Object getCompanyList() {
        return new MyResponseBody(200, "OK",
                serverUnitCompanyService.selectByStatus("待审批"));
    }


    @GetMapping("/get/company/detail")
    @ResponseBody
    public Object getCompanyDetail(int companyId) {
        ServerUnitCompany company = serverUnitCompanyService.select(companyId);
        if (company == null) {
            return new MyResponseBody(
                    ErrorCode.PARAMETER_ERROR_CODE,
                    ErrorCode.PARAMETER_ERROR_DESCRIBE + "企业编号不存在");
        }
        return new MyResponseBody(200, "OK", company);
    }

    @GetMapping("/update/company/adopt")
    @ResponseBody
    public Object updateCompanyAdopt(int companyId) {
        ServerUnitCompany company = serverUnitCompanyService.select(companyId);
        if (company == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE,
                    ErrorCode.PARAMETER_ERROR_DESCRIBE + "企业编号不存在");
        }
        if (!company.getServerUnitCompanyAuditStatus().equals("待审批")) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE,
                    ErrorCode.PARAMETER_ERROR_DESCRIBE +
                            "企业信息状态不为待审批");
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
        if (!company.getServerUnitCompanyAuditStatus().equals("待审批")) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "订单状态不为待审批");
        }
        company.setServerUnitCompanyAuditStatus("审批未通过");
        serverUnitCompanyService.update(company);
        return new MyResponseBody(200, "OK");
    }

    @GetMapping("/get/company/param")
    @ResponseBody
    public Object selectCompany(String param) {
        return new MyResponseBody(200,
                "OK", serverUnitCompanyService.selectByParam(param));
    }

    @GetMapping("/get/server/list")
    @ResponseBody
    public Object getServerList() {
        List<ServerUnitServices> services;
        services = serverUnitServicesService.selectByStatus("待审批");

        List<UserServerTypeItemBean> result = new ArrayList<>();
        for (ServerUnitServices service : services) {

            ServerUnitCompany company = serverUnitCompanyService.selectByServerId(
                    service.getServerUnitServicesId());

            UserServerTypeItemBean serverTypeItemBean = new UserServerTypeItemBean(
                    service, company);

            result.add(serverTypeItemBean);
        }
        return new MyResponseBody(200, "OK", result);
    }

    /**
     * 增加的
     *
     * @param type
     * @return
     */
    @GetMapping("/get/server/list/type")
    @ResponseBody
    public Object getServerListType(String type) {
        switch (type) {
            case "空中游览":
            case "包机飞行":
            case "跳伞飞行":
            case "人工增雨":
            case "直升机出租":
                break;
            default:
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "请求参数错误");
        }
        List<ServerUnitServices> services;
        services = serverUnitServicesService.selectByStatusType("待审批", type);

        List<UserServerTypeItemBean> result = new ArrayList<>();
        for (ServerUnitServices service : services) {
            ServerUnitCompany company = serverUnitCompanyService.selectByServerId(service.getServerUnitServicesId());
            UserServerTypeItemBean serverTypeItemBean = new UserServerTypeItemBean(service, company);
            result.add(serverTypeItemBean);
        }
        return new MyResponseBody(200, "OK", result);
    }


    @GetMapping("/get/server/detail")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object getServerDetail(int serverId) {
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
        ServerUnitCompany company = serverUnitCompanyService.selectByServerId(services.getServerUnitServicesId());
        UserServerItemDetailBean detailBean = new UserServerItemDetailBean(services, iServerUnitService, company);
        return new MyResponseBody(200, "OK", detailBean);

//        ServerUnitServices services = serverUnitServicesService.select(serverId);
//        if (services == null) {
//            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "服务编号不存在");
//        }
//        IServerUnitService iServerUnitService;
//        switch (services.getServerUnitServicesType()) {
//            case "空中游览":
//                iServerUnitService = serverUnitServicesAirTourService.select(services.getServerUnitServicesAirTourId());
//                break;
//            case "包机飞行":
//                iServerUnitService = serverUnitServicesCharteredAirplaneService.select(services.getServerUnitServicesCharteredAirplaneId());
//                break;
//            case "跳伞飞行":
//                iServerUnitService = serverUnitServicesParachuteFlightService.select(services.getServerUnitServicesParachuteFlightId());
//                break;
//            case "人工增雨":
//                iServerUnitService = serverUnitServicesArtificialRainfallService.select(services.getServerUnitServicesArtificialRainfallId());
//                break;
//            case "直升机出租":
//                iServerUnitService = serverUnitServicesHelicopterRentalService.select(services.getServerUnitServicesHelicopterRentalId());
//                break;
//            default:
//                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "id错误");
//        }
//        return new MyResponseBody(200, "OK", new ServerUnitServicesDetail(services, iServerUnitService));
    }

    @GetMapping("/update/server/adopt")
    @ResponseBody
    public Object updateServerAdopt(int serverId) {
        ServerUnitServices services = serverUnitServicesService.select(serverId);
        if (services == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "服务编号不存在");
        }
        if (!services.getServerUnitServicesAuditStatus().equals("待审批")) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "服务状态不为待审批");
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
        if (!services.getServerUnitServicesAuditStatus().equals("待审批")) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "服务状态不为待审批");
        }
        services.setServerUnitServicesAuditStatus("审批未通过");
        serverUnitServicesService.update(services);
        return new MyResponseBody(200, "OK");
    }

    @GetMapping("/get/server/param")
    @ResponseBody
    public Object selectServer(String param) {
        List<ServerUnitServices> services;
        services = serverUnitServicesService.selectByParam(param);

        List<UserServerTypeItemBean> result = new ArrayList<>();
        for (ServerUnitServices service : services) {
            ServerUnitCompany company = serverUnitCompanyService.selectByServerId(service.getServerUnitServicesId());
            UserServerTypeItemBean serverTypeItemBean = new UserServerTypeItemBean(service, company);
            result.add(serverTypeItemBean);
        }
        return new MyResponseBody(200, "OK", result);
    }

    @GetMapping("/get/server/param/type")
    @ResponseBody
    public Object selectServer(String type, String param) {
        switch (type) {
            case "空中游览":
            case "包机飞行":
            case "跳伞飞行":
            case "人工增雨":
            case "直升机出租":
                break;
            default:
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "查询参数错误");
        }
        List<ServerUnitServices> services;
        services = serverUnitServicesService.selectByParamType(param, type);

        List<UserServerTypeItemBean> result = new ArrayList<>();
        for (ServerUnitServices service : services) {
            ServerUnitCompany company = serverUnitCompanyService.selectByServerId(service.getServerUnitServicesId());
            UserServerTypeItemBean serverTypeItemBean = new UserServerTypeItemBean(service, company);
            result.add(serverTypeItemBean);
        }
        return new MyResponseBody(200, "OK", result);
    }

    @GetMapping("/get/serverUnit/list")
    @ResponseBody
    public Object getServerUnitList() {
        List<ServerUnitCompany> list = serverUnitCompanyService.selectAll();
        return new MyResponseBody(200, "OK", list);
    }

    @GetMapping("/get/serverUnit/detail")
    @ResponseBody
    public Object getServerUnitDetail(int companyId) {
        ServerUnitCompany company = serverUnitCompanyService.select(companyId);
        if (company == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "运行单位企业信息编号不存在");
        }
        return new MyResponseBody(200, "OK", company);
    }

    @GetMapping("/get/serverUnit/param")
    @ResponseBody
    public Object getServerUnitByParam(String param) {
        List<ServerUnitCompany> companyList = serverUnitCompanyService.selectAllByParam(param);
        return new MyResponseBody(200, "OK", companyList);
    }

    /**
     * 待测试
     *
     * @param companyId
     * @return
     */
    @GetMapping("/delete/serverUnit")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object deleteServerUnit(int companyId) {
        List<ServerUnitServices> servicesList =
                serverUnitServicesService.selectByCompanyId(companyId);
        for (ServerUnitServices service : servicesList) {

            delete(service.getServerUnitServicesId());
        }
        ServerUnitAccount account =
                serverUnitAccountService.selectByCompanyId(companyId);

        serverUnitAccountService.delete(account.getServerUnitAccountId());
        serverUnitCompanyService.delete(companyId);
        return new MyResponseBody(200, "OK");
    }



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

    @GetMapping("/get/user/list")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object getUserList() {
        List<UsersAccount> accountList = usersAccountService.getAll();
        List<UserDetailBean> userList = new ArrayList<>();
        for (UsersAccount account : accountList) {
            UsersEssentialInformation essentialInformation = usersEssentialInfoService.getById(account.getUsersEssentialInformationId());
            UserDetailBean bean = new UserDetailBean(
                    account.getUsersAccountId(),
                    account.getUsersEssentialInformationId(),
                    account.getUsersAccountAccount(),
                    account.getUsersAccountEmail(),
                    essentialInformation.getUsersEssentialInformationName(),
                    essentialInformation.getUsersEssentialInformationIdNumber(),
                    essentialInformation.getUsersEssentialInformationCompany()
            );
            userList.add(bean);
        }
        return new MyResponseBody(200, "OK", userList);
    }

    @GetMapping("/get/user/detail")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object getUserDetail(int accountId) {
        UsersAccount account = usersAccountService.getUserByKey(accountId);
        if (account == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "用户编号不存在");
        }
        UsersEssentialInformation essentialInformation = usersEssentialInfoService.getById(account.getUsersEssentialInformationId());
        UserDetailBean bean = new UserDetailBean(
                account.getUsersAccountId(),
                account.getUsersEssentialInformationId(),
                account.getUsersAccountAccount(),
                account.getUsersAccountEmail(),
                essentialInformation.getUsersEssentialInformationName(),
                essentialInformation.getUsersEssentialInformationIdNumber(),
                essentialInformation.getUsersEssentialInformationCompany()
        );
        return new MyResponseBody(200, "OK", bean);
    }

    /**
     * 用户参数查询待完成
     */
    @GetMapping("/get/user/param")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object getUserByParam(String param) {
        if (param == null || param.isEmpty()) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "请求参数错误");
        }
        List<UsersAccount> accountList = usersAccountService.selectAllByParam(param);
        List<UserDetailBean> result = new ArrayList<>();
        for (UsersAccount account : accountList) {
            UsersEssentialInformation information = usersEssentialInfoService.getById(account.getUsersEssentialInformationId());
            UserDetailBean userDetailBean = new UserDetailBean(
                    account.getUsersAccountId(),
                    account.getUsersEssentialInformationId(),
                    account.getUsersAccountAccount(),
                    account.getUsersAccountEmail(),
                    information.getUsersEssentialInformationName(),
                    information.getUsersEssentialInformationIdNumber(),
                    information.getUsersEssentialInformationCompany()
            );
            result.add(userDetailBean);
        }
        return new MyResponseBody(200, "OK", result);
    }

    /**
     * 待测试
     *
     * @param accountId
     * @return
     */
    @GetMapping("/delete/user")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object deleteUser(int accountId) {
        UsersAccount account = usersAccountService.getUserByKey(accountId);
        if (account == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "用户编号不存在");
        }
        usersEssentialInfoService.delete(account.getUsersEssentialInformationId());
        usersAccountService.delete(accountId);
        return new MyResponseBody(200, "OK");
    }


}
