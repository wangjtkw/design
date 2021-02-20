package com.example.design.entity.server;

import com.example.design.entity.IServerUnitService;

/**
 * 人工降雨
 */
public class ServerUnitServicesArtificialRainfall implements IServerUnitService {
    private Integer serverUnitServicesArtificialRainfallId;

    private Integer serverUnitServicesId;

    private String serverUnitServicesArtificialRainfallAircraftModel;

    private String serverUnitServicesArtificialRainfallCatalyzer;

    private String serverUnitServicesArtificialRainfallMaxDose;

    private String serverUnitServicesArtificialRainfallPrice;

    private String serverUnitServicesArtificialRainfallPhone;

    public ServerUnitServicesArtificialRainfall(Integer serverUnitServicesId, String serverUnitServicesArtificialRainfallAircraftModel, String serverUnitServicesArtificialRainfallCatalyzer, String serverUnitServicesArtificialRainfallMaxDose, String serverUnitServicesArtificialRainfallPrice, String serverUnitServicesArtificialRainfallPhone) {
        this.serverUnitServicesId = serverUnitServicesId;
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

    public Integer getServerUnitServicesId() {
        return serverUnitServicesId;
    }

    public void setServerUnitServicesId(Integer serverUnitServicesId) {
        this.serverUnitServicesId = serverUnitServicesId;
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