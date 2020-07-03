package com.ht.mapper.businessMapper;

import com.ht.pojo.Staff;
import com.ht.pojo.Costs;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface YcostMapper {
    List<Costs> getCost(@Param("page") Integer page, @Param("limit") Integer limit, @Param("sname") String sname, @Param("customerAddress") String customerAddress,
                        @Param("costType") Integer costType);

    int getCostes(@Param("sname") String sname, @Param("customerAddress") String customerAddress, @Param("costType") Integer costType);

    int deleCost(Integer[] costId);

    List<Staff> getstaff();

    int insert(Costs Costs);
    int updaCost(Costs Costs);
}
