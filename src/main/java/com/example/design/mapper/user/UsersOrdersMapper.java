package com.example.design.mapper.user;

import com.example.design.entity.user.UsersOrders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersOrdersMapper {
    int deleteByPrimaryKey(Integer usersOrdersId);

    int insert(UsersOrders record);

    UsersOrders selectByPrimaryKey(Integer usersOrdersId);

    List<UsersOrders> selectByAccountId(Integer accountId);

    List<UsersOrders> selectByServerUnitAccount(Integer serverAccountId);

    List<UsersOrders> selectByAccountParam(@Param("accountId") int accountId, @Param("param") String params);

    List<UsersOrders> selectByServerUnitAccountParam(@Param("serverAccountId") int serverAccountId, @Param("param") String params);
    
    List<UsersOrders> selectAll();

    int updateByPrimaryKey(UsersOrders record);

    int updateBySelective(UsersOrders orders);
}