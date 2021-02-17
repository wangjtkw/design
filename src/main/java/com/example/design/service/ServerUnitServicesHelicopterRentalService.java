package com.example.design.service;

import com.example.design.entity.ServerUnitServicesHelicopterRental;
import com.example.design.mapper.ServerUnitServicesHelicopterRentalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitServicesHelicopterRentalService {
    @Autowired
    private ServerUnitServicesHelicopterRentalMapper helicopterRentalMapper;

    public int insert(ServerUnitServicesHelicopterRental helicopterRental) {
        return helicopterRentalMapper.insert(helicopterRental);
    }
}
