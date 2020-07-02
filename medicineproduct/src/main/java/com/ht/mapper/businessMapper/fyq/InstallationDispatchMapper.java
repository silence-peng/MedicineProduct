package com.ht.mapper.businessMapper.fyq;

import com.ht.pojo.DistributeLeaflets;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstallationDispatchMapper{
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
