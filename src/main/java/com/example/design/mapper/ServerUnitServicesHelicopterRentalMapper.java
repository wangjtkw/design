package com.example.design.mapper;

import com.example.design.entity.ServerUnitServicesHelicopterRental;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ServerUnitServicesHelicopterRentalMapper {
    int deleteByPrimaryKey(Integer serverUnitServicesHelicopterRentalId);

    int insert(ServerUnitServicesHelicopterRental record);

    ServerUnitServicesHelicopterRental selectByPrimaryKey(Integer serverUnitServicesHelicopterRentalId);

    List<ServerUnitServicesHelicopterRental> selectAll();

    int updateByPrimaryKey(ServerUnitServicesHelicopterRental record);
}