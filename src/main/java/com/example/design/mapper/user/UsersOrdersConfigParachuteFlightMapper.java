package com.example.design.mapper.user;

import com.example.design.entity.user.UsersOrdersConfigParachuteFlight;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersOrdersConfigParachuteFlightMapper {
    int deleteByPrimaryKey(Integer usersOrdersConfigParachuteFlightId);

    int insert(UsersOrdersConfigParachuteFlight record);

    UsersOrdersConfigParachuteFlight selectByPrimaryKey(Integer usersOrdersConfigParachuteFlightId);

    List<UsersOrdersConfigParachuteFlight> selectAll();

    int updateByPrimaryKey(UsersOrdersConfigParachuteFlight record);
}