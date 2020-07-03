package com.ht.service.businessService.fyq;

import com.github.pagehelper.PageInfo;
import com.ht.pojo.Record;
import com.ht.pojo.ReturnVisit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HistoricalRecordsService {
    /**
     * 根据地址和类型查询历史记录
     * @param therealaddress 地址
     * @param type 类型
     * @param sid 员工id
     * @return
     */
    public PageInfo<Record> findByAddressAndType(String therealaddress, Integer type, Integer sid,Integer pageNum);

    /**
     * 根据客户名称查询安装记录
     * @param customerName 客户名称
     * @param sid 员工id
     * @return
     */
    public PageInfo<ReturnVisit> findByCname(String customerName,Integer sid,Integer pageNum);

    /**
     * 查询两条历史记录
     * @param sid
     * @return
     */
    public PageInfo<Record> findTop2(Integer sid);
}
