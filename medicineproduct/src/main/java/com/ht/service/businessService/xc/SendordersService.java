package com.ht.service.businessService.xc;

import com.ht.mapper.businessMapper.SendordersMapper;
import com.ht.pojo.xc.DistributeLeafletss;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendordersService {
    @Autowired
    private SendordersMapper sendordersMapper;

    /**
     *
     * @param sid  员工id
     * @return 派单信息
     */
    public List<DistributeLeafletss> getDistributeleaflets(Integer sid){
        return  sendordersMapper.getDistributeleaflets(sid);
    }

    /**
     *
     * @param did 根据派单id删除派单信息
     * @return 是否成功
     */
    public int delDistributeLeaflets(Integer did){
        return sendordersMapper.delDistributeLeaflets(did);
    }
}
