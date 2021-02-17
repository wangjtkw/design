package com.example.design.entity;

/**
 * 直升机租赁
 */
public class ServerUnitServicesHelicopterRental {
    private Integer serverUnitServicesHelicopterRentalId;

    private Integer serverUnitServicesId;

    private String serverUnitServicesHelicopterRentalAircraftModel;

    private String serverUnitServicesHelicopterRentalPrice;

    private String serverUnitServicesHelicopterRentalPhone;

    public ServerUnitServicesHelicopterRental(Integer serverUnitServicesId, String serverUnitServicesHelicopterRentalAircraftModel, String serverUnitServicesHelicopterRentalPrice, String serverUnitServicesHelicopterRentalPhone) {
        this.serverUnitServicesId = serverUnitServicesId;
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

    public Integer getServerUnitServicesId() {
        return serverUnitServicesId;
    }

    public void setServerUnitServicesId(Integer serverUnitServicesId) {
        this.serverUnitServicesId = serverUnitServicesId;
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