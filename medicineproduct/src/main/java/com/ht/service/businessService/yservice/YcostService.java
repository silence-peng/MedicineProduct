package com.ht.service.businessService.yservice;

import com.ht.pojo.Staff;
import com.ht.pojo.Costs;

import java.util.List;

public interface YcostService {
    List<Costs> getCost(Integer page, Integer limit, String sname, String customerAddress,
                        Integer costType);

    int getCostes(String sname, String customerAddress, Integer costType);

    int deleCost(Integer[] costId);

    List<Staff> getstaff();

    int insert(Costs Costs);
    int updaCost(Costs Costs);
}
