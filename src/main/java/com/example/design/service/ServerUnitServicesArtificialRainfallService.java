package com.example.design.service;

import com.example.design.entity.ServerUnitServicesArtificialRainfall;
import com.example.design.mapper.ServerUnitServicesArtificialRainfallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitServicesArtificialRainfallService {
    @Autowired
    private ServerUnitServicesArtificialRainfallMapper artificialRainfallMapper;

    public int insert(ServerUnitServicesArtificialRainfall artificialRainfall) {
        return artificialRainfallMapper.insert(artificialRainfall);
    }

}
