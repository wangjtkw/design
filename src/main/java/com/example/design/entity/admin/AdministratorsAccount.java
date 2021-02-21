package com.example.design.entity.admin;

public class AdministratorsAccount {
    private Integer administratorsAccountId;

    private String administratorsAccountAccount;

    private String administratorsAccountPassword;

    public Integer getAdministratorsAccountId() {
        return administratorsAccountId;
    }

    public void setAdministratorsAccountId(Integer administratorsAccountId) {
        this.administratorsAccountId = administratorsAccountId;
    }

    public String getAdministratorsAccountAccount() {
        return administratorsAccountAccount;
    }

    public void setAdministratorsAccountAccount(String administratorsAccountAccount) {
        this.administratorsAccountAccount = administratorsAccountAccount == null ? null : administratorsAccountAccount.trim();
    }

    public String getAdministratorsAccountPassword() {
        return administratorsAccountPassword;
    }

    public void setAdministratorsAccountPassword(String administratorsAccountPassword) {
        this.administratorsAccountPassword = administratorsAccountPassword == null ? null : administratorsAccountPassword.trim();
    }
}