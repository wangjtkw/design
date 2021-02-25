package com.example.design.service.server;

import com.example.design.entity.server.ServerUnitCompany;
import com.example.design.mapper.sever.ServerUnitCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerUnitCompanyService {

    @Autowired
    private ServerUnitCompanyMapper serverUnitCompanyMapper;

    public Integer insert(ServerUnitCompany company) {
        return serverUnitCompanyMapper.insert(company);
    }

    public ServerUnitCompany select(int companyId) {
        return serverUnitCompanyMapper.selectByPrimaryKey(companyId);
    }

    public ServerUnitCompany selectByServerId(int serverId) {
        return serverUnitCompanyMapper.selectByServerId(serverId);
    }

    public List<ServerUnitCompany> selectByStatus(String status) {
        return serverUnitCompanyMapper.selectByStatus(status);
    }

    public List<ServerUnitCompany> selectByParam(String param) {
        return serverUnitCompanyMapper.selectByParam(param);
    }

    public List<ServerUnitCompany> selectAllByParam(String param) {
        return serverUnitCompanyMapper.selectAllByParam(param);
    }

    public List<ServerUnitCompany> selectAll() {
        return serverUnitCompanyMapper.selectAll();
    }

    public void update(ServerUnitCompany company) {
        serverUnitCompanyMapper.updateByPrimaryKeySelective(company);
    }

    public void delete(int companyId) {
        serverUnitCompanyMapper.deleteByPrimaryKey(companyId);
    }

}
