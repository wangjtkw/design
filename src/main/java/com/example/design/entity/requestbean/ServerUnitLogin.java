package com.example.design.entity.requestbean;

public class ServerUnitLogin {
    private String serverUnitAccountAccount;

    private String serverUnitAccountPassword;

    public String getServerUnitAccountAccount() {
        return serverUnitAccountAccount;
    }

    public void setServerUnitAccountAccount(String serverUnitAccountAccount) {
        this.serverUnitAccountAccount = serverUnitAccountAccount;
    }

    public String getServerUnitAccountPassword() {
        return serverUnitAccountPassword;
    }

    public void setServerUnitAccountPassword(String serverUnitAccountPassword) {
        this.serverUnitAccountPassword = serverUnitAccountPassword;
    }

    @Override
    public String toString() {
        return "ServerUnitLogin{" +
                "serverUnitAccountAccount='" + serverUnitAccountAccount + '\'' +
                ", serverUnitAccountPassword='" + serverUnitAccountPassword + '\'' +
                '}';
    }
}
