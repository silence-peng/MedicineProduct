package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.RecordMapper;
import com.ht.mapper.dataMapper.SparepartMapper;
import com.ht.pojo.Sparepart;
import com.ht.service.dataService.RecordService;
import com.ht.service.dataService.SparepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SparepartServiceImpl implements SparepartService {
    @Autowired
    private SparepartMapper sparepartMapper;

    @Override
    public List<Sparepart> getAll() {
        return sparepartMapper.selectAll();
    }

    @Override
    public List<Sparepart> getData(Sparepart sparepart) {
        return sparepartMapper.select(sparepart);
    }

    @Override
    public Sparepart getOne(Sparepart sparepart) {
        return sparepartMapper.selectByPrimaryKey(sparepart);
    }

    @Override
    public Integer add(Sparepart sparepart) {
        return sparepartMapper.insert(sparepart);
    }

    @Override
    public Integer del(Sparepart sparepart) {
        return sparepartMapper.delete(sparepart);
    }

    @Override
    public Integer upd(Sparepart sparepart) {
        return sparepartMapper.updateByPrimaryKeySelective(sparepart);
    }
}
