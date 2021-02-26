package com.example.design.mapper.user;

import com.example.design.entity.user.UsersOrders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersOrdersMapper {
    int deleteByPrimaryKey(Integer usersOrdersId);

    int insert(UsersOrders record);

    UsersOrders selectByPrimaryKey(Integer usersOrdersId);

    List<UsersOrders> selectAll();

    int updateByPrimaryKey(UsersOrders record);

    int updateBySelective(UsersOrders orders);
}