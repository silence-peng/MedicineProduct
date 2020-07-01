package com.ht.mapper.businessMapper;

import com.ht.pojo.HjDistributeLeaflets;
import com.ht.pojo.HjRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HeRecordmapper {
    //customer_name是客户姓名
    List<HjRecord> getrecord(@Param("customer_name") String customer_name, @Param("page")Integer page, @Param("limit")Integer limit);
    Integer getrecords(@Param("customer_name") String customer_name);

}
