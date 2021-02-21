package com.example.design.entity.server;

/**
 * 跳伞飞行
 */
public class ServerUnitServicesParachuteFlight implements IServerUnitService {
    private Integer serverUnitServicesParachuteFlightId;

    private String serverUnitServicesParachuteFlightAddress;

    private String serverUnitServicesParachuteFlightAircraftModel;

    private String serverUnitServicesParachuteFlightPrice;

    public ServerUnitServicesParachuteFlight(String serverUnitServicesParachuteFlightAddress, String serverUnitServicesParachuteFlightAircraftModel, String serverUnitServicesParachuteFlightPrice) {
        this.serverUnitServicesParachuteFlightAddress = serverUnitServicesParachuteFlightAddress;
        this.serverUnitServicesParachuteFlightAircraftModel = serverUnitServicesParachuteFlightAircraftModel;
        this.serverUnitServicesParachuteFlightPrice = serverUnitServicesParachuteFlightPrice;
    }

    public ServerUnitServicesParachuteFlight(Integer serverUnitServicesParachuteFlightId, String serverUnitServicesParachuteFlightAddress, String serverUnitServicesParachuteFlightAircraftModel, String serverUnitServicesParachuteFlightPrice) {
        this.serverUnitServicesParachuteFlightId = serverUnitServicesParachuteFlightId;
        this.serverUnitServicesParachuteFlightAddress = serverUnitServicesParachuteFlightAddress;
        this.serverUnitServicesParachuteFlightAircraftModel = serverUnitServicesParachuteFlightAircraftModel;
        this.serverUnitServicesParachuteFlightPrice = serverUnitServicesParachuteFlightPrice;
    }

    public ServerUnitServicesParachuteFlight() {
    }

    public Integer getServerUnitServicesParachuteFlightId() {
        return serverUnitServicesParachuteFlightId;
    }

    public void setServerUnitServicesParachuteFlightId(Integer serverUnitServicesParachuteFlightId) {
        this.serverUnitServicesParachuteFlightId = serverUnitServicesParachuteFlightId;
    }

    public String getServerUnitServicesParachuteFlightAddress() {
        return serverUnitServicesParachuteFlightAddress;
    }

    public void setServerUnitServicesParachuteFlightAddress(String serverUnitServicesParachuteFlightAddress) {
        this.serverUnitServicesParachuteFlightAddress = serverUnitServicesParachuteFlightAddress == null ? null : serverUnitServicesParachuteFlightAddress.trim();
    }

    public String getServerUnitServicesParachuteFlightAircraftModel() {
        return serverUnitServicesParachuteFlightAircraftModel;
    }

    public void setServerUnitServicesParachuteFlightAircraftModel(String serverUnitServicesParachuteFlightAircraftModel) {
        this.serverUnitServicesParachuteFlightAircraftModel = serverUnitServicesParachuteFlightAircraftModel == null ? null : serverUnitServicesParachuteFlightAircraftModel.trim();
    }

    public String getServerUnitServicesParachuteFlightPrice() {
        return serverUnitServicesParachuteFlightPrice;
    }

    public void setServerUnitServicesParachuteFlightPrice(String serverUnitServicesParachuteFlightPrice) {
        this.serverUnitServicesParachuteFlightPrice = serverUnitServicesParachuteFlightPrice == null ? null : serverUnitServicesParachuteFlightPrice.trim();
    }
}