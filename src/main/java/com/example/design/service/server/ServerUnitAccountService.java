package com.example.design.service.server;

import com.example.design.entity.server.ServerUnitAccount;
import com.example.design.mapper.sever.ServerUnitAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerUnitAccountService {

    @Autowired
    private ServerUnitAccountMapper serverUnitAccountMapper;

    public ServerUnitAccount getServerUnitAccountByAccount(String account) {
        return serverUnitAccountMapper.selectByAccount(account);
    }

    public ServerUnitAccount selectByCompanyId(int companyId) {
        return serverUnitAccountMapper.selectByCompanyId(companyId);
    }

    public ServerUnitAccount selectByKey(int serverUnitId) {
        return serverUnitAccountMapper.selectByPrimaryKey(serverUnitId);
    }

    public void delete(int accountId) {
        serverUnitAccountMapper.deleteByPrimaryKey(accountId);
    }


    public int insert(ServerUnitAccount account) {
        return serverUnitAccountMapper.insert(account);
    }

    public void update(ServerUnitAccount account) {
        serverUnitAccountMapper.updateByPrimaryKey(account);
    }

}
