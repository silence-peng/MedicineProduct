package com.ht.service.businessService.hejunservice.impl;

import com.ht.mapper.businessMapper.HeRecordmapper;
import com.ht.pojo.HjDistributeLeaflets;
import com.ht.pojo.HjRecord;
import com.ht.service.businessService.hejunservice.HeRecordservice;
import com.ht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class HeRecordserviceImpl implements HeRecordservice {
    @Autowired
    private HeRecordmapper heRecordmapper;

    @Override
    public ResultMap<List<HjRecord>> getrecord(String customer_name, Integer page, Integer limit) {
        List<HjRecord> list=heRecordmapper.getrecord(customer_name, (page-1)*limit, limit);
        Integer count=heRecordmapper.getrecords(customer_name);
        String msg="";
        int code=0;
        return new ResultMap<>(msg, list, code, count);
    }
}
