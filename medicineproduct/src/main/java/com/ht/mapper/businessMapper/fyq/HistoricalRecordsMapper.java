package com.ht.mapper.businessMapper.fyq;

import com.ht.pojo.Record;
import com.ht.pojo.ReturnVisit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricalRecordsMapper {

    /**
     * 根据地址和类型查询历史记录
     * @param therealaddress 地址
     * @param type 类型
     * @param sid 员工id
     * @return
     */
    public List<Record> findByAddressAndType(@Param("therealaddress")String therealaddress,@Param("type") Integer type,@Param("sid") Integer sid);

    /**
     * 根据客户名称查询安装记录
     * @param customerName 客户名称
     * @param sid 员工id
     * @return
     */
    public List<ReturnVisit> findByCname(@Param("customerName") String customerName,@Param("sid") Integer sid);
}
