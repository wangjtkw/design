package com.example.design.service.server;

import com.example.design.entity.server.ServerUnitServicesArtificialRainfall;
import com.example.design.mapper.sever.ServerUnitServicesArtificialRainfallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitServicesArtificialRainfallService {
    @Autowired
    private ServerUnitServicesArtificialRainfallMapper artificialRainfallMapper;

    public int insert(ServerUnitServicesArtificialRainfall artificialRainfall) {
        return artificialRainfallMapper.insert(artificialRainfall);
    }

    public ServerUnitServicesArtificialRainfall select(int id) {
        return artificialRainfallMapper.selectByPrimaryKey(id);
    }

    public void update(ServerUnitServicesArtificialRainfall services) {
        artificialRainfallMapper.updateByPrimaryKeySelective(services);
    }

    public void delete(int id) {
        artificialRainfallMapper.deleteByPrimaryKey(id);
    }
}
