package com.ht.mapper.businessMapper;

import com.github.pagehelper.PageInfo;
import com.ht.pojo.DistributeLeaflets;
import com.ht.pojo.Staff;
import com.ht.pojo.yuzhijie.DistributeLeafletss;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("yinstallationDispatch")
public interface YInstallationDispatch {
    List<DistributeLeafletss> getInstallationDispatch(@Param("sname") String sname, @Param("customerAddress") String customerAddress);

    int deleInstallationDispatchs(@Param("ids") Integer[] ids);
    List<Staff> getstaff();
    int insert(DistributeLeafletss DistributeLeafletss);
}
