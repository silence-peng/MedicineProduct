package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.DepartmentMapper;
import com.ht.pojo.Department;
import com.ht.service.dataService.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> getAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public List<Department> getData(Department department) {
        return departmentMapper.select(department);
    }

    @Override
    public Department getOne(Department department) {
        return departmentMapper.selectByPrimaryKey(department);
    }

    @Override
    public Integer add(Department department) {
        return departmentMapper.insert(department);
    }

    @Override
    public Integer del(Department department) {
        return departmentMapper.delete(department);
    }

    @Override
    public Integer upd(Department department) {
        return departmentMapper.updateByPrimaryKeySelective(department);
    }
}
