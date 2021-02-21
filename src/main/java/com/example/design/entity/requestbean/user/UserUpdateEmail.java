package com.example.design.entity.requestbean.user;

public class UserUpdateEmail {
    private int usersAccountId;
    private String pw;
    private String newEmail;

    public UserUpdateEmail(int usersAccountId, String pw, String newEmail) {
        this.usersAccountId = usersAccountId;
        this.pw = pw;
        this.newEmail = newEmail;
    }

    public int getUsersAccountId() {
        return usersAccountId;
    }

    public void setUsersAccountId(int usersAccountId) {
        this.usersAccountId = usersAccountId;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
