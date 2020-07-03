package com.ht.mapper.businessMapper.fyq;

import com.ht.pojo.ReturnVisit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnVisitRecordMapper {
    /**
     * 根据客户名称查询安装记录
     * @param customerName 客户名称
     * @return
     */
    public List<ReturnVisit> findByCname(@Param("customerName") String customerName);

}
