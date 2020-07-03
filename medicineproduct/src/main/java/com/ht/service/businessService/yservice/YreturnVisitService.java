package com.ht.service.businessService.yservice;

import com.ht.pojo.Staff;
import com.ht.pojo.ReturnVisits;

import java.util.List;

public interface YreturnVisitService {
    List<ReturnVisits> getreturnVisit(Integer page, Integer limit, String sname, String customerName,
                                      Integer returnVisitType);
    int getreturnVisitse(String sname, String customerName, Integer returnVisitType);
    int deleReturn(Integer[] rid);
    List<Staff> getstaff();
    int insertReturn(ReturnVisits ReturnVisits);
    int updaReturn(ReturnVisits ReturnVisits);
}
