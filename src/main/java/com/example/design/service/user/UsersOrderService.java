package com.example.design.service.user;

import com.example.design.entity.user.UsersOrders;
import com.example.design.mapper.user.UsersOrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersOrderService {
    @Autowired
    private UsersOrdersMapper mapper;

    public void insert(UsersOrders orders) {
        mapper.insert(orders);
    }

    public UsersOrders selectById(int orderId) {
        return mapper.selectByPrimaryKey(orderId);
    }

    public int updateBySelective(UsersOrders orders) {
        return mapper.updateBySelective(orders);
    }
}
