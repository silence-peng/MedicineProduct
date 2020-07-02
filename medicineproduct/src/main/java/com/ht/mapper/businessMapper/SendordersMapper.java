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
     * @param sid 根据操作员id
     * @return
     */
    List<DistributeLeafletss> getDistributeleaflets(@Param("sid") Integer sid);

    /**
     *
     * @param did 根据派单id删除派单信息
     * @return 是否成功
     */
    int delDistributeLeaflets(@Param("did") Integer did);
}
