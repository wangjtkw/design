package com.example.design.entity.requestbean.admin;

public class AdminLogin {
    private String adminAccount;
    private String adminPW;

    public AdminLogin(String adminAccount, String adminPW) {
        this.adminAccount = adminAccount;
        this.adminPW = adminPW;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPW() {
        return adminPW;
    }

    public void setAdminPW(String adminPW) {
        this.adminPW = adminPW;
    }
}
