package com.ht.service.businessService;

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

    /***
     *用于查询派单信息
     * @param sid 根据操作员id查询
     * @return 返回派单信息
     */
    public List<DistributeLeafletss> getDistributeleaflets(Integer sid){
        return  sendordersMapper.getDistributeleaflets(sid);
    }

    /**
     *
     * @param did 根据派单id查询下
     * @return 返回改派单详情
     */
    public DistributeLeafletss getDistributeleafletsparticulars(@Param("did") Integer did){
        return  sendordersMapper.getDistributeleafletsparticulars(did);
    }
}
