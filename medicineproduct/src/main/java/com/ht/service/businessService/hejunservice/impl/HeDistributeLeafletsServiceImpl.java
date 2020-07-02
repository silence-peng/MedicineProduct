package com.ht.service.businessService.hejunservice.impl;


import com.ht.mapper.businessMapper.HeDistributeLeafletsmapper;

import com.ht.pojo.HjDistributeLeaflets;
import com.ht.service.businessService.hejunservice.HeDistributeLeafletsService;
import com.ht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class HeDistributeLeafletsServiceImpl implements HeDistributeLeafletsService {
    @Autowired
    private HeDistributeLeafletsmapper heDistributeLeafletsmapper;

    @Override
    public ResultMap<List<HjDistributeLeaflets>> getdistributeleaflets(String customer_name, Integer type,Integer page, Integer limit) {
        List<HjDistributeLeaflets> list=heDistributeLeafletsmapper.getdistributeleaflets(customer_name,type, (page-1)*limit, limit);
        Integer count=heDistributeLeafletsmapper.getdistributeleafletss(customer_name,type);
        String msg="";
        int code=0;
        return new ResultMap<>(msg, list, code, count);
    }

    @Override
    public int deletes(Integer[] ids) {
        return heDistributeLeafletsmapper.deletes(ids);
    }
}
