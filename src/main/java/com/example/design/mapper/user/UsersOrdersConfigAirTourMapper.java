package com.example.design.mapper.user;

import com.example.design.entity.user.UsersOrdersConfigAirTour;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersOrdersConfigAirTourMapper {
    int deleteByPrimaryKey(Integer usersOrdersConfigAirTourId);

    int insert(UsersOrdersConfigAirTour record);

    UsersOrdersConfigAirTour selectByPrimaryKey(Integer usersOrdersConfigAirTourId);

    List<UsersOrdersConfigAirTour> selectAll();

    int updateByPrimaryKey(UsersOrdersConfigAirTour record);
}