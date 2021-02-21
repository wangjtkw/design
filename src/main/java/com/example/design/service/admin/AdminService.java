package com.example.design.service.admin;

import com.example.design.entity.admin.AdministratorsAccount;
import com.example.design.mapper.admin.AdministratorsAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdministratorsAccountMapper administratorsAccountMapper;

    public AdministratorsAccount getAccount(String account) {
        return administratorsAccountMapper.selectByAccount(account);
    }

}
