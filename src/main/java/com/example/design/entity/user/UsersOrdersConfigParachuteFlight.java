package com.example.design.entity.user;

public class UsersOrdersConfigParachuteFlight {
    private Integer usersOrdersConfigParachuteFlightId;

    private String usersOrdersConfigParachuteFlightType;

    private String usersOrdersConfigParachuteFlightNeedHold;

    private String usersOrdersConfigParachuteFlightNeedTripartite;

    private String usersOrdersConfigParachuteFlightScheduledTime;

    private String usersOrdersConfigParachuteFlightPersonNum;

    public UsersOrdersConfigParachuteFlight(String usersOrdersConfigParachuteFlightType, String usersOrdersConfigParachuteFlightNeedHold, String usersOrdersConfigParachuteFlightNeedTripartite, String usersOrdersConfigParachuteFlightScheduledTime, String usersOrdersConfigParachuteFlightPersonNum) {
        this.usersOrdersConfigParachuteFlightType = usersOrdersConfigParachuteFlightType;
        this.usersOrdersConfigParachuteFlightNeedHold = usersOrdersConfigParachuteFlightNeedHold;
        this.usersOrdersConfigParachuteFlightNeedTripartite = usersOrdersConfigParachuteFlightNeedTripartite;
        this.usersOrdersConfigParachuteFlightScheduledTime = usersOrdersConfigParachuteFlightScheduledTime;
        this.usersOrdersConfigParachuteFlightPersonNum = usersOrdersConfigParachuteFlightPersonNum;
    }

    public Integer getUsersOrdersConfigParachuteFlightId() {
        return usersOrdersConfigParachuteFlightId;
    }

    public void setUsersOrdersConfigParachuteFlightId(Integer usersOrdersConfigParachuteFlightId) {
        this.usersOrdersConfigParachuteFlightId = usersOrdersConfigParachuteFlightId;
    }

    public String getUsersOrdersConfigParachuteFlightType() {
        return usersOrdersConfigParachuteFlightType;
    }

    public void setUsersOrdersConfigParachuteFlightType(String usersOrdersConfigParachuteFlightType) {
        this.usersOrdersConfigParachuteFlightType = usersOrdersConfigParachuteFlightType == null ? null : usersOrdersConfigParachuteFlightType.trim();
    }

    public String getUsersOrdersConfigParachuteFlightNeedHold() {
        return usersOrdersConfigParachuteFlightNeedHold;
    }

    public void setUsersOrdersConfigParachuteFlightNeedHold(String usersOrdersConfigParachuteFlightNeedHold) {
        this.usersOrdersConfigParachuteFlightNeedHold = usersOrdersConfigParachuteFlightNeedHold == null ? null : usersOrdersConfigParachuteFlightNeedHold.trim();
    }

    public String getUsersOrdersConfigParachuteFlightNeedTripartite() {
        return usersOrdersConfigParachuteFlightNeedTripartite;
    }

    public void setUsersOrdersConfigParachuteFlightNeedTripartite(String usersOrdersConfigParachuteFlightNeedTripartite) {
        this.usersOrdersConfigParachuteFlightNeedTripartite = usersOrdersConfigParachuteFlightNeedTripartite == null ? null : usersOrdersConfigParachuteFlightNeedTripartite.trim();
    }

    public String getUsersOrdersConfigParachuteFlightScheduledTime() {
        return usersOrdersConfigParachuteFlightScheduledTime;
    }

    public void setUsersOrdersConfigParachuteFlightScheduledTime(String usersOrdersConfigParachuteFlightScheduledTime) {
        this.usersOrdersConfigParachuteFlightScheduledTime = usersOrdersConfigParachuteFlightScheduledTime == null ? null : usersOrdersConfigParachuteFlightScheduledTime.trim();
    }

    public String getUsersOrdersConfigParachuteFlightPersonNum() {
        return usersOrdersConfigParachuteFlightPersonNum;
    }

    public void setUsersOrdersConfigParachuteFlightPersonNum(String usersOrdersConfigParachuteFlightPersonNum) {
        this.usersOrdersConfigParachuteFlightPersonNum = usersOrdersConfigParachuteFlightPersonNum == null ? null : usersOrdersConfigParachuteFlightPersonNum.trim();
    }
}