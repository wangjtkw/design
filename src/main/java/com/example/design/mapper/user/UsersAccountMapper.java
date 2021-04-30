package com.example.design.mapper.user;

import com.example.design.entity.user.UsersAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersAccountMapper {
    int deleteByPrimaryKey(Integer usersAccountId);

    int insert(UsersAccount record);

    UsersAccount selectByPrimaryKey(Integer usersAccountId);

    UsersAccount selectByAccount(String account);

    List<UsersAccount> selectAll();

    List<UsersAccount> selectAllByParam(String param);

    int updateByPrimaryKey(UsersAccount record);

    int updateByPrimaryKeySelective(UsersAccount record);
}