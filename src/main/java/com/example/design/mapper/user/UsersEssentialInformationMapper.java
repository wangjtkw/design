package com.example.design.mapper.user;

import com.example.design.entity.user.UsersEssentialInformation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersEssentialInformationMapper {
    int deleteByPrimaryKey(Integer usersEssentialInformationId);

    int insert(UsersEssentialInformation record);

    UsersEssentialInformation selectByPrimaryKey(Integer usersEssentialInformationId);

    List<UsersEssentialInformation> selectAll();

    int updateByPrimaryKey(UsersEssentialInformation record);
}