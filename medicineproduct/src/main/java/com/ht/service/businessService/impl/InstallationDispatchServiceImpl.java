package com.ht.service.businessService.impl;

import com.ht.mapper.businessMapper.InstallationDispatchMapper;
import com.ht.pojo.DistributeLeaflets;
import com.ht.service.businessService.InstallationDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InstallationDispatchServiceImpl implements InstallationDispatchService {

    @Autowired
    private InstallationDispatchMapper mapper;
    @Override
    public List<DistributeLeaflets> findByAddress(String therealaddress) {
        return mapper.findByAddress(therealaddress);
    }
}
