package com.ht.service.businessService.impl;

import com.ht.mapper.businessMapper.InstallationRecordMapper;
import com.ht.service.businessService.InstallationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ht.pojo.DistributeLeaflets;

import java.util.List;

@Service
@Transactional
public class InstallationRecordServiceImpl implements InstallationRecordService {
    @Autowired
    private InstallationRecordMapper mapper;

    @Override
    public List<DistributeLeaflets> findByAddress(String therealaddress) {
        return mapper.findByAddress(therealaddress);
    }
}
