package com.example.design.mapper;

import com.example.design.entity.ServerUnitAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerUnitAccountMapper {
    int deleteByPrimaryKey(Integer serverUnitAccountId);

    int insert(ServerUnitAccount record);

    ServerUnitAccount selectByPrimaryKey(Integer serverUnitAccountId);

    List<ServerUnitAccount> selectAll();

    int updateByPrimaryKey(ServerUnitAccount record);

    //检索数据库中是否包含该账号
    ServerUnitAccount selectByAccount(String account);
}