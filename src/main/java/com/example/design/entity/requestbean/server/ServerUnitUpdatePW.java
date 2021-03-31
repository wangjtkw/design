package com.example.design.entity.requestbean.server;

public class ServerUnitUpdatePW {
    private Integer serverUnitAccountId;

    private String oldPW;

    private String newPW;

    public ServerUnitUpdatePW(Integer serverUnitAccountId, String oldPW, String newPW) {
        this.serverUnitAccountId = serverUnitAccountId;
        this.oldPW = oldPW;
        this.newPW = newPW;
    }

    public Integer getServerUnitAccountId() {
        return serverUnitAccountId;
    }

    public void setServerUnitAccountId(Integer serverUnitAccountId) {
        this.serverUnitAccountId = serverUnitAccountId;
    }

    public String getOldPW() {
        return oldPW;
    }

    public void setOldPW(String oldPW) {
        this.oldPW = oldPW;
    }

    public String getNewPW() {
        return newPW;
    }

    public void setNewPW(String newPW) {
        this.newPW = newPW;
    }
}
