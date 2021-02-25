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

    public List<ServerUnitServices> selectByStatus(String status) {
        return servicesMapper.selectByStatus(status);
    }

    public void delete(int id) {
        servicesMapper.deleteByPrimaryKey(id);
    }

    public List<ServerUnitServices> selectByAccountKeyParam(int account, String param) {
        return servicesMapper.selectByAccountKeyParam(account, param);
    }

    public List<ServerUnitServices> selectByCompanyId(int companyId) {
        return servicesMapper.selectByCompanyId(companyId);
    }

    public List<ServerUnitServices> selectByParam(String param) {
        return servicesMapper.selectByParam(param);
    }


    public List<ServerUnitServices> selectByType(String param,int limit) {
        return servicesMapper.selectAllByType(param,limit);
    }

}
