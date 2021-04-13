package com.example.design.entity.server;

public class ServerUnitServices {
    private Integer serverUnitServicesId;

    private Integer serverUnitAccountId;

    private Integer serverUnitServicesHelicopterRentalId;

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

    private String serverUnitServicesPhone;

    public ServerUnitServices(Integer serverUnitAccountId, String serverUnitServicesTitle, String serverUnitServicesImg, String serverUnitServicesDetail, String serverUnitServicesType, String serverUnitServicesAuditStatus, String serverUnitServicesPhone) {
        this.serverUnitAccountId = serverUnitAccountId;
        this.serverUnitServicesTitle = serverUnitServicesTitle;
        this.serverUnitServicesImg = serverUnitServicesImg;
        this.serverUnitServicesDetail = serverUnitServicesDetail;
        this.serverUnitServicesType = serverUnitServicesType;
        this.serverUnitServicesAuditStatus = serverUnitServicesAuditStatus;
        this.serverUnitServicesPhone = serverUnitServicesPhone;
    }

    public ServerUnitServices(Integer serverUnitServicesId, Integer serverUnitAccountId, String serverUnitServicesTitle, String serverUnitServicesImg, String serverUnitServicesDetail, String serverUnitServicesType, String serverUnitServicesAuditStatus, String serverUnitServicesPhone) {
        this.serverUnitServicesId = serverUnitServicesId;
        this.serverUnitAccountId = serverUnitAccountId;
        this.serverUnitServicesTitle = serverUnitServicesTitle;
        this.serverUnitServicesImg = serverUnitServicesImg;
        this.serverUnitServicesDetail = serverUnitServicesDetail;
        this.serverUnitServicesType = serverUnitServicesType;
        this.serverUnitServicesAuditStatus = serverUnitServicesAuditStatus;
        this.serverUnitServicesPhone = serverUnitServicesPhone;
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
        this.serverUnitServicesTitle = serverUnitServicesTitle;
    }

    public String getServerUnitServicesImg() {
        return serverUnitServicesImg;
    }

    public void setServerUnitServicesImg(String serverUnitServicesImg) {
        this.serverUnitServicesImg = serverUnitServicesImg;
    }

    public String getServerUnitServicesDetail() {
        return serverUnitServicesDetail;
    }

    public void setServerUnitServicesDetail(String serverUnitServicesDetail) {
        this.serverUnitServicesDetail = serverUnitServicesDetail;
    }

    public String getServerUnitServicesType() {
        return serverUnitServicesType;
    }

    public void setServerUnitServicesType(String serverUnitServicesType) {
        this.serverUnitServicesType = serverUnitServicesType;
    }

    public String getServerUnitServicesAuditStatus() {
        return serverUnitServicesAuditStatus;
    }

    public void setServerUnitServicesAuditStatus(String serverUnitServicesAuditStatus) {
        this.serverUnitServicesAuditStatus = serverUnitServicesAuditStatus;
    }

    public String getServerUnitServicesReleaseTime() {
        return serverUnitServicesReleaseTime;
    }

    public void setServerUnitServicesReleaseTime(String serverUnitServicesReleaseTime) {
        this.serverUnitServicesReleaseTime = serverUnitServicesReleaseTime;
    }

    public String getServerUnitServicesPhone() {
        return serverUnitServicesPhone;
    }

    public void setServerUnitServicesPhone(String serverUnitServicesPhone) {
        this.serverUnitServicesPhone = serverUnitServicesPhone;
    }

    @Override
    public String toString() {
        return "ServerUnitServices{" +
                "serverUnitServicesId=" + serverUnitServicesId +
                ", serverUnitAccountId=" + serverUnitAccountId +
                ", serverUnitServicesHelicopterRentalId=" + serverUnitServicesHelicopterRentalId +
                ", serverUnitServicesParachuteFlightId=" + serverUnitServicesParachuteFlightId +
                ", serverUnitServicesAirTourId=" + serverUnitServicesAirTourId +
                ", serverUnitServicesCharteredAirplaneId=" + serverUnitServicesCharteredAirplaneId +
                ", serverUnitServicesArtificialRainfallId=" + serverUnitServicesArtificialRainfallId +
                ", serverUnitServicesTitle='" + serverUnitServicesTitle + '\'' +
                ", serverUnitServicesImg='" + serverUnitServicesImg + '\'' +
                ", serverUnitServicesDetail='" + serverUnitServicesDetail + '\'' +
                ", serverUnitServicesType='" + serverUnitServicesType + '\'' +
                ", serverUnitServicesAuditStatus='" + serverUnitServicesAuditStatus + '\'' +
                ", serverUnitServicesReleaseTime='" + serverUnitServicesReleaseTime + '\'' +
                ", serverUnitServicesPhone='" + serverUnitServicesPhone + '\'' +
                '}';
    }
}