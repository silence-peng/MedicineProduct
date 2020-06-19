package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.ProductMapper;
import com.ht.mapper.dataMapper.ReturnVisitMapper;
import com.ht.pojo.ReturnVisit;
import com.ht.service.dataService.ProductService;
import com.ht.service.dataService.ReturnVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnVisitServiceImpl implements ReturnVisitService {
    @Autowired
    private ReturnVisitMapper returnVisitMapper;
    @Override
    public List<ReturnVisit> getAll() {
        return returnVisitMapper.selectAll();
    }

    @Override
    public List<ReturnVisit> getData(ReturnVisit returnVisit) {
        return returnVisitMapper.select(returnVisit);
    }

    @Override
    public ReturnVisit getOne(ReturnVisit returnVisit) {
        return returnVisitMapper.selectByPrimaryKey(returnVisit);
    }

    @Override
    public Integer add(ReturnVisit returnVisit) {
        return returnVisitMapper.insert(returnVisit);
    }

    @Override
    public Integer del(ReturnVisit returnVisit) {
        return returnVisitMapper.delete(returnVisit);
    }

    @Override
    public Integer upd(ReturnVisit returnVisit) {
        return returnVisitMapper.updateByPrimaryKeySelective(returnVisit);
    }
}
