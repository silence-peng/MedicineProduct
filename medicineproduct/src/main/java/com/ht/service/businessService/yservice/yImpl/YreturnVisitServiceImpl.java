package com.ht.service.businessService.yservice.yImpl;

import com.ht.mapper.businessMapper.YreturnVisitMapper;
import com.ht.pojo.Staff;
import com.ht.pojo.ReturnVisits;
import com.ht.service.businessService.yservice.YreturnVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YreturnVisitServiceImpl implements YreturnVisitService {
    @Autowired
    private YreturnVisitMapper yreturnVisitMapper;
    @Override
    public List<ReturnVisits> getreturnVisit(Integer page, Integer limit, String sname, String customerName, Integer returnVisitType) {
        return yreturnVisitMapper.getreturnVisit(page,(limit-1)*page,sname,customerName,returnVisitType);
    }

    @Override
    public int getreturnVisitse(String sname, String customerName, Integer costType) {
        return yreturnVisitMapper.getreturnVisitse(sname,customerName,costType);
    }

    @Override
    public int deleReturn(Integer[] rid) {
        return yreturnVisitMapper.deleReturn(rid);
    }

    @Override
    public List<Staff> getstaff() {
        return yreturnVisitMapper.getstaff();
    }

    @Override
    public int insertReturn(ReturnVisits ReturnVisits) {
        return yreturnVisitMapper.insertReturn(ReturnVisits);
    }

    @Override
    public int updaReturn(ReturnVisits ReturnVisits) {
        return yreturnVisitMapper.updaReturn(ReturnVisits);
    }


}
