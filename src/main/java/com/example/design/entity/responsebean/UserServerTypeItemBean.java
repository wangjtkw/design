package com.example.design.entity.responsebean;

import com.example.design.entity.server.ServerUnitCompany;
import com.example.design.entity.server.ServerUnitServices;

public class UserServerTypeItemBean {
    private ServerUnitServices services;
    private ServerUnitCompany company;

    public UserServerTypeItemBean(ServerUnitServices services, ServerUnitCompany company) {
        this.services = services;
        this.company = company;
    }

    public ServerUnitServices getServices() {
        return services;
    }

    public void setServices(ServerUnitServices services) {
        this.services = services;
    }

    public ServerUnitCompany getCompany() {
        return company;
    }

    public void setCompany(ServerUnitCompany company) {
        this.company = company;
    }
}
