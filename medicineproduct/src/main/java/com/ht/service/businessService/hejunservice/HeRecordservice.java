package com.ht.service.businessService.hejunservice;


import com.ht.pojo.HjRecord;
import com.ht.util.ResultMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HeRecordservice {
    /**
     * 根据客户查询信息
     * @param customer_name 地址
     * @return
     */
    ResultMap<List<HjRecord>> getrecord(String customer_name, Integer type, Integer page , Integer limit);
    /**
     * 批量删除
     * @param
     * @return
     */
    Integer deletes(Integer[] ids);
    /**
     * 修改查询
     * @param mid 记录id
     * @return
     */
    HjRecord getrecordss(Integer mid);
}
