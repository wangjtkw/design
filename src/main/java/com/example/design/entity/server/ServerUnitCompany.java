package com.example.design.entity.server;

public class ServerUnitCompany {
    private Integer serverUnitCompanyId;

    private String serverUnitCompanyName;

    private String serverUnitCompanyBase;

    private String serverUnitCompanyAirport;

    private String serverUnitCompanyType;

    private String serverUnitCompanyCapital;

    private String serverUnitCompanyLegalRepresentativeName;

    private String serverUnitCompanyLegalRepresentativePhone;

    private String serverUnitCompanyValidityTerm;

    private String serverUnitCompanyScope;

    private String serverUnitCompanyAuditStatus;

    public Integer getServerUnitCompanyId() {
        return serverUnitCompanyId;
    }

    public void setServerUnitCompanyId(Integer serverUnitCompanyId) {
        this.serverUnitCompanyId = serverUnitCompanyId;
    }

    public String getServerUnitCompanyName() {
        return serverUnitCompanyName;
    }

    public void setServerUnitCompanyName(String serverUnitCompanyName) {
        this.serverUnitCompanyName = serverUnitCompanyName == null ? null : serverUnitCompanyName.trim();
    }

    public String getServerUnitCompanyBase() {
        return serverUnitCompanyBase;
    }

    public void setServerUnitCompanyBase(String serverUnitCompanyBase) {
        this.serverUnitCompanyBase = serverUnitCompanyBase == null ? null : serverUnitCompanyBase.trim();
    }

    public String getServerUnitCompanyAirport() {
        return serverUnitCompanyAirport;
    }

    public void setServerUnitCompanyAirport(String serverUnitCompanyAirport) {
        this.serverUnitCompanyAirport = serverUnitCompanyAirport == null ? null : serverUnitCompanyAirport.trim();
    }

    public String getServerUnitCompanyType() {
        return serverUnitCompanyType;
    }

    public void setServerUnitCompanyType(String serverUnitCompanyType) {
        this.serverUnitCompanyType = serverUnitCompanyType == null ? null : serverUnitCompanyType.trim();
    }

    public String getServerUnitCompanyCapital() {
        return serverUnitCompanyCapital;
    }

    public void setServerUnitCompanyCapital(String serverUnitCompanyCapital) {
        this.serverUnitCompanyCapital = serverUnitCompanyCapital == null ? null : serverUnitCompanyCapital.trim();
    }

    public String getServerUnitCompanyLegalRepresentativeName() {
        return serverUnitCompanyLegalRepresentativeName;
    }

    public void setServerUnitCompanyLegalRepresentativeName(String serverUnitCompanyLegalRepresentativeName) {
        this.serverUnitCompanyLegalRepresentativeName = serverUnitCompanyLegalRepresentativeName == null ? null : serverUnitCompanyLegalRepresentativeName.trim();
    }

    public String getServerUnitCompanyLegalRepresentativePhone() {
        return serverUnitCompanyLegalRepresentativePhone;
    }

    public void setServerUnitCompanyLegalRepresentativePhone(String serverUnitCompanyLegalRepresentativePhone) {
        this.serverUnitCompanyLegalRepresentativePhone = serverUnitCompanyLegalRepresentativePhone == null ? null : serverUnitCompanyLegalRepresentativePhone.trim();
    }

    public String getServerUnitCompanyValidityTerm() {
        return serverUnitCompanyValidityTerm;
    }

    public void setServerUnitCompanyValidityTerm(String serverUnitCompanyValidityTerm) {
        this.serverUnitCompanyValidityTerm = serverUnitCompanyValidityTerm == null ? null : serverUnitCompanyValidityTerm.trim();
    }

    public String getServerUnitCompanyScope() {
        return serverUnitCompanyScope;
    }

    public void setServerUnitCompanyScope(String serverUnitCompanyScope) {
        this.serverUnitCompanyScope = serverUnitCompanyScope == null ? null : serverUnitCompanyScope.trim();
    }

    public String getServerUnitCompanyAuditStatus() {
        return serverUnitCompanyAuditStatus;
    }

    public void setServerUnitCompanyAuditStatus(String serverUnitCompanyAuditStatus) {
        this.serverUnitCompanyAuditStatus = serverUnitCompanyAuditStatus == null ? null : serverUnitCompanyAuditStatus.trim();
    }

    public ServerUnitCompany(String serverUnitCompanyName, String serverUnitCompanyBase, String serverUnitCompanyAirport, String serverUnitCompanyType, String serverUnitCompanyCapital, String serverUnitCompanyLegalRepresentativeName, String serverUnitCompanyLegalRepresentativePhone, String serverUnitCompanyValidityTerm, String serverUnitCompanyScope, String serverUnitCompanyAuditStatus) {
        this.serverUnitCompanyName = serverUnitCompanyName;
        this.serverUnitCompanyBase = serverUnitCompanyBase;
        this.serverUnitCompanyAirport = serverUnitCompanyAirport;
        this.serverUnitCompanyType = serverUnitCompanyType;
        this.serverUnitCompanyCapital = serverUnitCompanyCapital;
        this.serverUnitCompanyLegalRepresentativeName = serverUnitCompanyLegalRepresentativeName;
        this.serverUnitCompanyLegalRepresentativePhone = serverUnitCompanyLegalRepresentativePhone;
        this.serverUnitCompanyValidityTerm = serverUnitCompanyValidityTerm;
        this.serverUnitCompanyScope = serverUnitCompanyScope;
        this.serverUnitCompanyAuditStatus = serverUnitCompanyAuditStatus;
    }

    public ServerUnitCompany() {
    }

    @Override
    public String toString() {
        return "ServerUnitCompany{" +
                "serverUnitCompanyId=" + serverUnitCompanyId +
                ", serverUnitCompanyName='" + serverUnitCompanyName + '\'' +
                ", serverUnitCompanyBase='" + serverUnitCompanyBase + '\'' +
                ", serverUnitCompanyAirport='" + serverUnitCompanyAirport + '\'' +
                ", serverUnitCompanyType='" + serverUnitCompanyType + '\'' +
                ", serverUnitCompanyCapital='" + serverUnitCompanyCapital + '\'' +
                ", serverUnitCompanyLegalRepresentativeName='" + serverUnitCompanyLegalRepresentativeName + '\'' +
                ", serverUnitCompanyLegalRepresentativePhone='" + serverUnitCompanyLegalRepresentativePhone + '\'' +
                ", serverUnitCompanyValidityTerm='" + serverUnitCompanyValidityTerm + '\'' +
                ", serverUnitCompanyScope='" + serverUnitCompanyScope + '\'' +
                ", serverUnitCompanyAuditStatus='" + serverUnitCompanyAuditStatus + '\'' +
                '}';
    }

}