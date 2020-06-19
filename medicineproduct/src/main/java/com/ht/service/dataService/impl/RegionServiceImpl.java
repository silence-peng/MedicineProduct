package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.ChinaMapper;
import com.ht.mapper.dataMapper.RegionMapper;
import com.ht.pojo.Region;
import com.ht.service.dataService.ChinaService;
import com.ht.service.dataService.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionMapper regionMapper;
    @Override
    public List<Region> getAll() {
        return regionMapper.selectAll();
    }

    @Override
    public List<Region> getData(Region region) {
        return regionMapper.select(region);
    }

    @Override
    public Region getOne(Region region) {
        return regionMapper.selectByPrimaryKey(region);
    }

    @Override
    public Integer add(Region region) {
        return regionMapper.insert(region);
    }

    @Override
    public Integer del(Region region) {
        return regionMapper.delete(region);
    }

    @Override
    public Integer upd(Region region) {
        return regionMapper.updateByPrimaryKeySelective(region);
    }
}
