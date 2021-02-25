package com.example.design.entity.user;

public class UsersEssentialInformation {
    private Integer usersEssentialInformationId;

    private String usersEssentialInformationName;

    private String usersEssentialInformationIdNumber;

    private String usersEssentialInformationCompany;

    public UsersEssentialInformation(String usersEssentialInformationName, String usersEssentialInformationIdNumber, String usersEssentialInformationCompany) {
        this.usersEssentialInformationName = usersEssentialInformationName;
        this.usersEssentialInformationIdNumber = usersEssentialInformationIdNumber;
        this.usersEssentialInformationCompany = usersEssentialInformationCompany;
    }

    public Integer getUsersEssentialInformationId() {
        return usersEssentialInformationId;
    }

    public void setUsersEssentialInformationId(Integer usersEssentialInformationId) {
        this.usersEssentialInformationId = usersEssentialInformationId;
    }

    public String getUsersEssentialInformationName() {
        return usersEssentialInformationName;
    }

    public void setUsersEssentialInformationName(String usersEssentialInformationName) {
        this.usersEssentialInformationName = usersEssentialInformationName == null ? null : usersEssentialInformationName.trim();
    }

    public String getUsersEssentialInformationIdNumber() {
        return usersEssentialInformationIdNumber;
    }

    public void setUsersEssentialInformationIdNumber(String usersEssentialInformationIdNumber) {
        this.usersEssentialInformationIdNumber = usersEssentialInformationIdNumber == null ? null : usersEssentialInformationIdNumber.trim();
    }

    public String getUsersEssentialInformationCompany() {
        return usersEssentialInformationCompany;
    }

    public void setUsersEssentialInformationCompany(String usersEssentialInformationCompany) {
        this.usersEssentialInformationCompany = usersEssentialInformationCompany == null ? null : usersEssentialInformationCompany.trim();
    }
}