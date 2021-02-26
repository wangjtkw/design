package com.example.design.service.user;

import com.example.design.entity.user.UsersOrdersConfigAirTour;
import com.example.design.mapper.user.UsersOrdersConfigAirTourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersOrdersConfigAirTourService {
    @Autowired
    private UsersOrdersConfigAirTourMapper mapper;

    public void insert(UsersOrdersConfigAirTour airTour) {
        mapper.insert(airTour);
    }

}
