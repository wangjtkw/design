package com.example.design.service;

import com.example.design.entity.ServerUnitServicesParachuteFlight;
import com.example.design.mapper.ServerUnitServicesParachuteFlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitServicesParachuteFlightService {
    @Autowired
    private ServerUnitServicesParachuteFlightMapper parachuteFlightMapper;

    public int insert(ServerUnitServicesParachuteFlight parachuteFlight) {
        return parachuteFlightMapper.insert(parachuteFlight);
    }
}
