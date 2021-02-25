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

    List<ServerUnitServices> selectAllByType(@Param("param")String param,@Param("limit")int limit);

    List<ServerUnitServices> selectByAccountKeyParam(@Param("serverUnitAccountId") Integer serverUnitAccountId, @Param("param") String param);

    List<ServerUnitServices> selectByStatus(String status);

    List<ServerUnitServices> selectByParam(String param);

    List<ServerUnitServices> selectByCompanyId(int companyId);

    List<ServerUnitServices> selectAll();

    int updateByPrimaryKey(ServerUnitServices record);


    int updateByPrimaryKeySelective(ServerUnitServices record);
}