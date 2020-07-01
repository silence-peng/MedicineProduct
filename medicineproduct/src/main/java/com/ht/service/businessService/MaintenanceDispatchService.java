package com.ht.service.businessService;

import com.ht.pojo.DistributeLeaflets;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaintenanceDispatchService {

    /**
     * 根据地址保养安装派单
     * @param therealaddress 地址
     * @return
     */
    public List<DistributeLeaflets> findByAddress(@Param("therealaddress") String therealaddress);

    /**
     * 根据id查询保养派单
     * @param id
     * @return
     */
    public DistributeLeaflets findByID(@Param("id") Integer id);
}
