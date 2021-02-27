package com.example.design.entity.responsebean;

import com.example.design.entity.server.ServerUnitCompany;

public class OrderDetailBean {
    UserPayBean payBean;
    ServerUnitCompany company;
    ServerUnitServicesDetail serverUnitServicesDetail;
    UserDetailBean userDetailBean;

    public UserPayBean getPayBean() {
        return payBean;
    }

    public void setPayBean(UserPayBean payBean) {
        this.payBean = payBean;
    }

    public ServerUnitCompany getCompany() {
        return company;
    }

    public void setCompany(ServerUnitCompany company) {
        this.company = company;
    }

    public ServerUnitServicesDetail getServerUnitServicesDetail() {
        return serverUnitServicesDetail;
    }

    public void setServerUnitServicesDetail(ServerUnitServicesDetail serverUnitServicesDetail) {
        this.serverUnitServicesDetail = serverUnitServicesDetail;
    }

    public UserDetailBean getUserDetailBean() {
        return userDetailBean;
    }

    public void setUserDetailBean(UserDetailBean userDetailBean) {
        this.userDetailBean = userDetailBean;
    }
}
