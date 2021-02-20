package com.example.design.mapper.sever;

import com.example.design.entity.server.ServerUnitServicesParachuteFlight;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerUnitServicesParachuteFlightMapper {
    int deleteByPrimaryKey(Integer serverUnitServicesParachuteFlightId);

    int insert(ServerUnitServicesParachuteFlight record);

    ServerUnitServicesParachuteFlight selectByPrimaryKey(Integer serverUnitServicesParachuteFlightId);

    List<ServerUnitServicesParachuteFlight> selectAll();

    int updateByPrimaryKey(ServerUnitServicesParachuteFlight record);

    int updateByPrimaryKeySelective(ServerUnitServicesParachuteFlight record);

}