package com.ht.service.businessService;

import com.ht.pojo.DistributeLeaflets;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InstallationRecordService {
    /**
     * 根据地址查询安装记录
     * @param therealaddress 地址
     * @return
     */
    public List<DistributeLeaflets> findByAddress(@Param("therealaddress") String therealaddress);
}
