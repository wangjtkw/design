package com.example.design.mapper.user;

import com.example.design.entity.user.UsersOrdersConfigCharteredAirplane;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersOrdersConfigCharteredAirplaneMapper {
    int deleteByPrimaryKey(Integer usersOrdersConfigCharteredAirplaneId);

    int insert(UsersOrdersConfigCharteredAirplane record);

    UsersOrdersConfigCharteredAirplane selectByPrimaryKey(Integer usersOrdersConfigCharteredAirplaneId);

    List<UsersOrdersConfigCharteredAirplane> selectAll();

    int updateByPrimaryKey(UsersOrdersConfigCharteredAirplane record);
}