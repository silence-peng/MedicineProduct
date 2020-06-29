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

    /**
     *
     * @param sid  员工id
     * @param Type  派单类型
     * @return 派单信息
     */
    public List<DistributeLeafletss> getDistributeleaflets(Integer sid,Integer Type){
        return  sendordersMapper.getDistributeleaflets(sid,Type);
    }

    /**
     *
     * @param did 根据派单id查询下
     * @return 返回改派单详情
     */
//    public DistributeLeafletss getDistributeleafletsparticulars(@Param("did") Integer did){
//        return  sendordersMapper.getDistributeleafletsparticulars(did);
//    }
}
