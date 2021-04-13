package com.example.design.controller;

import com.example.design.common.ErrorCode;
import com.example.design.common.MyFile;
import com.example.design.common.MyResponseBody;
import com.example.design.common.QrCodeUtil;
import com.example.design.entity.requestbean.user.UserUpdateEmail;
import com.example.design.entity.requestbean.user.UserUpdatePW;
import com.example.design.entity.responsebean.*;
import com.example.design.entity.server.IServerUnitService;
import com.example.design.entity.server.ServerUnitCompany;
import com.example.design.entity.user.*;
import com.example.design.entity.requestbean.user.UserLogin;
import com.example.design.entity.requestbean.user.UserRegister;
import com.example.design.entity.server.ServerUnitServices;
import com.example.design.service.server.*;
import com.example.design.service.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
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

    @Autowired
    private UsersOrderService usersOrderService;

    @Autowired
    private UsersOrdersConfigAirTourService usersOrdersConfigAirTourService;

    @Autowired
    private UsersOrdersConfigCharteredAirplaneService usersOrdersConfigCharteredAirplaneService;

    @Autowired
    private UsersOrdersConfigParachuteFlightService usersOrdersConfigParachuteFlightService;

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
                || register.getUsersAccountAccount().isEmpty()
                || register.getUsersAccountEmail() == null
                || register.getUsersAccountEmail().isEmpty()
                || register.getUsersAccountPassword() == null
                || register.getUsersAccountPassword().isEmpty()) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "注册必填信息不完整");
        }
        if (register.getUsersEssentialInformationName() == null
                || register.getUsersEssentialInformationName().isEmpty()
                || register.getUsersEssentialInformationIdNumber() == null
                || register.getUsersEssentialInformationIdNumber().isEmpty()) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "注册必填信息不完整");
        }
        if (usersAccountService.getUserByAccount(register.getUsersAccountAccount()) != null) {
            return new MyResponseBody(ErrorCode.DUPLICATE_ACCOUNT_NUMBER_CODE, ErrorCode.DUPLICATE_ACCOUNT_NUMBER_DESCRIBE);
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
                || userLogin.getUsersAccountAccount().isEmpty()
                || userLogin.getUsersAccountPassword() == null
                || userLogin.getUsersAccountPassword().isEmpty()) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "账号或密码错误");
        }
        UsersAccount account = usersAccountService.login(userLogin.getUsersAccountAccount());
        if (account == null || !account.getUsersAccountPassword().equals(userLogin.getUsersAccountPassword())) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "账号或密码错误");
        }
        account.setUsersAccountPassword("");
        return new MyResponseBody(200, "OK",account);
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
                || userUpdatePW.getUsersAccountId() == null
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

    /**
     * 支付请求二维码
     *
     * @param request
     * @param response
     * @param payBean
     */
    @RequestMapping("/pay/request")
    public void pay(HttpServletRequest request, HttpServletResponse response, UserPayBean payBean) {
        String requestContent;
        int orderId = saveOrder(payBean);
        if (orderId < 0) {
            requestContent = "请求参数不完全或参数错误";
        } else {
            String ip = MyFile.address;
            StringBuilder builder = new StringBuilder();
            builder.append("http://").append(ip).append(":8080/page/order.html?");
            builder.append("orderId=").append(orderId);
            requestContent = builder.toString();
        }
        try {
            OutputStream os = response.getOutputStream();
            QrCodeUtil.encode(requestContent, null, os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    int saveOrder(UserPayBean payBean) {
        if (payBean.getServerUnitAccountId() == null
                || payBean.getUsersAccountId() == null
                || payBean.getServerUnitServicesId() == null
                || payBean.getUsersOrdersServerType() == null
                || payBean.getUsersOrdersServerType().equals("")
                || payBean.getUsersOrdersMoney() == null
                || payBean.getUsersOrdersMoney().isEmpty()) {
            return -1;
        }
        UsersOrders orders = new UsersOrders(
                payBean.getServerUnitAccountId(),
                payBean.getUsersAccountId(),
                payBean.getServerUnitServicesId(),
                "待付款",
                payBean.getUsersOrdersServerType(),
                payBean.getUsersOrdersMoney());
        orders.setUsersOrdersUnitDelete(false);
        orders.setUsersOrdersUserDelete(false);
        switch (payBean.getUsersOrdersServerType()) {
            case "空中游览":
//                usersOrdersConfigAirTourService
                if (payBean.getUsersOrdersConfigAirTourDuration() == null
                        || payBean.getUsersOrdersConfigAirTourDuration().isEmpty()
                        || payBean.getUsersOrdersConfigAirTourNumber() == null
                        || payBean.getUsersOrdersConfigAirTourNumber().isEmpty()
                        || payBean.getUsersOrdersConfigAirTourAircraftModel() == null
                        || payBean.getUsersOrdersConfigAirTourAircraftModel().isEmpty()
                        || payBean.getUsersOrdersConfigAirTourScheduledTime() == null
                        || payBean.getUsersOrdersConfigAirTourScheduledTime().isEmpty()) {
                    return -1;
                }
                UsersOrdersConfigAirTour airTour = new UsersOrdersConfigAirTour(
                        payBean.getUsersOrdersConfigAirTourDuration(),
                        payBean.getUsersOrdersConfigAirTourNumber(),
                        payBean.getUsersOrdersConfigAirTourAircraftModel(),
                        payBean.getUsersOrdersConfigAirTourScheduledTime()
                );
                usersOrdersConfigAirTourService.insert(airTour);
                orders.setUsersOrdersConfigAirTourId(airTour.getUsersOrdersConfigAirTourId());
                break;
            case "包机飞行":
//              usersOrdersConfigCharteredAirplaneService
                if (payBean.getUsersOrdersConfigCharteredAirplaneAircraftModel() == null
                        || payBean.getUsersOrdersConfigCharteredAirplaneAircraftModel().isEmpty()
                        || payBean.getUsersOrdersConfigCharteredAirplaneScheduledTime() == null
                        || payBean.getUsersOrdersConfigCharteredAirplaneScheduledTime().isEmpty()) {
                    return -1;
                }
                UsersOrdersConfigCharteredAirplane charteredAirplane = new UsersOrdersConfigCharteredAirplane(
                        payBean.getUsersOrdersConfigCharteredAirplaneAircraftModel(),
                        payBean.getUsersOrdersConfigCharteredAirplaneScheduledTime()
                );
                usersOrdersConfigCharteredAirplaneService.insert(charteredAirplane);
                orders.setUsersOrdersConfigCharteredAirplaneId(charteredAirplane.getUsersOrdersConfigCharteredAirplaneId());
                break;
            case "跳伞飞行":
//                usersOrdersConfigParachuteFlightService
                if (payBean.getUsersOrdersConfigParachuteFlightType() == null
                        || payBean.getUsersOrdersConfigParachuteFlightType().isEmpty()
                        || payBean.getUsersOrdersConfigParachuteFlightNeedHold() == null
                        || payBean.getUsersOrdersConfigParachuteFlightNeedHold().isEmpty()
                        || payBean.getUsersOrdersConfigParachuteFlightNeedTripartite() == null
                        || payBean.getUsersOrdersConfigParachuteFlightNeedTripartite().isEmpty()
                        || payBean.getUsersOrdersConfigParachuteFlightScheduledTime() == null
                        || payBean.getUsersOrdersConfigParachuteFlightScheduledTime().isEmpty()
                        || payBean.getUsersOrdersConfigParachuteFlightPersonNum() == null
                        || payBean.getUsersOrdersConfigParachuteFlightPersonNum().isEmpty()) {
                    return -1;
                }
                UsersOrdersConfigParachuteFlight parachuteFlight = new UsersOrdersConfigParachuteFlight(
                        payBean.getUsersOrdersConfigParachuteFlightType(),
                        payBean.getUsersOrdersConfigParachuteFlightNeedHold(),
                        payBean.getUsersOrdersConfigParachuteFlightNeedTripartite(),
                        payBean.getUsersOrdersConfigParachuteFlightScheduledTime(),
                        payBean.getUsersOrdersConfigParachuteFlightPersonNum()
                );
                usersOrdersConfigParachuteFlightService.insert(parachuteFlight);
                orders.setUsersOrdersConfigParachuteFlightId(parachuteFlight.getUsersOrdersConfigParachuteFlightId());
                break;
            default:
                return -1;
        }
        usersOrderService.insert(orders);
        return orders.getUsersOrdersId();
    }

    @RequestMapping("/pay/confirm")
    @ResponseBody
    public Object payConfirm(int orderId) {
        UsersOrders orders = usersOrderService.selectById(orderId);
        if (orders == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "订单id错误");
        }
        orders.setUsersOrdersOrderState("待完成");
        usersOrderService.updateBySelective(orders);
        System.out.println("运行");
        return new MyResponseBody(200, "OK");
    }

    @RequestMapping("/pay/finish")
    @ResponseBody
    public Object orderFinish(int orderId) {
        UsersOrders orders = usersOrderService.selectById(orderId);
        if (orders == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "订单id错误");
        }
        orders.setUsersOrdersOrderState("已完成");
        usersOrderService.updateBySelective(orders);
        return new MyResponseBody(200, "OK");
    }


    @RequestMapping("/get/order/list")
    @ResponseBody
    public Object getOrderList(int accountId) {
        List<UsersOrders> ordersList = usersOrderService.selectByAccountId(accountId);
        List<OrderDetailBean> result = new ArrayList<>();
        for (UsersOrders orders : ordersList) {
            UserPayBean payBean = getUserPayBean(orders);
            if (payBean == null) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            int serverId = payBean.getServerUnitServicesId();
            if (serverId == 0) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            ServerUnitCompany company = getCompanyByServerId(serverId);
            if (company == null) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            ServerUnitServicesDetail serverDetail = getServerUnitService(serverId);
            if (serverDetail == null) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            OrderDetailBean orderDetailBean = new OrderDetailBean();
            payBean.setUsersOrdersOrderCode(orderCodeId(payBean.getUsersOrdersId()));
            orderDetailBean.setPayBean(payBean);
            orderDetailBean.setCompany(company);
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
        int serverId = payBean.getServerUnitServicesId();
        if (serverId == 0) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
        }
        ServerUnitCompany company = getCompanyByServerId(serverId);
        if (company == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
        }
        ServerUnitServicesDetail serverDetail = getServerUnitService(serverId);
        if (serverDetail == null) {
            return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
        }
        OrderDetailBean orderDetailBean = new OrderDetailBean();
        payBean.setUsersOrdersOrderCode(orderCodeId(payBean.getUsersOrdersId()));
        orderDetailBean.setPayBean(payBean);
        orderDetailBean.setCompany(company);
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


    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ServerUnitCompany getCompanyByServerId(int serverId) {
        if (serverId == 0) {
            return null;
        }
        return serverUnitCompanyService.selectByServerId(serverId);
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
            orders.setUsersOrdersUserDelete(true);
            usersOrderService.updateBySelective(orders);
        }
        return new MyResponseBody(200, "OK");
    }

    @RequestMapping("get/order/list/param")
    @ResponseBody
    public Object select(int accountId, String param) {
        List<UsersOrders> ordersList = usersOrderService.selectByAccountParam(accountId, param);
        List<OrderDetailBean> result = new ArrayList<>();
        for (UsersOrders orders : ordersList) {
            UserPayBean payBean = getUserPayBean(orders);
            if (payBean == null) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            int serverId = payBean.getServerUnitServicesId();
            if (serverId == 0) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            ServerUnitCompany company = getCompanyByServerId(serverId);
            if (company == null) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            ServerUnitServicesDetail serverDetail = getServerUnitService(serverId);
            if (serverDetail == null) {
                return new MyResponseBody(ErrorCode.PARAMETER_ERROR_CODE, ErrorCode.PARAMETER_ERROR_DESCRIBE + "参数错误");
            }
            OrderDetailBean orderDetailBean = new OrderDetailBean();
            payBean.setUsersOrdersOrderCode(orderCodeId(payBean.getUsersOrdersId()));
            orderDetailBean.setPayBean(payBean);
            orderDetailBean.setCompany(company);
            orderDetailBean.setServerUnitServicesDetail(serverDetail);
            result.add(orderDetailBean);
        }
        return new MyResponseBody(200, "OK", result);
    }


}
