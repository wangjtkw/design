package com.example.design.service.user;

import com.example.design.entity.user.UsersEssentialInformation;
import com.example.design.mapper.user.UsersEssentialInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersEssentialInfoService {

    @Autowired
    private UsersEssentialInformationMapper essentialInformationMapper;

    public int insert(UsersEssentialInformation essentialInformation) {
        return essentialInformationMapper.insert(essentialInformation);
    }

}
