package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.FaultTypeMapper;
import com.ht.mapper.dataMapper.OrderDetailMapper;
import com.ht.pojo.OrderDetail;
import com.ht.service.dataService.FaultTypeService;
import com.ht.service.dataService.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetail> getAll() {
        return orderDetailMapper.selectAll();
    }

    @Override
    public List<OrderDetail> getData(OrderDetail orderDetail) {
        return orderDetailMapper.select(orderDetail);
    }

    @Override
    public OrderDetail getOne(OrderDetail orderDetail) {
        return orderDetailMapper.selectByPrimaryKey(orderDetail);
    }

    @Override
    public Integer add(OrderDetail orderDetail) {
        return orderDetailMapper.insert(orderDetail);
    }

    @Override
    public Integer del(OrderDetail orderDetail) {
        return orderDetailMapper.delete(orderDetail);
    }

    @Override
    public Integer upd(OrderDetail orderDetail) {
        return orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }
}
