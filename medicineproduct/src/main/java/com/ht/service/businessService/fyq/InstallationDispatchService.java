package com.ht.service.businessService.fyq;

import com.ht.pojo.DistributeLeaflets;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InstallationDispatchService {
    /**
     * 根据地址查询安装派单
     * @param therealaddress 地址
     * @return
     */
    public List<DistributeLeaflets> findByAddress(@Param("therealaddress") String therealaddress);

    /**
     * 根据id查询安装派单
     * @param id
     * @return
     */
    public DistributeLeaflets findByID(@Param("id") Integer id);
}