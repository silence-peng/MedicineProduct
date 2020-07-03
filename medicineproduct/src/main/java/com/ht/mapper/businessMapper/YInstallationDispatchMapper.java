package com.ht.mapper.businessMapper;

import com.ht.pojo.Staff;
import com.ht.pojo.YDistributeLeafletss;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface YInstallationDispatchMapper {
    List<YDistributeLeafletss> getInstallationDispatch(@Param("page") Integer page, @Param("limit") Integer limit, @Param("sname") String sname, @Param("customerAddress") String customerAddress);

    int getInstallationDispatchs(@Param("sname") String sname, @Param("customerAddress") String customerAddress);

    int deleInstallationDispatchs(Integer[] did);

    List<Staff> getstaff();

    int insert(YDistributeLeafletss YDistributeLeafletss);
    int updaInstallationDispatchs(YDistributeLeafletss YDistributeLeafletss);

}
