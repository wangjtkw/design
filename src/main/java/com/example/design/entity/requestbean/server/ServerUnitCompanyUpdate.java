package com.example.design.entity.requestbean.server;

public class ServerUnitCompanyUpdate {
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
        this.serverUnitCompanyName = serverUnitCompanyName;
    }

    public String getServerUnitCompanyBase() {
        return serverUnitCompanyBase;
    }

    public void setServerUnitCompanyBase(String serverUnitCompanyBase) {
        this.serverUnitCompanyBase = serverUnitCompanyBase;
    }

    public String getServerUnitCompanyAirport() {
        return serverUnitCompanyAirport;
    }

    public void setServerUnitCompanyAirport(String serverUnitCompanyAirport) {
        this.serverUnitCompanyAirport = serverUnitCompanyAirport;
    }

    public String getServerUnitCompanyType() {
        return serverUnitCompanyType;
    }

    public void setServerUnitCompanyType(String serverUnitCompanyType) {
        this.serverUnitCompanyType = serverUnitCompanyType;
    }

    public String getServerUnitCompanyCapital() {
        return serverUnitCompanyCapital;
    }

    public void setServerUnitCompanyCapital(String serverUnitCompanyCapital) {
        this.serverUnitCompanyCapital = serverUnitCompanyCapital;
    }

    public String getServerUnitCompanyLegalRepresentativeName() {
        return serverUnitCompanyLegalRepresentativeName;
    }

    public void setServerUnitCompanyLegalRepresentativeName(String serverUnitCompanyLegalRepresentativeName) {
        this.serverUnitCompanyLegalRepresentativeName = serverUnitCompanyLegalRepresentativeName;
    }

    public String getServerUnitCompanyLegalRepresentativePhone() {
        return serverUnitCompanyLegalRepresentativePhone;
    }

    public void setServerUnitCompanyLegalRepresentativePhone(String serverUnitCompanyLegalRepresentativePhone) {
        this.serverUnitCompanyLegalRepresentativePhone = serverUnitCompanyLegalRepresentativePhone;
    }

    public String getServerUnitCompanyValidityTerm() {
        return serverUnitCompanyValidityTerm;
    }

    public void setServerUnitCompanyValidityTerm(String serverUnitCompanyValidityTerm) {
        this.serverUnitCompanyValidityTerm = serverUnitCompanyValidityTerm;
    }

    public String getServerUnitCompanyScope() {
        return serverUnitCompanyScope;
    }

    public void setServerUnitCompanyScope(String serverUnitCompanyScope) {
        this.serverUnitCompanyScope = serverUnitCompanyScope;
    }

    @Override
    public String toString() {
        return "ServerUnitUpdate{" +
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
                '}';
    }
}
