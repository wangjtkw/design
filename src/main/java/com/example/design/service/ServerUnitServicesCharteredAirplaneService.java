package com.example.design.service;

import com.example.design.entity.ServerUnitServicesCharteredAirplane;
import com.example.design.mapper.ServerUnitServicesCharteredAirplaneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitServicesCharteredAirplaneService {

    @Autowired
    private ServerUnitServicesCharteredAirplaneMapper charteredAirplaneMapper;

    public int insert(ServerUnitServicesCharteredAirplane charteredAirplane) {
        return charteredAirplaneMapper.insert(charteredAirplane);
    }

}
