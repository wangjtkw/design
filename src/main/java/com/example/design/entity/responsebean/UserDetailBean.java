package com.example.design.entity.responsebean;

public class UserDetailBean {

    private Integer usersAccountId;

    private Integer usersEssentialInformationId;

    private String usersAccountAccount;

    private String usersAccountEmail;

    private String usersEssentialInformationName;

    private String usersEssentialInformationIdNumber;

    private String usersEssentialInformationCompany;

    public UserDetailBean(Integer usersAccountId, Integer usersEssentialInformationId, String usersAccountAccount, String usersAccountEmail, String usersEssentialInformationName, String usersEssentialInformationIdNumber, String usersEssentialInformationCompany) {
        this.usersAccountId = usersAccountId;
        this.usersEssentialInformationId = usersEssentialInformationId;
        this.usersAccountAccount = usersAccountAccount;
        this.usersAccountEmail = usersAccountEmail;
        this.usersEssentialInformationName = usersEssentialInformationName;
        this.usersEssentialInformationIdNumber = usersEssentialInformationIdNumber;
        this.usersEssentialInformationCompany = usersEssentialInformationCompany;
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
        this.usersAccountAccount = usersAccountAccount;
    }

    public String getUsersAccountEmail() {
        return usersAccountEmail;
    }

    public void setUsersAccountEmail(String usersAccountEmail) {
        this.usersAccountEmail = usersAccountEmail;
    }

    public String getUsersEssentialInformationName() {
        return usersEssentialInformationName;
    }

    public void setUsersEssentialInformationName(String usersEssentialInformationName) {
        this.usersEssentialInformationName = usersEssentialInformationName;
    }

    public String getUsersEssentialInformationIdNumber() {
        return usersEssentialInformationIdNumber;
    }

    public void setUsersEssentialInformationIdNumber(String usersEssentialInformationIdNumber) {
        this.usersEssentialInformationIdNumber = usersEssentialInformationIdNumber;
    }

    public String getUsersEssentialInformationCompany() {
        return usersEssentialInformationCompany;
    }

    public void setUsersEssentialInformationCompany(String usersEssentialInformationCompany) {
        this.usersEssentialInformationCompany = usersEssentialInformationCompany;
    }
}
