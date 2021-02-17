package com.example.design.service;

import com.example.design.entity.ServerUnitServices;
import com.example.design.mapper.ServerUnitServicesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitServicesService {

    @Autowired
    private ServerUnitServicesMapper servicesMapper;

    public int insert(ServerUnitServices services) {
        return servicesMapper.insert(services);
    }

    public void update(ServerUnitServices services) {
        servicesMapper.updateByPrimaryKeySelective(services);
    }
}
