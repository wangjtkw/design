package com.example.design.entity.responsebean;

import com.example.design.entity.server.IServerUnitService;
import com.example.design.entity.server.ServerUnitServices;

public class ServerUnitServicesDetail {
    private ServerUnitServices services;
    private IServerUnitService iServerUnitService;

    public ServerUnitServicesDetail(ServerUnitServices services, IServerUnitService iServerUnitService) {
        this.services = services;
        this.iServerUnitService = iServerUnitService;
    }

    public ServerUnitServices getServices() {
        return services;
    }

    public void setServices(ServerUnitServices services) {
        this.services = services;
    }

    public IServerUnitService getiServerUnitService() {
        return iServerUnitService;
    }

    public void setiServerUnitService(IServerUnitService iServerUnitService) {
        this.iServerUnitService = iServerUnitService;
    }

    @Override
    public String toString() {
        return "ServerUnitServicesDetail{" +
                "services=" + services +
                ", iServerUnitService=" + iServerUnitService +
                '}';
    }
}
