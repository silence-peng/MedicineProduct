package com.ht.mapper.businessMapper;

import com.ht.pojo.SaleInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("saleInfoMapper")
public interface SaleInfoMapper {
    List<SaleInfo> getSaleInfo(@Param("page")Integer page,@Param("limit")Integer limit);
    Integer getSaleInfoCount();
    SaleInfo getSaleInfoById(Integer id);
}
