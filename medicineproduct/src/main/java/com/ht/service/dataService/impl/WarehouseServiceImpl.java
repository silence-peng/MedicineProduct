package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.RoleMapper;
import com.ht.mapper.dataMapper.WarehouseMapper;
import com.ht.pojo.Warehouse;
import com.ht.service.dataService.RoleService;
import com.ht.service.dataService.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<Warehouse> getAll() {
        return warehouseMapper.selectAll();
    }

    @Override
    public List<Warehouse> getData(Warehouse warehouse) {
        return warehouseMapper.select(warehouse);
    }

    @Override
    public Warehouse getOne(Warehouse warehouse) {
        return warehouseMapper.selectByPrimaryKey(warehouse);
    }

    @Override
    public Integer add(Warehouse warehouse) {
        return warehouseMapper.insert(warehouse);
    }

    @Override
    public Integer del(Warehouse warehouse) {
        return warehouseMapper.delete(warehouse);
    }

    @Override
    public Integer upd(Warehouse warehouse) {
        return warehouseMapper.updateByPrimaryKeySelective(warehouse);
    }
}
