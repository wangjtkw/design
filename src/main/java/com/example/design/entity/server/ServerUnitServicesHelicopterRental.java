package com.example.design.entity.server;

/**
 * 直升机租赁
 */
public class ServerUnitServicesHelicopterRental implements IServerUnitService {
    private Integer serverUnitServicesHelicopterRentalId;

    private String serverUnitServicesHelicopterRentalAircraftModel;

    private String serverUnitServicesHelicopterRentalPrice;


    public ServerUnitServicesHelicopterRental(String serverUnitServicesHelicopterRentalAircraftModel, String serverUnitServicesHelicopterRentalPrice) {
        this.serverUnitServicesHelicopterRentalAircraftModel = serverUnitServicesHelicopterRentalAircraftModel;
        this.serverUnitServicesHelicopterRentalPrice = serverUnitServicesHelicopterRentalPrice;
         }

    public ServerUnitServicesHelicopterRental(Integer serverUnitServicesHelicopterRentalId, String serverUnitServicesHelicopterRentalAircraftModel, String serverUnitServicesHelicopterRentalPrice) {
        this.serverUnitServicesHelicopterRentalId = serverUnitServicesHelicopterRentalId;
        this.serverUnitServicesHelicopterRentalAircraftModel = serverUnitServicesHelicopterRentalAircraftModel;
        this.serverUnitServicesHelicopterRentalPrice = serverUnitServicesHelicopterRentalPrice;
    }

    public ServerUnitServicesHelicopterRental() {
    }

    public Integer getServerUnitServicesHelicopterRentalId() {
        return serverUnitServicesHelicopterRentalId;
    }

    public void setServerUnitServicesHelicopterRentalId(Integer serverUnitServicesHelicopterRentalId) {
        this.serverUnitServicesHelicopterRentalId = serverUnitServicesHelicopterRentalId;
    }

    public String getServerUnitServicesHelicopterRentalAircraftModel() {
        return serverUnitServicesHelicopterRentalAircraftModel;
    }

    public void setServerUnitServicesHelicopterRentalAircraftModel(String serverUnitServicesHelicopterRentalAircraftModel) {
        this.serverUnitServicesHelicopterRentalAircraftModel = serverUnitServicesHelicopterRentalAircraftModel == null ? null : serverUnitServicesHelicopterRentalAircraftModel.trim();
    }

    public String getServerUnitServicesHelicopterRentalPrice() {
        return serverUnitServicesHelicopterRentalPrice;
    }

    public void setServerUnitServicesHelicopterRentalPrice(String serverUnitServicesHelicopterRentalPrice) {
        this.serverUnitServicesHelicopterRentalPrice = serverUnitServicesHelicopterRentalPrice == null ? null : serverUnitServicesHelicopterRentalPrice.trim();
    }

}