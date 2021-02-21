package com.example.design.service.server;

import com.example.design.entity.server.ServerUnitServices;
import com.example.design.mapper.sever.ServerUnitServicesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerUnitServicesService {

    @Autowired
    private ServerUnitServicesMapper servicesMapper;

    public int insert(ServerUnitServices services) {
        return servicesMapper.insert(services);
    }

    public int update(ServerUnitServices services) {
        return servicesMapper.updateByPrimaryKeySelective(services);
    }

    public ServerUnitServices select(int serverId) {
        return servicesMapper.selectByPrimaryKey(serverId);
    }

    public List<ServerUnitServices> selectByAccountKey(int account) {
        return servicesMapper.selectByAccountKey(account);
    }

    public void delete(int id) {
        servicesMapper.deleteByPrimaryKey(id);
    }

    public List<ServerUnitServices> selectByAccountKeyParam(int account, String param) {
        return servicesMapper.selectByAccountKeyParam(account, param);
    }

    public List<ServerUnitServices> selectByType(String param) {
        return servicesMapper.selectAllByType(param);
    }

}
