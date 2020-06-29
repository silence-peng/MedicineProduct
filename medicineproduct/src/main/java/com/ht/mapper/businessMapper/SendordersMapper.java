package com.ht.mapper.businessMapper;

import com.ht.pojo.xc.DistributeLeafletss;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository("SendordersMapper")
public interface SendordersMapper {
    /**
     *
     * @param sid  员工id
     * @param Type  派单类型
     * @return 派单信息
     */
    List<DistributeLeafletss> getDistributeleaflets(@Param("sid") Integer sid,@Param("type") Integer Type);

    /**
     *
     * @param did 根据派单id查询下
     * @return 返回改派单详情
     */
//    DistributeLeafletss getDistributeleafletsparticulars(@Param("did") Integer did);
}
