package com.ht.service.businessService.impl;

import com.ht.mapper.businessMapper.MaintenanceDispatchMapper;
import com.ht.pojo.DistributeLeaflets;
import com.ht.service.businessService.MaintenanceDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaintenanceDispatchServiceImpl implements MaintenanceDispatchService {

    @Autowired
    private MaintenanceDispatchMapper mapper;

    @Override
    public List<DistributeLeaflets> findByAddress(String therealaddress) {
        return mapper.findByAddress(therealaddress);
    }

    @Override
    public DistributeLeaflets findByID(Integer id) {
        return mapper.findByID(id);
    }
}
