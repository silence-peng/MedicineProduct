package com.ht.service.businessService.hejunservice;


import com.ht.pojo.HjRecord;
import com.ht.util.ResultMap;

import java.util.List;

public interface HeRecordservice {
    /**
     * 根据客户查询信息
     * @param customer_name 地址
     * @return
     */
    ResultMap<List<HjRecord>> getrecord(String customer_name, Integer page , Integer limit);

}
