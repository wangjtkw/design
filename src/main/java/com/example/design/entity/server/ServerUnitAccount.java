package com.example.design.entity.server;

public class ServerUnitAccount {
    private Integer serverUnitAccountId;

    private Integer serverUnitCompanyId;

    private String serverUnitAccountAccount;

    private String serverUnitAccountPassword;

    private String serverUnitAccountEmail;

    public ServerUnitAccount(String serverUnitAccountAccount, String serverUnitAccountPassword, String serverUnitAccountEmail) {
        this.serverUnitAccountAccount = serverUnitAccountAccount;
        this.serverUnitAccountPassword = serverUnitAccountPassword;
        this.serverUnitAccountEmail = serverUnitAccountEmail;
    }

    public Integer getServerUnitAccountId() {
        return serverUnitAccountId;
    }

    public void setServerUnitAccountId(Integer serverUnitAccountId) {
        this.serverUnitAccountId = serverUnitAccountId;
    }

    public Integer getServerUnitCompanyId() {
        return serverUnitCompanyId;
    }

    public void setServerUnitCompanyId(Integer serverUnitCompanyId) {
        this.serverUnitCompanyId = serverUnitCompanyId;
    }

    public String getServerUnitAccountAccount() {
        return serverUnitAccountAccount;
    }

    public void setServerUnitAccountAccount(String serverUnitAccountAccount) {
        this.serverUnitAccountAccount = serverUnitAccountAccount == null ? null : serverUnitAccountAccount.trim();
    }

    public String getServerUnitAccountPassword() {
        return serverUnitAccountPassword;
    }

    public void setServerUnitAccountPassword(String serverUnitAccountPassword) {
        this.serverUnitAccountPassword = serverUnitAccountPassword == null ? null : serverUnitAccountPassword.trim();
    }

    public String getServerUnitAccountEmail() {
        return serverUnitAccountEmail;
    }

    public void setServerUnitAccountEmail(String serverUnitAccountEmail) {
        this.serverUnitAccountEmail = serverUnitAccountEmail == null ? null : serverUnitAccountEmail.trim();
    }

    @Override
    public String toString() {
        return "ServerUnitAccount{" +
                "serverUnitAccountId=" + serverUnitAccountId +
                ", serverUnitCompanyId=" + serverUnitCompanyId +
                ", serverUnitAccountAccount='" + serverUnitAccountAccount + '\'' +
                ", serverUnitAccountPassword='" + serverUnitAccountPassword + '\'' +
                ", serverUnitAccountEmail='" + serverUnitAccountEmail + '\'' +
                '}';
    }

}