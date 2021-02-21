package com.example.design.service.server;

import com.example.design.entity.server.ServerUnitServicesAirTour;
import com.example.design.mapper.sever.ServerUnitServicesAirTourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitServicesAirTourService {

    @Autowired
    private ServerUnitServicesAirTourMapper airTourMapper;

    public int insert(ServerUnitServicesAirTour airTour) {
        return airTourMapper.insert(airTour);
    }

    public ServerUnitServicesAirTour select(int id) {
        return airTourMapper.selectByPrimaryKey(id);
    }

    public int update(ServerUnitServicesAirTour services) {
        return airTourMapper.updateByPrimaryKeySelective(services);
    }

    public void delete(int id) {
        airTourMapper.deleteByPrimaryKey(id);
    }


}
