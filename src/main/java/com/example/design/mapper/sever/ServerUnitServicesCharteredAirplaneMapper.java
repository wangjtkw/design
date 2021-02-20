package com.example.design.mapper.sever;

import com.example.design.entity.server.ServerUnitServicesCharteredAirplane;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerUnitServicesCharteredAirplaneMapper {
    int deleteByPrimaryKey(Integer serverUnitServicesCharteredAirplaneId);

    int insert(ServerUnitServicesCharteredAirplane record);

    ServerUnitServicesCharteredAirplane selectByPrimaryKey(Integer serverUnitServicesCharteredAirplaneId);

    List<ServerUnitServicesCharteredAirplane> selectAll();

    int updateByPrimaryKey(ServerUnitServicesCharteredAirplane record);

    int updateByPrimaryKeySelective(ServerUnitServicesCharteredAirplane record);

}