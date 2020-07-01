package com.ht.mapper.businessMapper;

import com.ht.pojo.HjDistributeLeaflets;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface HeDistributeLeafletsmapper {
    //customer_name是客户姓名
    List<HjDistributeLeaflets> getdistributeleaflets(@Param("customer_name") String customer_name,@Param("page")Integer page,@Param("limit")Integer limit);
    Integer getdistributeleafletss(@Param("customer_name") String customer_name);
    int deletes(@Param("ids")Integer [] ids);
}
