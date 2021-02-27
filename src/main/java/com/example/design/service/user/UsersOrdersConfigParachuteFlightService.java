package com.example.design.service.user;

import com.example.design.entity.user.UsersOrdersConfigParachuteFlight;
import com.example.design.mapper.user.UsersOrdersConfigParachuteFlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersOrdersConfigParachuteFlightService {
    @Autowired
    private UsersOrdersConfigParachuteFlightMapper mapper;

    public void insert(UsersOrdersConfigParachuteFlight parachuteFlight) {
        mapper.insert(parachuteFlight);
    }

    public UsersOrdersConfigParachuteFlight selectById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int delete(int id) {
        return mapper.deleteByPrimaryKey(id);
    }
}
