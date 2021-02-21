package com.example.design.service.server;

import com.example.design.entity.server.ServerUnitServicesHelicopterRental;
import com.example.design.mapper.sever.ServerUnitServicesHelicopterRentalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitServicesHelicopterRentalService {
    @Autowired
    private ServerUnitServicesHelicopterRentalMapper helicopterRentalMapper;

    public int insert(ServerUnitServicesHelicopterRental helicopterRental) {
        return helicopterRentalMapper.insert(helicopterRental);
    }

    public ServerUnitServicesHelicopterRental select(int id) {
        return helicopterRentalMapper.selectByPrimaryKey(id);
    }

    public int update(ServerUnitServicesHelicopterRental services) {
        return helicopterRentalMapper.updateByPrimaryKeySelective(services);
    }

    public void delete(int id) {
        helicopterRentalMapper.deleteByPrimaryKey(id);
    }
}
