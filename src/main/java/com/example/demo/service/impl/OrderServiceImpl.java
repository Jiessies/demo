package com.example.demo.service.impl;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huangmingjie on 2018/5/10.
 */
@Service
public class OrderServiceImpl implements OrderService{
    
    @Autowired
    private OrderMapper orderMapper;
    
    @Override
    public String findOrder(String orderNo) {
        return orderMapper.findOrder(orderNo);
    }
}
