package com.example.design.entity.server;

/**
 * 包机飞行
 */
public class ServerUnitServicesCharteredAirplane implements IServerUnitService {
    private Integer serverUnitServicesCharteredAirplaneId;

    private String serverUnitServicesCharteredAirplaneStartAddress;

    private String serverUnitServicesCharteredAirplaneEndAddress;

    private String serverUnitServicesCharteredAirplaneAircraftModel;

    private String serverUnitServicesCharteredAirplaneSeatsNum;

    private String serverUnitServicesCharteredAirplaneBoardingLocation;

    private String serverUnitServicesCharteredAirplanePrice;

    public Integer getServerUnitServicesCharteredAirplaneId() {
        return serverUnitServicesCharteredAirplaneId;
    }

    public void setServerUnitServicesCharteredAirplaneId(Integer serverUnitServicesCharteredAirplaneId) {
        this.serverUnitServicesCharteredAirplaneId = serverUnitServicesCharteredAirplaneId;
    }

    public ServerUnitServicesCharteredAirplane( String serverUnitServicesCharteredAirplaneStartAddress, String serverUnitServicesCharteredAirplaneEndAddress, String serverUnitServicesCharteredAirplaneAircraftModel, String serverUnitServicesCharteredAirplaneSeatsNum, String serverUnitServicesCharteredAirplaneBoardingLocation, String serverUnitServicesCharteredAirplanePrice) {
        this.serverUnitServicesCharteredAirplaneStartAddress = serverUnitServicesCharteredAirplaneStartAddress;
        this.serverUnitServicesCharteredAirplaneEndAddress = serverUnitServicesCharteredAirplaneEndAddress;
        this.serverUnitServicesCharteredAirplaneAircraftModel = serverUnitServicesCharteredAirplaneAircraftModel;
        this.serverUnitServicesCharteredAirplaneSeatsNum = serverUnitServicesCharteredAirplaneSeatsNum;
        this.serverUnitServicesCharteredAirplaneBoardingLocation = serverUnitServicesCharteredAirplaneBoardingLocation;
        this.serverUnitServicesCharteredAirplanePrice = serverUnitServicesCharteredAirplanePrice;
    }

    public ServerUnitServicesCharteredAirplane(Integer serverUnitServicesCharteredAirplaneId, String serverUnitServicesCharteredAirplaneStartAddress, String serverUnitServicesCharteredAirplaneEndAddress, String serverUnitServicesCharteredAirplaneAircraftModel, String serverUnitServicesCharteredAirplaneSeatsNum, String serverUnitServicesCharteredAirplaneBoardingLocation, String serverUnitServicesCharteredAirplanePrice) {
        this.serverUnitServicesCharteredAirplaneId = serverUnitServicesCharteredAirplaneId;
        this.serverUnitServicesCharteredAirplaneStartAddress = serverUnitServicesCharteredAirplaneStartAddress;
        this.serverUnitServicesCharteredAirplaneEndAddress = serverUnitServicesCharteredAirplaneEndAddress;
        this.serverUnitServicesCharteredAirplaneAircraftModel = serverUnitServicesCharteredAirplaneAircraftModel;
        this.serverUnitServicesCharteredAirplaneSeatsNum = serverUnitServicesCharteredAirplaneSeatsNum;
        this.serverUnitServicesCharteredAirplaneBoardingLocation = serverUnitServicesCharteredAirplaneBoardingLocation;
        this.serverUnitServicesCharteredAirplanePrice = serverUnitServicesCharteredAirplanePrice;
    }

    public String getServerUnitServicesCharteredAirplaneStartAddress() {
        return serverUnitServicesCharteredAirplaneStartAddress;
    }

    public void setServerUnitServicesCharteredAirplaneStartAddress(String serverUnitServicesCharteredAirplaneStartAddress) {
        this.serverUnitServicesCharteredAirplaneStartAddress = serverUnitServicesCharteredAirplaneStartAddress == null ? null : serverUnitServicesCharteredAirplaneStartAddress.trim();
    }

    public String getServerUnitServicesCharteredAirplaneEndAddress() {
        return serverUnitServicesCharteredAirplaneEndAddress;
    }

    public void setServerUnitServicesCharteredAirplaneEndAddress(String serverUnitServicesCharteredAirplaneEndAddress) {
        this.serverUnitServicesCharteredAirplaneEndAddress = serverUnitServicesCharteredAirplaneEndAddress == null ? null : serverUnitServicesCharteredAirplaneEndAddress.trim();
    }

    public String getServerUnitServicesCharteredAirplaneAircraftModel() {
        return serverUnitServicesCharteredAirplaneAircraftModel;
    }

    public void setServerUnitServicesCharteredAirplaneAircraftModel(String serverUnitServicesCharteredAirplaneAircraftModel) {
        this.serverUnitServicesCharteredAirplaneAircraftModel = serverUnitServicesCharteredAirplaneAircraftModel == null ? null : serverUnitServicesCharteredAirplaneAircraftModel.trim();
    }

    public String getServerUnitServicesCharteredAirplaneSeatsNum() {
        return serverUnitServicesCharteredAirplaneSeatsNum;
    }

    public void setServerUnitServicesCharteredAirplaneSeatsNum(String serverUnitServicesCharteredAirplaneSeatsNum) {
        this.serverUnitServicesCharteredAirplaneSeatsNum = serverUnitServicesCharteredAirplaneSeatsNum == null ? null : serverUnitServicesCharteredAirplaneSeatsNum.trim();
    }

    public String getServerUnitServicesCharteredAirplaneBoardingLocation() {
        return serverUnitServicesCharteredAirplaneBoardingLocation;
    }

    public void setServerUnitServicesCharteredAirplaneBoardingLocation(String serverUnitServicesCharteredAirplaneBoardingLocation) {
        this.serverUnitServicesCharteredAirplaneBoardingLocation = serverUnitServicesCharteredAirplaneBoardingLocation == null ? null : serverUnitServicesCharteredAirplaneBoardingLocation.trim();
    }

    public String getServerUnitServicesCharteredAirplanePrice() {
        return serverUnitServicesCharteredAirplanePrice;
    }

    public void setServerUnitServicesCharteredAirplanePrice(String serverUnitServicesCharteredAirplanePrice) {
        this.serverUnitServicesCharteredAirplanePrice = serverUnitServicesCharteredAirplanePrice == null ? null : serverUnitServicesCharteredAirplanePrice.trim();
    }
}