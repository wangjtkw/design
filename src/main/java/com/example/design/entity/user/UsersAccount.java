package com.example.design.entity.user;

public class UsersAccount {
    private Integer usersAccountId;

    private Integer usersEssentialInformationId;

    private String usersAccountAccount;

    private String usersAccountPassword;

    private String usersAccountEmail;

    public UsersAccount(String usersAccountAccount, String usersAccountPassword, String usersAccountEmail) {
        this.usersAccountAccount = usersAccountAccount;
        this.usersAccountPassword = usersAccountPassword;
        this.usersAccountEmail = usersAccountEmail;
    }

    public Integer getUsersAccountId() {
        return usersAccountId;
    }

    public void setUsersAccountId(Integer usersAccountId) {
        this.usersAccountId = usersAccountId;
    }

    public Integer getUsersEssentialInformationId() {
        return usersEssentialInformationId;
    }

    public void setUsersEssentialInformationId(Integer usersEssentialInformationId) {
        this.usersEssentialInformationId = usersEssentialInformationId;
    }

    public String getUsersAccountAccount() {
        return usersAccountAccount;
    }

    public void setUsersAccountAccount(String usersAccountAccount) {
        this.usersAccountAccount = usersAccountAccount == null ? null : usersAccountAccount.trim();
    }

    public String getUsersAccountPassword() {
        return usersAccountPassword;
    }

    public void setUsersAccountPassword(String usersAccountPassword) {
        this.usersAccountPassword = usersAccountPassword == null ? null : usersAccountPassword.trim();
    }

    public String getUsersAccountEmail() {
        return usersAccountEmail;
    }

    public void setUsersAccountEmail(String usersAccountEmail) {
        this.usersAccountEmail = usersAccountEmail == null ? null : usersAccountEmail.trim();
    }
}