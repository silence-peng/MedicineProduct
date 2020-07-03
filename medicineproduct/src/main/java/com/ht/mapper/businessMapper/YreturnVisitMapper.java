package com.ht.mapper.businessMapper;

import com.ht.pojo.Staff;
import com.ht.pojo.ReturnVisits;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YreturnVisitMapper {
    List<ReturnVisits> getreturnVisit(@Param("page") Integer page, @Param("limit") Integer limit, @Param("sname") String sname, @Param("customerName") String customerName,
                                      @Param("returnVisitType") Integer returnVisitType);

    int getreturnVisitse(@Param("sname") String sname, @Param("customerName") String customerName, @Param("returnVisitType") Integer returnVisitType);

    int deleReturn(Integer[] rid);

    List<Staff> getstaff();

    int insertReturn(ReturnVisits ReturnVisits);
    int updaReturn(ReturnVisits ReturnVisits);
}
