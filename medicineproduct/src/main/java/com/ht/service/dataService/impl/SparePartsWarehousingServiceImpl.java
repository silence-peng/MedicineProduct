package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.SparePartsWarehousingMapper;
import com.ht.mapper.dataMapper.SparepartMapper;
import com.ht.pojo.SparePartsWarehousing;
import com.ht.service.dataService.SparePartsWarehousingService;
import com.ht.service.dataService.SparepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SparePartsWarehousingServiceImpl implements SparePartsWarehousingService {
    @Autowired
    private SparePartsWarehousingMapper sparePartsWarehousingMapper;

    @Override
    public List<SparePartsWarehousing> getAll() {
        return sparePartsWarehousingMapper.selectAll();
    }

    @Override
    public List<SparePartsWarehousing> getData(SparePartsWarehousing sparePartsWarehousing) {
        return sparePartsWarehousingMapper.select(sparePartsWarehousing);
    }

    @Override
    public SparePartsWarehousing getOne(SparePartsWarehousing sparePartsWarehousing) {
        return sparePartsWarehousingMapper.selectByPrimaryKey(sparePartsWarehousing);
    }

    @Override
    public Integer add(SparePartsWarehousing sparePartsWarehousing) {
        return sparePartsWarehousingMapper.insert(sparePartsWarehousing);
    }

    @Override
    public Integer del(SparePartsWarehousing sparePartsWarehousing) {
        return sparePartsWarehousingMapper.delete(sparePartsWarehousing);
    }

    @Override
    public Integer upd(SparePartsWarehousing sparePartsWarehousing) {
        return sparePartsWarehousingMapper.updateByPrimaryKeySelective(sparePartsWarehousing);
    }
}
