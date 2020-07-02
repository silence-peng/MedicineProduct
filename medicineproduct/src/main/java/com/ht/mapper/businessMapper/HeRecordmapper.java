package com.ht.mapper.businessMapper;

import com.ht.pojo.HjDistributeLeaflets;
import com.ht.pojo.HjRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HeRecordmapper {
    //customer_name是客户姓名  type是类型
    List<HjRecord> getrecord(@Param("customer_name") String customer_name,@Param("type") Integer type,@Param("page")Integer page, @Param("limit")Integer limit);
    Integer getrecords(@Param("customer_name") String customer_name,@Param("type") Integer type);
    //    //删除id
    Integer deletes(@Param("ids")Integer[] ids);
    HjRecord getrecordss(@Param("mid") Integer mid);

}
