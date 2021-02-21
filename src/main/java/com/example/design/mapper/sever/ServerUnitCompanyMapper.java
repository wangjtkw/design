package com.example.design.mapper.sever;

import com.example.design.entity.server.ServerUnitCompany;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerUnitCompanyMapper {
    int deleteByPrimaryKey(Integer serverUnitCompanyId);

    int insert(ServerUnitCompany record);

    ServerUnitCompany selectByPrimaryKey(Integer serverUnitCompanyId);

    List<ServerUnitCompany> selectAll();

    int updateByPrimaryKey(ServerUnitCompany record);

    int updateByPrimaryKeySelective(ServerUnitCompany record);

    ServerUnitCompany selectByServerId(Integer serverId);

}