package com.example.design.mapper;

import com.example.design.entity.ServerUnitServicesAirTour;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerUnitServicesAirTourMapper {
    int deleteByPrimaryKey(Integer serverUnitServicesAirTourId);

    int insert(ServerUnitServicesAirTour record);

    ServerUnitServicesAirTour selectByPrimaryKey(Integer serverUnitServicesAirTourId);

    List<ServerUnitServicesAirTour> selectAll();

    int updateByPrimaryKey(ServerUnitServicesAirTour record);
}