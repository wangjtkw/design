package com.example.design.entity;

public class ServerUnitServices {
    private Integer serverUnitServicesId;

    private Integer serverUnitAccountId;

    private Integer serverUnitServicesHelicopterRentalId;

    private Integer usersOrdersId;

    private Integer serverUnitServicesParachuteFlightId;

    private Integer serverUnitServicesAirTourId;

    private Integer serverUnitServicesCharteredAirplaneId;

    private Integer serverUnitServicesArtificialRainfallId;

    private String serverUnitServicesTitle;

    private String serverUnitServicesImg;

    private String serverUnitServicesDetail;

    private String serverUnitServicesType;

    private String serverUnitServicesAuditStatus;

    private String serverUnitServicesReleaseTime;

    public ServerUnitServices(String serverUnitServicesTitle, String serverUnitServicesImg, String serverUnitServicesDetail, String serverUnitServicesType, String serverUnitServicesAuditStatus) {
        this.serverUnitServicesTitle = serverUnitServicesTitle;
        this.serverUnitServicesImg = serverUnitServicesImg;
        this.serverUnitServicesDetail = serverUnitServicesDetail;
        this.serverUnitServicesType = serverUnitServicesType;
        this.serverUnitServicesAuditStatus = serverUnitServicesAuditStatus;
    }

    public ServerUnitServices() {
    }

    public Integer getServerUnitServicesId() {
        return serverUnitServicesId;
    }

    public void setServerUnitServicesId(Integer serverUnitServicesId) {
        this.serverUnitServicesId = serverUnitServicesId;
    }

    public Integer getServerUnitAccountId() {
        return serverUnitAccountId;
    }

    public void setServerUnitAccountId(Integer serverUnitAccountId) {
        this.serverUnitAccountId = serverUnitAccountId;
    }

    public Integer getServerUnitServicesHelicopterRentalId() {
        return serverUnitServicesHelicopterRentalId;
    }

    public void setServerUnitServicesHelicopterRentalId(Integer serverUnitServicesHelicopterRentalId) {
        this.serverUnitServicesHelicopterRentalId = serverUnitServicesHelicopterRentalId;
    }

    public Integer getUsersOrdersId() {
        return usersOrdersId;
    }

    public void setUsersOrdersId(Integer usersOrdersId) {
        this.usersOrdersId = usersOrdersId;
    }

    public Integer getServerUnitServicesParachuteFlightId() {
        return serverUnitServicesParachuteFlightId;
    }

    public void setServerUnitServicesParachuteFlightId(Integer serverUnitServicesParachuteFlightId) {
        this.serverUnitServicesParachuteFlightId = serverUnitServicesParachuteFlightId;
    }

    public Integer getServerUnitServicesAirTourId() {
        return serverUnitServicesAirTourId;
    }

    public void setServerUnitServicesAirTourId(Integer serverUnitServicesAirTourId) {
        this.serverUnitServicesAirTourId = serverUnitServicesAirTourId;
    }

    public Integer getServerUnitServicesCharteredAirplaneId() {
        return serverUnitServicesCharteredAirplaneId;
    }

    public void setServerUnitServicesCharteredAirplaneId(Integer serverUnitServicesCharteredAirplaneId) {
        this.serverUnitServicesCharteredAirplaneId = serverUnitServicesCharteredAirplaneId;
    }

    public Integer getServerUnitServicesArtificialRainfallId() {
        return serverUnitServicesArtificialRainfallId;
    }

    public void setServerUnitServicesArtificialRainfallId(Integer serverUnitServicesArtificialRainfallId) {
        this.serverUnitServicesArtificialRainfallId = serverUnitServicesArtificialRainfallId;
    }

    public String getServerUnitServicesTitle() {
        return serverUnitServicesTitle;
    }

    public void setServerUnitServicesTitle(String serverUnitServicesTitle) {
        this.serverUnitServicesTitle = serverUnitServicesTitle == null ? null : serverUnitServicesTitle.trim();
    }

    public String getServerUnitServicesImg() {
        return serverUnitServicesImg;
    }

    public void setServerUnitServicesImg(String serverUnitServicesImg) {
        this.serverUnitServicesImg = serverUnitServicesImg == null ? null : serverUnitServicesImg.trim();
    }

    public String getServerUnitServicesDetail() {
        return serverUnitServicesDetail;
    }

    public void setServerUnitServicesDetail(String serverUnitServicesDetail) {
        this.serverUnitServicesDetail = serverUnitServicesDetail == null ? null : serverUnitServicesDetail.trim();
    }

    public String getServerUnitServicesType() {
        return serverUnitServicesType;
    }

    public void setServerUnitServicesType(String serverUnitServicesType) {
        this.serverUnitServicesType = serverUnitServicesType == null ? null : serverUnitServicesType.trim();
    }

    public String getServerUnitServicesAuditStatus() {
        return serverUnitServicesAuditStatus;
    }

    public void setServerUnitServicesAuditStatus(String serverUnitServicesAuditStatus) {
        this.serverUnitServicesAuditStatus = serverUnitServicesAuditStatus == null ? null : serverUnitServicesAuditStatus.trim();
    }

    public String getServerUnitServicesReleaseTime() {
        return serverUnitServicesReleaseTime;
    }

    public void setServerUnitServicesReleaseTime(String serverUnitServicesReleaseTime) {
        this.serverUnitServicesReleaseTime = serverUnitServicesReleaseTime == null ? null : serverUnitServicesReleaseTime.trim();
    }
}