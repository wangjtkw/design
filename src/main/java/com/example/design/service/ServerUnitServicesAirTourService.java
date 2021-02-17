package com.example.design.service;

import com.example.design.entity.ServerUnitServicesAirTour;
import com.example.design.mapper.ServerUnitServicesAirTourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitServicesAirTourService {

    @Autowired
    private ServerUnitServicesAirTourMapper airTourMapper;

    public int insert(ServerUnitServicesAirTour airTour) {
        return airTourMapper.insert(airTour);
    }
}
