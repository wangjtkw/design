package com.example.design.entity.responsebean;

import com.example.design.entity.server.IServerUnitService;
import com.example.design.entity.server.ServerUnitCompany;
import com.example.design.entity.server.ServerUnitServices;

public class UserServerItemDetailBean {
    private ServerUnitServices services;
    private IServerUnitService iServerUnitService;
    private ServerUnitCompany company;

    public UserServerItemDetailBean(ServerUnitServices services, IServerUnitService iServerUnitService, ServerUnitCompany company) {
        this.services = services;
        this.iServerUnitService = iServerUnitService;
        this.company = company;
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

    public ServerUnitCompany getCompany() {
        return company;
    }

    public void setCompany(ServerUnitCompany company) {
        this.company = company;
    }
}
