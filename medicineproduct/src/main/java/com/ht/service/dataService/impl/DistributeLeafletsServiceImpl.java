package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.DistributeLeafletsMapper;
import com.ht.pojo.DistributeLeaflets;
import com.ht.pojo.ReturnVisit;
import com.ht.service.dataService.DistributeLeafletsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributeLeafletsServiceImpl implements DistributeLeafletsService {
    @Autowired
    private DistributeLeafletsMapper distributeLeafletsMapper;
    @Override
    public List<DistributeLeaflets> getAll() {
        return distributeLeafletsMapper.selectAll();
    }

    @Override
    public List<DistributeLeaflets> getData(DistributeLeaflets distributeLeaflets) {
        return distributeLeafletsMapper.select(distributeLeaflets);
    }

    @Override
    public DistributeLeaflets getOne(DistributeLeaflets distributeLeaflets) {
        return distributeLeafletsMapper.selectByPrimaryKey(distributeLeaflets);
    }

    @Override
    public Integer add(DistributeLeaflets distributeLeaflets) {
        return distributeLeafletsMapper.insert(distributeLeaflets);
    }

    @Override
    public Integer del(DistributeLeaflets distributeLeaflets) {
        return distributeLeafletsMapper.delete(distributeLeaflets);
    }

    @Override
    public Integer upd(DistributeLeaflets distributeLeaflets) {
        return distributeLeafletsMapper.updateByPrimaryKeySelective(distributeLeaflets);
    }
}
