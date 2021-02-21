package com.example.design.entity.server;

/**
 * 人工降雨
 */
public class ServerUnitServicesArtificialRainfall implements IServerUnitService {
    private Integer serverUnitServicesArtificialRainfallId;

    private String serverUnitServicesArtificialRainfallAircraftModel;

    private String serverUnitServicesArtificialRainfallCatalyzer;

    private String serverUnitServicesArtificialRainfallMaxDose;

    private String serverUnitServicesArtificialRainfallPrice;

    private String serverUnitServicesArtificialRainfallPhone;

    public ServerUnitServicesArtificialRainfall(String serverUnitServicesArtificialRainfallAircraftModel, String serverUnitServicesArtificialRainfallCatalyzer, String serverUnitServicesArtificialRainfallMaxDose, String serverUnitServicesArtificialRainfallPrice, String serverUnitServicesArtificialRainfallPhone) {
        this.serverUnitServicesArtificialRainfallAircraftModel = serverUnitServicesArtificialRainfallAircraftModel;
        this.serverUnitServicesArtificialRainfallCatalyzer = serverUnitServicesArtificialRainfallCatalyzer;
        this.serverUnitServicesArtificialRainfallMaxDose = serverUnitServicesArtificialRainfallMaxDose;
        this.serverUnitServicesArtificialRainfallPrice = serverUnitServicesArtificialRainfallPrice;
        this.serverUnitServicesArtificialRainfallPhone = serverUnitServicesArtificialRainfallPhone;
    }

    public ServerUnitServicesArtificialRainfall(Integer serverUnitServicesArtificialRainfallId, String serverUnitServicesArtificialRainfallAircraftModel, String serverUnitServicesArtificialRainfallCatalyzer, String serverUnitServicesArtificialRainfallMaxDose, String serverUnitServicesArtificialRainfallPrice, String serverUnitServicesArtificialRainfallPhone) {
        this.serverUnitServicesArtificialRainfallId = serverUnitServicesArtificialRainfallId;
        this.serverUnitServicesArtificialRainfallAircraftModel = serverUnitServicesArtificialRainfallAircraftModel;
        this.serverUnitServicesArtificialRainfallCatalyzer = serverUnitServicesArtificialRainfallCatalyzer;
        this.serverUnitServicesArtificialRainfallMaxDose = serverUnitServicesArtificialRainfallMaxDose;
        this.serverUnitServicesArtificialRainfallPrice = serverUnitServicesArtificialRainfallPrice;
        this.serverUnitServicesArtificialRainfallPhone = serverUnitServicesArtificialRainfallPhone;
    }

    public ServerUnitServicesArtificialRainfall() {
    }

    public Integer getServerUnitServicesArtificialRainfallId() {
        return serverUnitServicesArtificialRainfallId;
    }

    public void setServerUnitServicesArtificialRainfallId(Integer serverUnitServicesArtificialRainfallId) {
        this.serverUnitServicesArtificialRainfallId = serverUnitServicesArtificialRainfallId;
    }

    public String getServerUnitServicesArtificialRainfallAircraftModel() {
        return serverUnitServicesArtificialRainfallAircraftModel;
    }

    public void setServerUnitServicesArtificialRainfallAircraftModel(String serverUnitServicesArtificialRainfallAircraftModel) {
        this.serverUnitServicesArtificialRainfallAircraftModel = serverUnitServicesArtificialRainfallAircraftModel == null ? null : serverUnitServicesArtificialRainfallAircraftModel.trim();
    }

    public String getServerUnitServicesArtificialRainfallCatalyzer() {
        return serverUnitServicesArtificialRainfallCatalyzer;
    }

    public void setServerUnitServicesArtificialRainfallCatalyzer(String serverUnitServicesArtificialRainfallCatalyzer) {
        this.serverUnitServicesArtificialRainfallCatalyzer = serverUnitServicesArtificialRainfallCatalyzer == null ? null : serverUnitServicesArtificialRainfallCatalyzer.trim();
    }

    public String getServerUnitServicesArtificialRainfallMaxDose() {
        return serverUnitServicesArtificialRainfallMaxDose;
    }

    public void setServerUnitServicesArtificialRainfallMaxDose(String serverUnitServicesArtificialRainfallMaxDose) {
        this.serverUnitServicesArtificialRainfallMaxDose = serverUnitServicesArtificialRainfallMaxDose == null ? null : serverUnitServicesArtificialRainfallMaxDose.trim();
    }

    public String getServerUnitServicesArtificialRainfallPrice() {
        return serverUnitServicesArtificialRainfallPrice;
    }

    public void setServerUnitServicesArtificialRainfallPrice(String serverUnitServicesArtificialRainfallPrice) {
        this.serverUnitServicesArtificialRainfallPrice = serverUnitServicesArtificialRainfallPrice == null ? null : serverUnitServicesArtificialRainfallPrice.trim();
    }

    public String getServerUnitServicesArtificialRainfallPhone() {
        return serverUnitServicesArtificialRainfallPhone;
    }

    public void setServerUnitServicesArtificialRainfallPhone(String serverUnitServicesArtificialRainfallPhone) {
        this.serverUnitServicesArtificialRainfallPhone = serverUnitServicesArtificialRainfallPhone == null ? null : serverUnitServicesArtificialRainfallPhone.trim();
    }
}