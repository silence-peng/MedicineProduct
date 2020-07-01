package com.ht.service.businessService.fyq;

import com.ht.pojo.ReturnVisit;

import java.util.List;

public interface ReturnVisitRecordService {
    /**
     * 根据客户名称查询安装记录
     * @param customerName 客户名称
     * @return
     */
    public List<ReturnVisit> findByCname(String customerName);
}
