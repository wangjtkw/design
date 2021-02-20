package com.example.design.entity.server;

import com.example.design.entity.IServerUnitService;

/**
 * 空中游览
 */
public class ServerUnitServicesAirTour implements IServerUnitService {
    private Integer serverUnitServicesAirTourId;

    private Integer serverUnitServicesId;

    private String serverUnitServicesAirTourSightseeingPlaces;

    private String serverUnitServicesAirTourDuration;

    private String serverUnitServicesAirTourAircraftModel;

    private String serverUnitServicesAirTourNumberLimit;

    private String serverUnitServicesAirTourBoardingLocation;

    private String serverUnitServicesAirTourPrice;

    public ServerUnitServicesAirTour(Integer serverUnitServicesAirTourId, String serverUnitServicesAirTourSightseeingPlaces, String serverUnitServicesAirTourDuration, String serverUnitServicesAirTourAircraftModel, String serverUnitServicesAirTourNumberLimit, String serverUnitServicesAirTourBoardingLocation, String serverUnitServicesAirTourPrice) {
        this.serverUnitServicesAirTourId = serverUnitServicesAirTourId;
        this.serverUnitServicesAirTourSightseeingPlaces = serverUnitServicesAirTourSightseeingPlaces;
        this.serverUnitServicesAirTourDuration = serverUnitServicesAirTourDuration;
        this.serverUnitServicesAirTourAircraftModel = serverUnitServicesAirTourAircraftModel;
        this.serverUnitServicesAirTourNumberLimit = serverUnitServicesAirTourNumberLimit;
        this.serverUnitServicesAirTourBoardingLocation = serverUnitServicesAirTourBoardingLocation;
        this.serverUnitServicesAirTourPrice = serverUnitServicesAirTourPrice;
    }


    public Integer getServerUnitServicesAirTourId() {
        return serverUnitServicesAirTourId;
    }

    public void setServerUnitServicesAirTourId(Integer serverUnitServicesAirTourId) {
        this.serverUnitServicesAirTourId = serverUnitServicesAirTourId;
    }

    public Integer getServerUnitServicesId() {
        return serverUnitServicesId;
    }

    public void setServerUnitServicesId(Integer serverUnitServicesId) {
        this.serverUnitServicesId = serverUnitServicesId;
    }

    public String getServerUnitServicesAirTourSightseeingPlaces() {
        return serverUnitServicesAirTourSightseeingPlaces;
    }

    public void setServerUnitServicesAirTourSightseeingPlaces(String serverUnitServicesAirTourSightseeingPlaces) {
        this.serverUnitServicesAirTourSightseeingPlaces = serverUnitServicesAirTourSightseeingPlaces == null ? null : serverUnitServicesAirTourSightseeingPlaces.trim();
    }

    public String getServerUnitServicesAirTourDuration() {
        return serverUnitServicesAirTourDuration;
    }

    public void setServerUnitServicesAirTourDuration(String serverUnitServicesAirTourDuration) {
        this.serverUnitServicesAirTourDuration = serverUnitServicesAirTourDuration == null ? null : serverUnitServicesAirTourDuration.trim();
    }

    public String getServerUnitServicesAirTourAircraftModel() {
        return serverUnitServicesAirTourAircraftModel;
    }

    public void setServerUnitServicesAirTourAircraftModel(String serverUnitServicesAirTourAircraftModel) {
        this.serverUnitServicesAirTourAircraftModel = serverUnitServicesAirTourAircraftModel == null ? null : serverUnitServicesAirTourAircraftModel.trim();
    }

    public String getServerUnitServicesAirTourNumberLimit() {
        return serverUnitServicesAirTourNumberLimit;
    }

    public void setServerUnitServicesAirTourNumberLimit(String serverUnitServicesAirTourNumberLimit) {
        this.serverUnitServicesAirTourNumberLimit = serverUnitServicesAirTourNumberLimit == null ? null : serverUnitServicesAirTourNumberLimit.trim();
    }

    public String getServerUnitServicesAirTourBoardingLocation() {
        return serverUnitServicesAirTourBoardingLocation;
    }

    public void setServerUnitServicesAirTourBoardingLocation(String serverUnitServicesAirTourBoardingLocation) {
        this.serverUnitServicesAirTourBoardingLocation = serverUnitServicesAirTourBoardingLocation == null ? null : serverUnitServicesAirTourBoardingLocation.trim();
    }

    public String getServerUnitServicesAirTourPrice() {
        return serverUnitServicesAirTourPrice;
    }

    public void setServerUnitServicesAirTourPrice(String serverUnitServicesAirTourPrice) {
        this.serverUnitServicesAirTourPrice = serverUnitServicesAirTourPrice == null ? null : serverUnitServicesAirTourPrice.trim();
    }
}