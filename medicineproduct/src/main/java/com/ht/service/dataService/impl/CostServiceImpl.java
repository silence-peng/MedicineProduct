package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.ChinaMapper;

import com.ht.mapper.dataMapper.CostMapper;
import com.ht.pojo.China;
import com.ht.pojo.Cost;
import com.ht.service.dataService.ChinaService;
import com.ht.service.dataService.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostServiceImpl implements CostService {
    @Autowired
    private CostMapper costMapper;

    @Override
    public List<Cost> getAll() {
        return costMapper.selectAll();
    }

    @Override
    public List<Cost> getData(Cost cost) {
        return costMapper.select(cost);
    }

    @Override
    public Cost getOne(Cost cost) {
        return costMapper.selectByPrimaryKey(cost);
    }

    @Override
    public Integer add(Cost cost) {
        return costMapper.insert(cost);
    }

    @Override
    public Integer del(Cost cost) {
        return costMapper.delete(cost);
    }

    @Override
    public Integer upd(Cost cost) {
        return costMapper.updateByPrimaryKeySelective(cost);
    }
}
