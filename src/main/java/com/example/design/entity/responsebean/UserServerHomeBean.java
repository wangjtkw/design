package com.example.design.entity.responsebean;

import java.util.List;

public class UserServerHomeBean {
    //空中游览
    private List<UserServerTypeItemBean> airTour;
    //包机飞行
    private List<UserServerTypeItemBean> charteredAirplane;
    //跳伞飞行
    private List<UserServerTypeItemBean> parachuteFlight;
    //人工增雨
    private List<UserServerTypeItemBean> artificialRainfall;
    //直升机出租
    private List<UserServerTypeItemBean> helicopterRental;

    public UserServerHomeBean(List<UserServerTypeItemBean> airTour, List<UserServerTypeItemBean> charteredAirplane, List<UserServerTypeItemBean> parachuteFlight, List<UserServerTypeItemBean> artificialRainfall, List<UserServerTypeItemBean> helicopterRental) {
        this.airTour = airTour;
        this.charteredAirplane = charteredAirplane;
        this.parachuteFlight = parachuteFlight;
        this.artificialRainfall = artificialRainfall;
        this.helicopterRental = helicopterRental;
    }

    public List<UserServerTypeItemBean> getAirTour() {
        return airTour;
    }

    public void setAirTour(List<UserServerTypeItemBean> airTour) {
        this.airTour = airTour;
    }

    public List<UserServerTypeItemBean> getCharteredAirplane() {
        return charteredAirplane;
    }

    public void setCharteredAirplane(List<UserServerTypeItemBean> charteredAirplane) {
        this.charteredAirplane = charteredAirplane;
    }

    public List<UserServerTypeItemBean> getParachuteFlight() {
        return parachuteFlight;
    }

    public void setParachuteFlight(List<UserServerTypeItemBean> parachuteFlight) {
        this.parachuteFlight = parachuteFlight;
    }

    public List<UserServerTypeItemBean> getArtificialRainfall() {
        return artificialRainfall;
    }

    public void setArtificialRainfall(List<UserServerTypeItemBean> artificialRainfall) {
        this.artificialRainfall = artificialRainfall;
    }

    public List<UserServerTypeItemBean> getHelicopterRental() {
        return helicopterRental;
    }

    public void setHelicopterRental(List<UserServerTypeItemBean> helicopterRental) {
        this.helicopterRental = helicopterRental;
    }
}
