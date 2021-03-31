package com.example.design.service.user;

import com.example.design.entity.user.UsersOrders;
import com.example.design.mapper.user.UsersOrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<UsersOrders> selectByAccountId(Integer accountId) {
        return mapper.selectByAccountId(accountId);
    }

    public List<UsersOrders> selectByServerUnitAccount(Integer serverAccountId) {
        return mapper.selectByServerUnitAccount(serverAccountId);
    }

    public List<UsersOrders> selectByAccountParam(int accountId, String param) {
        return mapper.selectByAccountParam(accountId, param);
    }

    public List<UsersOrders> selectByServerUnitAccountParam(int serverAccountId, String param) {
        return mapper.selectByServerUnitAccountParam(serverAccountId, param);
    }

    public int updateBySelective(UsersOrders orders) {
        return mapper.updateBySelective(orders);
    }

    public int delete(int orderId) {
        return mapper.deleteByPrimaryKey(orderId);
    }
}
