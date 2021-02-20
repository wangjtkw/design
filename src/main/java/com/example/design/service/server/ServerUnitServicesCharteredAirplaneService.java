package com.example.design.service.server;

import com.example.design.entity.server.ServerUnitServicesCharteredAirplane;
import com.example.design.mapper.sever.ServerUnitServicesCharteredAirplaneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitServicesCharteredAirplaneService {

    @Autowired
    private ServerUnitServicesCharteredAirplaneMapper charteredAirplaneMapper;

    public int insert(ServerUnitServicesCharteredAirplane charteredAirplane) {
        return charteredAirplaneMapper.insert(charteredAirplane);
    }

    public ServerUnitServicesCharteredAirplane select(int id) {
        return charteredAirplaneMapper.selectByPrimaryKey(id);
    }

    public void update(ServerUnitServicesCharteredAirplane services) {
        charteredAirplaneMapper.updateByPrimaryKeySelective(services);
    }

    public void delete(int id) {
        charteredAirplaneMapper.deleteByPrimaryKey(id);
    }
}
