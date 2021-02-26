package com.example.design.entity.user;

public class UsersOrdersConfigAirTour {
    private Integer usersOrdersConfigAirTourId;

    private String usersOrdersConfigAirTourDuration;

    private String usersOrdersConfigAirTourNumber;

    private String usersOrdersConfigAirTourAircraftModel;

    private String usersOrdersConfigAirTourScheduledTime;

    public UsersOrdersConfigAirTour(String usersOrdersConfigAirTourDuration, String usersOrdersConfigAirTourNumber, String usersOrdersConfigAirTourAircraftModel, String usersOrdersConfigAirTourScheduledTime) {
        this.usersOrdersConfigAirTourDuration = usersOrdersConfigAirTourDuration;
        this.usersOrdersConfigAirTourNumber = usersOrdersConfigAirTourNumber;
        this.usersOrdersConfigAirTourAircraftModel = usersOrdersConfigAirTourAircraftModel;
        this.usersOrdersConfigAirTourScheduledTime = usersOrdersConfigAirTourScheduledTime;
    }

    public Integer getUsersOrdersConfigAirTourId() {
        return usersOrdersConfigAirTourId;
    }

    public void setUsersOrdersConfigAirTourId(Integer usersOrdersConfigAirTourId) {
        this.usersOrdersConfigAirTourId = usersOrdersConfigAirTourId;
    }

    public String getUsersOrdersConfigAirTourDuration() {
        return usersOrdersConfigAirTourDuration;
    }

    public void setUsersOrdersConfigAirTourDuration(String usersOrdersConfigAirTourDuration) {
        this.usersOrdersConfigAirTourDuration = usersOrdersConfigAirTourDuration == null ? null : usersOrdersConfigAirTourDuration.trim();
    }

    public String getUsersOrdersConfigAirTourNumber() {
        return usersOrdersConfigAirTourNumber;
    }

    public void setUsersOrdersConfigAirTourNumber(String usersOrdersConfigAirTourNumber) {
        this.usersOrdersConfigAirTourNumber = usersOrdersConfigAirTourNumber == null ? null : usersOrdersConfigAirTourNumber.trim();
    }

    public String getUsersOrdersConfigAirTourAircraftModel() {
        return usersOrdersConfigAirTourAircraftModel;
    }

    public void setUsersOrdersConfigAirTourAircraftModel(String usersOrdersConfigAirTourAircraftModel) {
        this.usersOrdersConfigAirTourAircraftModel = usersOrdersConfigAirTourAircraftModel == null ? null : usersOrdersConfigAirTourAircraftModel.trim();
    }

    public String getUsersOrdersConfigAirTourScheduledTime() {
        return usersOrdersConfigAirTourScheduledTime;
    }

    public void setUsersOrdersConfigAirTourScheduledTime(String usersOrdersConfigAirTourScheduledTime) {
        this.usersOrdersConfigAirTourScheduledTime = usersOrdersConfigAirTourScheduledTime == null ? null : usersOrdersConfigAirTourScheduledTime.trim();
    }
}