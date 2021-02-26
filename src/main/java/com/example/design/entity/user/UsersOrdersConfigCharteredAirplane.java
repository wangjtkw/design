package com.example.design.entity.user;

public class UsersOrdersConfigCharteredAirplane {
    private Integer usersOrdersConfigCharteredAirplaneId;

    private String usersOrdersConfigCharteredAirplaneAircraftModel;

    private String usersOrdersConfigCharteredAirplaneScheduledTime;

    public UsersOrdersConfigCharteredAirplane(String usersOrdersConfigCharteredAirplaneAircraftModel, String usersOrdersConfigCharteredAirplaneScheduledTime) {
        this.usersOrdersConfigCharteredAirplaneAircraftModel = usersOrdersConfigCharteredAirplaneAircraftModel;
        this.usersOrdersConfigCharteredAirplaneScheduledTime = usersOrdersConfigCharteredAirplaneScheduledTime;
    }

    public Integer getUsersOrdersConfigCharteredAirplaneId() {
        return usersOrdersConfigCharteredAirplaneId;
    }

    public void setUsersOrdersConfigCharteredAirplaneId(Integer usersOrdersConfigCharteredAirplaneId) {
        this.usersOrdersConfigCharteredAirplaneId = usersOrdersConfigCharteredAirplaneId;
    }

    public String getUsersOrdersConfigCharteredAirplaneAircraftModel() {
        return usersOrdersConfigCharteredAirplaneAircraftModel;
    }

    public void setUsersOrdersConfigCharteredAirplaneAircraftModel(String usersOrdersConfigCharteredAirplaneAircraftModel) {
        this.usersOrdersConfigCharteredAirplaneAircraftModel = usersOrdersConfigCharteredAirplaneAircraftModel == null ? null : usersOrdersConfigCharteredAirplaneAircraftModel.trim();
    }

    public String getUsersOrdersConfigCharteredAirplaneScheduledTime() {
        return usersOrdersConfigCharteredAirplaneScheduledTime;
    }

    public void setUsersOrdersConfigCharteredAirplaneScheduledTime(String usersOrdersConfigCharteredAirplaneScheduledTime) {
        this.usersOrdersConfigCharteredAirplaneScheduledTime = usersOrdersConfigCharteredAirplaneScheduledTime == null ? null : usersOrdersConfigCharteredAirplaneScheduledTime.trim();
    }
}