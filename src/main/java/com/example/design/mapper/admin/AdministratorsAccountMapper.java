package com.example.design.mapper.admin;

import com.example.design.entity.admin.AdministratorsAccount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministratorsAccountMapper {
    int deleteByPrimaryKey(Integer administratorsAccountId);

    int insert(AdministratorsAccount record);

    AdministratorsAccount selectByPrimaryKey(Integer administratorsAccountId);

    AdministratorsAccount selectByAccount(String account);

    List<AdministratorsAccount> selectAll();

    int updateByPrimaryKey(AdministratorsAccount record);


}