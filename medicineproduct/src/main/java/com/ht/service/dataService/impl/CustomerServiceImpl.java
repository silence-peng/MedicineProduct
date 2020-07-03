package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.CustomerMapper;
import com.ht.pojo.Customer;
import com.ht.pojo.ReturnVisit;
import com.ht.service.dataService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<Customer> getAll() {
        return customerMapper.selectAll();
    }

    @Override
    public List<Customer> getData(Customer customer) {
        return customerMapper.select(customer);
    }

    @Override
    public Customer getOne(Customer customer) {
        return customerMapper.selectByPrimaryKey(customer);
    }

    @Override
    public Integer add(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public Integer del(Customer customer) {
        return customerMapper.delete(customer);
    }

    @Override
    public Integer upd(Customer customer) {
        return customerMapper.updateByPrimaryKeySelective(customer);
    }
}
