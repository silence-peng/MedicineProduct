package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.NationalStandardMapper;
import com.ht.pojo.NationalStandard;
import com.ht.service.dataService.NationalStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalStandardServiceImpl implements NationalStandardService {
    @Autowired
    private NationalStandardMapper nationalStandardMapper;
    @Override
    public List<NationalStandard> getAll() {
        return nationalStandardMapper.selectAll();
    }

    @Override
    public List<NationalStandard> getData(NationalStandard nationalStandard) {
        return nationalStandardMapper.select(nationalStandard);
    }

    @Override
    public NationalStandard getOne(NationalStandard nationalStandard) {
        return nationalStandardMapper.selectByPrimaryKey(nationalStandard);
    }

    @Override
    public Integer add(NationalStandard nationalStandard) {
        return nationalStandardMapper.insert(nationalStandard);
    }

    @Override
    public Integer del(NationalStandard nationalStandard) {
        return nationalStandardMapper.delete(nationalStandard);
    }

    @Override
    public Integer upd(NationalStandard nationalStandard) {
        return nationalStandardMapper.updateByPrimaryKeySelective(nationalStandard);
    }
}
