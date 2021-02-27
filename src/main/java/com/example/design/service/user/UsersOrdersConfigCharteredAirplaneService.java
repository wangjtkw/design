package com.example.design.service.user;

import com.example.design.entity.user.UsersOrdersConfigCharteredAirplane;
import com.example.design.mapper.user.UsersOrdersConfigCharteredAirplaneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersOrdersConfigCharteredAirplaneService {
    @Autowired
    private UsersOrdersConfigCharteredAirplaneMapper mapper;

    public void insert(UsersOrdersConfigCharteredAirplane airplane) {
        mapper.insert(airplane);
    }

    public UsersOrdersConfigCharteredAirplane selectById(int id){
        return mapper.selectByPrimaryKey(id);
    }

    public int delete(int id) {
        return mapper.deleteByPrimaryKey(id);
    }
}
