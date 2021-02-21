package com.example.design.entity.requestbean.user;

public class UserUpdatePW {
    private int usersAccountId;
    private String oldPW;
    private String newPW;

    public UserUpdatePW(int usersAccountId, String oldPW, String newPW) {
        this.usersAccountId = usersAccountId;
        this.oldPW = oldPW;
        this.newPW = newPW;
    }

    public int getUsersAccountId() {
        return usersAccountId;
    }

    public void setUsersAccountId(int usersAccountId) {
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
