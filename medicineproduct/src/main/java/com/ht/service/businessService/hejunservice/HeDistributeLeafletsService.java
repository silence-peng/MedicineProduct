package com.ht.service.businessService.hejunservice;



import com.ht.pojo.HjDistributeLeaflets;
import com.ht.util.ResultMap;


import java.util.List;

public interface HeDistributeLeafletsService {
    /**
     * 根据客户查询信息
     * @param customer_name 地址
     * @return
     */
    ResultMap<List<HjDistributeLeaflets>> getdistributeleaflets(String customer_name, Integer page , Integer limit);

}
