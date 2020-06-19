package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.ChinaMapper;
import com.ht.pojo.China;
import com.ht.service.dataService.ChinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChinaServiceImpl implements ChinaService {
    @Autowired
    private ChinaMapper chinaMapper;
    @Override
    public List<China> getAll() {
        return chinaMapper.selectAll();
    }

    @Override
    public List<China> getData(China china) {
        return chinaMapper.select(china);
    }

    @Override
    public China getOne(China china) {
        return chinaMapper.selectByPrimaryKey(china);
    }

    @Override
    public Integer add(China china) {
        return chinaMapper.insert(china);
    }

    @Override
    public Integer del(China china) {
        return chinaMapper.delete(china);
    }

    @Override
    public Integer upd(China china) {
        return chinaMapper.updateByPrimaryKeySelective(china);
    }
}
