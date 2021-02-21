package com.example.design.mapper.sever;

import com.example.design.entity.server.ServerUnitServices;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerUnitServicesMapper {
    int deleteByPrimaryKey(Integer serverUnitServicesId);

    int insert(ServerUnitServices record);

    ServerUnitServices selectByPrimaryKey(Integer serverUnitServicesId);

    List<ServerUnitServices> selectByAccountKey(Integer serverUnitAccountId);

    List<ServerUnitServices> selectAllByType(String param);

    List<ServerUnitServices> selectByAccountKeyParam(@Param("serverUnitAccountId") Integer serverUnitAccountId, @Param("param") String param);

    List<ServerUnitServices> selectAll();

    int updateByPrimaryKey(ServerUnitServices record);


    int updateByPrimaryKeySelective(ServerUnitServices record);
}