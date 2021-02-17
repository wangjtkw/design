package com.example.design.service;

import com.example.design.entity.ServerUnitAccount;
import com.example.design.entity.ServerUnitCompany;
import com.example.design.mapper.ServerUnitAccountMapper;
import com.example.design.mapper.ServerUnitCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitCompanyService {

    @Autowired
    private ServerUnitCompanyMapper serverUnitCompanyMapper;

    public Integer insert(ServerUnitCompany company) {
        return serverUnitCompanyMapper.insert(company);
    }

    public ServerUnitCompany select(int id) {
        return serverUnitCompanyMapper.selectByPrimaryKey(id);
    }

    public void update(ServerUnitCompany company){
        serverUnitCompanyMapper.updateByPrimaryKeySelective(company);
    }

}
