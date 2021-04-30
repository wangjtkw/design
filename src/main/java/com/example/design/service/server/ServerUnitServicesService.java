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

    public List<ServerUnitServices> selectByAccountKeyType(int account, String type) {
        return servicesMapper.selectByAccountKeyType(account, type);
    }

    public List<ServerUnitServices> selectByStatus(String status) {
        return servicesMapper.selectByStatus(status);
    }

    public List<ServerUnitServices> selectByStatusType(String status, String type) {
        return servicesMapper.selectByStatusType(status, type);
    }


    public void delete(int id) {
        servicesMapper.deleteByPrimaryKey(id);
    }

    public List<ServerUnitServices> selectByAccountKeyParam(int account, String param) {
        return servicesMapper.selectByAccountKeyParam(account, param);
    }

    public List<ServerUnitServices> selectByAccountKeyParamType(int account, String type, String param) {
        return servicesMapper.selectByAccountKeyParamType(account, type, param);
    }


    public List<ServerUnitServices> selectByCompanyId(int companyId) {
        return servicesMapper.selectByCompanyId(companyId);
    }

    public List<ServerUnitServices> selectByParam(String param) {
        return servicesMapper.selectByParam(param);
    }

    public List<ServerUnitServices> selectByParamType(String param, String type) {
        return servicesMapper.selectByParamType(param, type);
    }


    public List<ServerUnitServices> selectByParamUser(String param) {
        return servicesMapper.selectByParamUser(param);
    }


    public List<ServerUnitServices> selectByType(String param, int limit) {
        return servicesMapper.selectAllByType(param, limit);
    }

}
