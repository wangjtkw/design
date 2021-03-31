package com.example.design.service.user;

import com.example.design.entity.user.UsersAccount;
import com.example.design.mapper.user.UsersAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersAccountService {

    @Autowired
    private UsersAccountMapper usersAccountMapper;

    public void insertUsersAccount(UsersAccount account) {
        usersAccountMapper.insert(account);
    }

    public void update(UsersAccount account) {
        usersAccountMapper.updateByPrimaryKeySelective(account);
    }

    public UsersAccount login(String account) {
        return usersAccountMapper.selectByAccount(account);
    }

    public UsersAccount getUsersAccount(int userAccountId) {
        return usersAccountMapper.selectByPrimaryKey(userAccountId);
    }

    public UsersAccount getUserByAccount(String account) {
        return usersAccountMapper.selectByAccount(account);
    }

    public UsersAccount getUserByKey(int accountId) {
        return usersAccountMapper.selectByPrimaryKey(accountId);
    }

    public List<UsersAccount> getAll() {
        return usersAccountMapper.selectAll();
    }

    public void delete(int accountId) {
        usersAccountMapper.deleteByPrimaryKey(accountId);
    }
}
