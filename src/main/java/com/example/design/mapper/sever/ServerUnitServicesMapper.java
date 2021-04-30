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

    List<ServerUnitServices> selectByAccountKeyType(
            @Param("serverUnitAccountId") Integer serverUnitAccountId,
            @Param("type") String type);


    List<ServerUnitServices> selectAllByType(@Param("param") String param, @Param("limit") int limit);

    List<ServerUnitServices> selectByAccountKeyParam(@Param("serverUnitAccountId") Integer serverUnitAccountId, @Param("param") String param);

    List<ServerUnitServices> selectByAccountKeyParamType(
            @Param("serverUnitAccountId") Integer serverUnitAccountId,
            @Param("type") String type,
            @Param("param") String param);


    List<ServerUnitServices> selectByStatus(String status);

    List<ServerUnitServices> selectByStatusType(
            @Param("status") String status, @Param("type") String type);


    List<ServerUnitServices> selectByParam(String param);

    List<ServerUnitServices> selectByParamType(
            @Param("param") String param,
            @Param("type") String type);


    List<ServerUnitServices> selectByParamUser(String param);


    List<ServerUnitServices> selectByCompanyId(int companyId);

    List<ServerUnitServices> selectAll();

    int updateByPrimaryKey(ServerUnitServices record);


    int updateByPrimaryKeySelective(ServerUnitServices record);
}