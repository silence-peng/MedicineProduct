package com.ht.service.businessService.yservice;

import com.ht.pojo.Staff;
import com.ht.pojo.YDistributeLeafletss;

import java.util.List;

public interface YInstallationDispatchService {
    List<YDistributeLeafletss> getInstallationDispatch(Integer limit, Integer page, String sname, String customerAddress);

    int getInstallationDispatchs(String sname, String customerAddress);

    int deleInstallationDispatchs(Integer[] did);

    List<Staff> getstaff();

    int insert(YDistributeLeafletss YDistributeLeafletss);
    int updaInstallationDispatchs(YDistributeLeafletss YDistributeLeafletss);

}
