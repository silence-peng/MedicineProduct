package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.SparepartTypeMapper;
import com.ht.pojo.ReturnVisit;
import com.ht.pojo.SparepartType;
import com.ht.service.dataService.SparepartTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SparepartTypeServiceImpl implements SparepartTypeService {
    @Autowired
    private SparepartTypeMapper sparepartTypeMapper;

    @Override
    public List<SparepartType> getAll() {
        return sparepartTypeMapper.selectAll();
    }

    @Override
    public List<SparepartType> getData(SparepartType sparepartType) {
        return sparepartTypeMapper.select(sparepartType);
    }

    @Override
    public SparepartType getOne(SparepartType sparepartType) {
        return sparepartTypeMapper.selectByPrimaryKey(sparepartType);
    }

    @Override
    public Integer add(SparepartType sparepartType) {
        return sparepartTypeMapper.insert(sparepartType);
    }

    @Override
    public Integer del(SparepartType sparepartType) {
        return sparepartTypeMapper.delete(sparepartType);
    }

    @Override
    public Integer upd(SparepartType sparepartType) {
        return sparepartTypeMapper.updateByPrimaryKeySelective(sparepartType);
    }
}
