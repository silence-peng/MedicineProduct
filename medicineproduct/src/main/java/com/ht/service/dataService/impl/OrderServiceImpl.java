package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.CostMapper;
import com.ht.mapper.dataMapper.OrderMapper;
import com.ht.pojo.Order;
import com.ht.service.dataService.CostService;
import com.ht.service.dataService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getAll() {
        return orderMapper.selectAll();
    }

    @Override
    public List<Order> getData(Order order) {
        return orderMapper.select(order);
    }

    @Override
    public Order getOne(Order order) {
        return orderMapper.selectByPrimaryKey(order);
    }

    @Override
    public Integer add(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public Integer del(Order order) {
        return orderMapper.delete(order);
    }

    @Override
    public Integer upd(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }
}
