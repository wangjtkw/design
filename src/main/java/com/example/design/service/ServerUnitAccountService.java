package com.example.design.service;

import com.example.design.entity.ServerUnitAccount;
import com.example.design.mapper.ServerUnitAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitAccountService {

    @Autowired
    private ServerUnitAccountMapper serverUnitAccountMapper;

    public ServerUnitAccount getServerUnitAccountByAccount(String account) {
        return serverUnitAccountMapper.selectByAccount(account);
    }

    public int insert(ServerUnitAccount account) {
        return serverUnitAccountMapper.insert(account);
    }

    public void update(ServerUnitAccount account) {
        serverUnitAccountMapper.updateByPrimaryKey(account);
    }

}
