package com.example.design.mapper;

import com.example.design.entity.ServerUnitServices;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ServerUnitServicesMapper {
    int deleteByPrimaryKey(Integer serverUnitServicesId);

    int insert(ServerUnitServices record);

    ServerUnitServices selectByPrimaryKey(Integer serverUnitServicesId);

    List<ServerUnitServices> selectAll();

    int updateByPrimaryKey(ServerUnitServices record);

    int updateByPrimaryKeySelective(ServerUnitServices record);
}