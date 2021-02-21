package com.example.design.entity.server;

/**
 * 直升机租赁
 */
public class ServerUnitServicesHelicopterRental implements IServerUnitService {
    private Integer serverUnitServicesHelicopterRentalId;

    private String serverUnitServicesHelicopterRentalAircraftModel;

    private String serverUnitServicesHelicopterRentalPrice;

    private String serverUnitServicesHelicopterRentalPhone;

    public ServerUnitServicesHelicopterRental(String serverUnitServicesHelicopterRentalAircraftModel, String serverUnitServicesHelicopterRentalPrice, String serverUnitServicesHelicopterRentalPhone) {
        this.serverUnitServicesHelicopterRentalAircraftModel = serverUnitServicesHelicopterRentalAircraftModel;
        this.serverUnitServicesHelicopterRentalPrice = serverUnitServicesHelicopterRentalPrice;
        this.serverUnitServicesHelicopterRentalPhone = serverUnitServicesHelicopterRentalPhone;
    }

    public ServerUnitServicesHelicopterRental(Integer serverUnitServicesHelicopterRentalId, String serverUnitServicesHelicopterRentalAircraftModel, String serverUnitServicesHelicopterRentalPrice, String serverUnitServicesHelicopterRentalPhone) {
        this.serverUnitServicesHelicopterRentalId = serverUnitServicesHelicopterRentalId;
        this.serverUnitServicesHelicopterRentalAircraftModel = serverUnitServicesHelicopterRentalAircraftModel;
        this.serverUnitServicesHelicopterRentalPrice = serverUnitServicesHelicopterRentalPrice;
        this.serverUnitServicesHelicopterRentalPhone = serverUnitServicesHelicopterRentalPhone;
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

    public String getServerUnitServicesHelicopterRentalPhone() {
        return serverUnitServicesHelicopterRentalPhone;
    }

    public void setServerUnitServicesHelicopterRentalPhone(String serverUnitServicesHelicopterRentalPhone) {
        this.serverUnitServicesHelicopterRentalPhone = serverUnitServicesHelicopterRentalPhone == null ? null : serverUnitServicesHelicopterRentalPhone.trim();
    }
}