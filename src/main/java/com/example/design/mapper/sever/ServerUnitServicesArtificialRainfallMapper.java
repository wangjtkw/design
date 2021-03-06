package com.example.design.mapper.sever;

import com.example.design.entity.server.ServerUnitServicesArtificialRainfall;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerUnitServicesArtificialRainfallMapper {
    int deleteByPrimaryKey(Integer serverUnitServicesArtificialRainfallId);

    int insert(ServerUnitServicesArtificialRainfall record);

    ServerUnitServicesArtificialRainfall selectByPrimaryKey(Integer serverUnitServicesArtificialRainfallId);

    List<ServerUnitServicesArtificialRainfall> selectAll();

    int updateByPrimaryKey(ServerUnitServicesArtificialRainfall record);

    int updateByPrimaryKeySelective(ServerUnitServicesArtificialRainfall record);
}