package com.example.design.service.server;

import com.example.design.entity.server.ServerUnitServicesParachuteFlight;
import com.example.design.mapper.sever.ServerUnitServicesParachuteFlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitServicesParachuteFlightService {
    @Autowired
    private ServerUnitServicesParachuteFlightMapper parachuteFlightMapper;

    public int insert(ServerUnitServicesParachuteFlight parachuteFlight) {
        return parachuteFlightMapper.insert(parachuteFlight);
    }

    public ServerUnitServicesParachuteFlight select(int id) {
        return parachuteFlightMapper.selectByPrimaryKey(id);
    }

    public void update(ServerUnitServicesParachuteFlight services) {
        parachuteFlightMapper.updateByPrimaryKeySelective(services);
    }

    public void delete(int id) {
        parachuteFlightMapper.deleteByPrimaryKey(id);
    }
}
