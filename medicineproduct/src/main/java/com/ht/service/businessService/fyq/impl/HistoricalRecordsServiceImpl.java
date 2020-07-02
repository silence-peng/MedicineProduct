package com.ht.service.businessService.fyq.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.mapper.businessMapper.fyq.HistoricalRecordsMapper;
import com.ht.pojo.Record;
import com.ht.pojo.ReturnVisit;
import com.ht.service.businessService.fyq.HistoricalRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HistoricalRecordsServiceImpl implements HistoricalRecordsService {
    @Autowired
    private HistoricalRecordsMapper mapper;

    @Override
    public PageInfo<Record> findByAddressAndType(String therealaddress, Integer type, Integer sid,Integer pageNum) {
        PageHelper.startPage(pageNum,15);
        List<Record> list=mapper.findByAddressAndType(therealaddress,type,sid);
        PageInfo<Record> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<ReturnVisit> findByCname(String customerName, Integer sid,Integer pageNum) {
        PageHelper.startPage(pageNum,15);
        List<ReturnVisit> list=mapper.findByCname(customerName,sid);
        PageInfo<ReturnVisit> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
