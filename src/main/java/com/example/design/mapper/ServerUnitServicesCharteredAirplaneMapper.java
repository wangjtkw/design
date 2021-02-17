package com.example.design.mapper;

import com.example.design.entity.ServerUnitServicesCharteredAirplane;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ServerUnitServicesCharteredAirplaneMapper {
    int deleteByPrimaryKey(Integer serverUnitServicesCharteredAirplaneId);

    int insert(ServerUnitServicesCharteredAirplane record);

    ServerUnitServicesCharteredAirplane selectByPrimaryKey(Integer serverUnitServicesCharteredAirplaneId);

    List<ServerUnitServicesCharteredAirplane> selectAll();

    int updateByPrimaryKey(ServerUnitServicesCharteredAirplane record);
}