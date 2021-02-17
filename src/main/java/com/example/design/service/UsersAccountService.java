package com.example.design.service;

import com.example.design.entity.UsersAccount;
import com.example.design.mapper.UsersAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersAccountService{

    @Autowired
    private UsersAccountMapper usersAccountMapper;


    public UsersAccount getUsersAccount(int id) {
        return usersAccountMapper.selectByPrimaryKey(id);
    }
}
