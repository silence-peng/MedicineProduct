package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.CostMapper;
import com.ht.mapper.dataMapper.FaultTypeMapper;
import com.ht.pojo.FaultType;
import com.ht.service.dataService.CostService;
import com.ht.service.dataService.FaultTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaultTypeServiceImpl implements FaultTypeService {
    @Autowired
    private FaultTypeMapper faultTypeMapper;

    @Override
    public List<FaultType> getAll() {
        return faultTypeMapper.selectAll();
    }

    @Override
    public List<FaultType> getData(FaultType faultType) {
        return faultTypeMapper.select(faultType);
    }

    @Override
    public FaultType getOne(FaultType faultType) {
        return faultTypeMapper.selectByPrimaryKey(faultType);
    }

    @Override
    public Integer add(FaultType faultType) {
        return faultTypeMapper.insert(faultType);
    }

    @Override
    public Integer del(FaultType faultType) {
        return faultTypeMapper.delete(faultType);
    }

    @Override
    public Integer upd(FaultType faultType) {
        return faultTypeMapper.updateByPrimaryKeySelective(faultType);
    }
}
