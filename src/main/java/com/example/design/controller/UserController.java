package com.example.design.controller;

import com.example.design.common.ErrorCode;
import com.example.design.common.MyResponseBody;
import com.example.design.entity.requestbean.user.UserUpdateEmail;
import com.example.design.entity.requestbean.user.UserUpdatePW;
import com.example.design.entity.responsebean.ServerUnitServicesDetail;
import com.example.design.entity.responsebean.UserServerHomeBean;
import com.example.design.entity.responsebean.UserServerItemDetailBean;
import com.example.design.entity.responsebean.UserServerTypeItemBean;
import com.example.design.entity.server.IServerUnitService;
import com.example.design.entity.server.ServerUnitCompany;
import com.example.design.entity.user.UsersAccount;
import com.example.design.entity.user.UsersEssentialInformation;
import com.example.design.entity.requestbean.user.UserLogin;
import com.example.design.entity.requestbean.user.UserRegister;
import com.example.design.entity.server.ServerUnitServices;
import com.example.design.service.server.*;
import com.example.design.service.user.UsersAccountService;
import com.example.design.service.user.UsersEssentialInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersAccountService usersAccountService;

    @Autowired
    private UsersEssentialInfoService usersEssentialInfoService;

    @Autowired
    private ServerUnitServicesService serverUnitServicesService;

    @Autowired
    private ServerUnitCompanyService serverUnitCompanyService;

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
     * 1.通航用户注册接口
     *
     * @param register 包含用户账户、密码、邮箱、姓名、身份证号、所属企业(可选)
     * @return {@link ErrorCode}.PARAMETER_ERROR_CODE 1000错误、"Illegal parameter：注册必填信息不完整"
     * 200 OK，请求完成
     */
    @PostMapping("/register")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object register(UserRegister register) {
        if (register.getUsersAccountAccount() == null
                || register.getUsersAccountEmail() == null
                || register.getUsersAccountPassword() == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "注册必填信息不完整");
        }
        if (register.getUsersEssentialInformationName() == null
                || register.getUsersEssentialInformationIdNumber() == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "注册必填信息不完整");
        }
        UsersAccount usersAccount = new UsersAccount(
                register.getUsersAccountAccount(),
                register.getUsersAccountPassword(),
                register.getUsersAccountEmail());
        UsersEssentialInformation essentialInformation = new UsersEssentialInformation(
                register.getUsersEssentialInformationName(),
                register.getUsersEssentialInformationIdNumber(),
                register.getUsersEssentialInformationCompany());
        usersEssentialInfoService.insert(essentialInformation);
        usersAccount.setUsersEssentialInformationId(essentialInformation.getUsersEssentialInformationId());
        usersAccountService.insertUsersAccount(usersAccount);
        return new MyResponseBody(200, "OK");
    }

    /**
     * 2.通航用户登录
     *
     * @param userLogin 包含账号、密码
     * @return {@link ErrorCode}.PARAMETER_ERROR_CODE 1000错误、"Illegal parameter：账号或密码错误"
     */
    @PostMapping("/login")
    @ResponseBody
    public Object login(UserLogin userLogin) {
        if (userLogin.getUsersAccountAccount() == null
                || userLogin.getUsersAccountPassword() == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "账号或密码错误");
        }
        UsersAccount account = usersAccountService.login(userLogin.getUsersAccountAccount());
        if (account == null || !account.getUsersAccountPassword().equals(userLogin.getUsersAccountPassword())) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "账号或密码错误");
        }
        return new MyResponseBody(200, "OK");
    }

    @PostMapping("/update/email")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object updateEmail(UserUpdateEmail userUpdateEmail) {
        if (userUpdateEmail == null
                || userUpdateEmail.getPw() == null
                || userUpdateEmail.getPw().equals("")
                || userUpdateEmail.getNewEmail() == null
                || userUpdateEmail.getNewEmail().equals("")) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "密码或邮箱不能为空");
        }
        UsersAccount usersAccount = usersAccountService.getUsersAccount(userUpdateEmail.getUsersAccountId());
        if (usersAccount == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "用户id不存在");
        }
        if (!usersAccount.getUsersAccountPassword().equals(userUpdateEmail.getPw())) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "密码错误");
        }
        usersAccount.setUsersAccountEmail(userUpdateEmail.getNewEmail());
        usersAccountService.update(usersAccount);
        return new MyResponseBody(200, "OK");
    }

    @PostMapping("/update/pw")
    @ResponseBody
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public Object updatePassword(UserUpdatePW userUpdatePW) {
        if (userUpdatePW == null
                || userUpdatePW.getOldPW() == null
                || userUpdatePW.getOldPW().equals("")
                || userUpdatePW.getNewPW() == null
                || userUpdatePW.getNewPW().equals("")) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "密码不能为空");
        }
        UsersAccount usersAccount = usersAccountService.getUsersAccount(userUpdatePW.getUsersAccountId());
        if (usersAccount == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "用户id不存在");
        }
        if (!usersAccount.getUsersAccountPassword().equals(userUpdatePW.getOldPW())) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "旧密码错误");
        }
        usersAccount.setUsersAccountPassword(userUpdatePW.getNewPW());
        usersAccountService.update(usersAccount);
        return new MyResponseBody(200, "OK");
    }

    @GetMapping("/get/server/home")
    @ResponseBody
    public Object getServer(int limit) {
        List<UserServerTypeItemBean> airTour = getServerByType("空中游览", limit);
        List<UserServerTypeItemBean> charteredAirplane = getServerByType("包机飞行", limit);
        List<UserServerTypeItemBean> parachuteFlight = getServerByType("跳伞飞行", limit);
        List<UserServerTypeItemBean> artificialRainfall = getServerByType("人工增雨", limit);
        List<UserServerTypeItemBean> helicopterRental = getServerByType("直升机出租", limit);
        UserServerHomeBean homeBean = new UserServerHomeBean(
                airTour, charteredAirplane, parachuteFlight, artificialRainfall, helicopterRental
        );
        return new MyResponseBody(200, "OK", homeBean);
    }

    @GetMapping("/get/server/type")
    @ResponseBody
    public Object getServerType(String type) {
        List<UserServerTypeItemBean> result = getServerByType(type, -1);
        if (result == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "请求类型错误");
        }
        return new MyResponseBody(200, "OK", result);
    }

    private List<UserServerTypeItemBean> getServerByType(String type, int limit) {
        List<ServerUnitServices> services;
        switch (type) {
            case "空中游览":
            case "包机飞行":
            case "跳伞飞行":
            case "人工增雨":
            case "直升机出租":
                services = serverUnitServicesService.selectByType(type, limit);
                break;
            default:
                return null;
        }
        List<UserServerTypeItemBean> result = new ArrayList<>();
        for (ServerUnitServices service : services) {
            ServerUnitCompany company = serverUnitCompanyService.selectByServerId(service.getServerUnitServicesId());
            UserServerTypeItemBean serverTypeItemBean = new UserServerTypeItemBean(service, company);
            result.add(serverTypeItemBean);
        }
        return result;
    }

    @GetMapping("/server/detail")
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
    }


}
