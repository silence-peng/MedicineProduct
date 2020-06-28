package com.ht.service.dataService.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.mapper.dataMapper.RegionMapper;
import com.ht.mapper.dataMapper.StaffMapper;
import com.ht.pojo.Staff;
import com.ht.service.dataService.RegionService;
import com.ht.service.dataService.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffMapper staffMapper;
    @Override
    public List<Staff> getAll() {
        return staffMapper.selectAll();
    }

    @Override
    public List<Staff> getData(Staff staff) {
        return staffMapper.select(staff);
    }

    @Override
    public Staff getOne(Staff staff) {
        return staffMapper.selectByPrimaryKey(staff);
    }

    @Override
    public Integer add(Staff staff) {
        return staffMapper.insert(staff);
    }

    @Override
    public Integer del(Staff staff) {
        return staffMapper.delete(staff);
    }

    @Override
    public Integer upd(Staff staff) {
        return staffMapper.updateByPrimaryKeySelective(staff);
    }

}
