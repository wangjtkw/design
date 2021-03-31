package com.example.design.entity.requestbean.user;

public class UserUpdatePW {
    private Integer usersAccountId;
    private String oldPW;
    private String newPW;

    public UserUpdatePW(Integer usersAccountId, String oldPW, String newPW) {
        this.usersAccountId = usersAccountId;
        this.oldPW = oldPW;
        this.newPW = newPW;
    }

    public Integer getUsersAccountId() {
        return usersAccountId;
    }

    public void setUsersAccountId(Integer usersAccountId) {
        this.usersAccountId = usersAccountId;
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
