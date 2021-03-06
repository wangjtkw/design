package com.example.design.entity.user;

public class UsersOrders {
    private Integer usersOrdersId;

    private Integer serverUnitAccountId;

    private Integer usersAccountId;

    private Integer serverUnitServicesId;

    private Integer usersOrdersConfigAirTourId;

    private Integer usersOrdersConfigCharteredAirplaneId;

    private Integer usersOrdersConfigParachuteFlightId;

    private String usersOrdersOrderState;

    private String usersOrdersServerType;

    private String usersOrdersMoney;

    private String usersOrdersTimeCreate;

    private String usersOrdersTimePay;

    private String usersOrdersTimeFinish;

    private String usersOrdersOrderCode;

    private Boolean usersOrdersUserDelete;

    private Boolean usersOrdersUnitDelete;

    public UsersOrders(Integer serverUnitAccountId, Integer usersAccountId, Integer serverUnitServicesId, String usersOrdersOrderState, String usersOrdersServerType, String usersOrdersMoney) {
        this.serverUnitAccountId = serverUnitAccountId;
        this.usersAccountId = usersAccountId;
        this.serverUnitServicesId = serverUnitServicesId;
        this.usersOrdersOrderState = usersOrdersOrderState;
        this.usersOrdersServerType = usersOrdersServerType;
        this.usersOrdersMoney = usersOrdersMoney;
    }

    public Integer getUsersOrdersId() {
        return usersOrdersId;
    }

    public void setUsersOrdersId(Integer usersOrdersId) {
        this.usersOrdersId = usersOrdersId;
    }

    public Integer getServerUnitAccountId() {
        return serverUnitAccountId;
    }

    public void setServerUnitAccountId(Integer serverUnitAccountId) {
        this.serverUnitAccountId = serverUnitAccountId;
    }

    public Integer getUsersAccountId() {
        return usersAccountId;
    }

    public void setUsersAccountId(Integer usersAccountId) {
        this.usersAccountId = usersAccountId;
    }

    public Integer getServerUnitServicesId() {
        return serverUnitServicesId;
    }

    public void setServerUnitServicesId(Integer serverUnitServicesId) {
        this.serverUnitServicesId = serverUnitServicesId;
    }

    public Integer getUsersOrdersConfigAirTourId() {
        return usersOrdersConfigAirTourId;
    }

    public void setUsersOrdersConfigAirTourId(Integer usersOrdersConfigAirTourId) {
        this.usersOrdersConfigAirTourId = usersOrdersConfigAirTourId;
    }

    public Integer getUsersOrdersConfigCharteredAirplaneId() {
        return usersOrdersConfigCharteredAirplaneId;
    }

    public void setUsersOrdersConfigCharteredAirplaneId(Integer usersOrdersConfigCharteredAirplaneId) {
        this.usersOrdersConfigCharteredAirplaneId = usersOrdersConfigCharteredAirplaneId;
    }

    public Integer getUsersOrdersConfigParachuteFlightId() {
        return usersOrdersConfigParachuteFlightId;
    }

    public void setUsersOrdersConfigParachuteFlightId(Integer usersOrdersConfigParachuteFlightId) {
        this.usersOrdersConfigParachuteFlightId = usersOrdersConfigParachuteFlightId;
    }

    public String getUsersOrdersOrderState() {
        return usersOrdersOrderState;
    }

    public void setUsersOrdersOrderState(String usersOrdersOrderState) {
        this.usersOrdersOrderState = usersOrdersOrderState;
    }

    public String getUsersOrdersServerType() {
        return usersOrdersServerType;
    }

    public void setUsersOrdersServerType(String usersOrdersServerType) {
        this.usersOrdersServerType = usersOrdersServerType;
    }

    public String getUsersOrdersMoney() {
        return usersOrdersMoney;
    }

    public void setUsersOrdersMoney(String usersOrdersMoney) {
        this.usersOrdersMoney = usersOrdersMoney;
    }

    public String getUsersOrdersTimeCreate() {
        return usersOrdersTimeCreate;
    }

    public void setUsersOrdersTimeCreate(String usersOrdersTimeCreate) {
        this.usersOrdersTimeCreate = usersOrdersTimeCreate;
    }

    public String getUsersOrdersTimePay() {
        return usersOrdersTimePay;
    }

    public void setUsersOrdersTimePay(String usersOrdersTimePay) {
        this.usersOrdersTimePay = usersOrdersTimePay;
    }

    public String getUsersOrdersTimeFinish() {
        return usersOrdersTimeFinish;
    }

    public void setUsersOrdersTimeFinish(String usersOrdersTimeFinish) {
        this.usersOrdersTimeFinish = usersOrdersTimeFinish;
    }

    public String getUsersOrdersOrderCode() {
        return usersOrdersOrderCode;
    }

    public void setUsersOrdersOrderCode(String usersOrdersOrderCode) {
        this.usersOrdersOrderCode = usersOrdersOrderCode;
    }

    public Boolean getUsersOrdersUserDelete() {
        return usersOrdersUserDelete;
    }

    public void setUsersOrdersUserDelete(Boolean usersOrdersUserDelete) {
        this.usersOrdersUserDelete = usersOrdersUserDelete;
    }

    public Boolean getUsersOrdersUnitDelete() {
        return usersOrdersUnitDelete;
    }

    public void setUsersOrdersUnitDelete(Boolean usersOrdersUnitDelete) {
        this.usersOrdersUnitDelete = usersOrdersUnitDelete;
    }
}