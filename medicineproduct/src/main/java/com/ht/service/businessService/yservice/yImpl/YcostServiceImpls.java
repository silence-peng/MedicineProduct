package com.ht.service.businessService.yservice.yImpl;

import com.ht.mapper.businessMapper.YcostMapper;
import com.ht.pojo.Staff;
import com.ht.pojo.Costs;
import com.ht.service.businessService.yservice.YcostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class YcostServiceImpls implements YcostService {
@Autowired
private YcostMapper YcostMapper;
    @Override
    public List<Costs> getCost(Integer limit, Integer page, String sname, String customerAddress,Integer costType) {
        return YcostMapper.getCost(limit, (page - 1) * limit, sname, customerAddress,1);
    }

    @Override
    public int getCostes(String sname, String customerAddress,Integer costType) {
        return YcostMapper.getCostes(sname, customerAddress,1);
    }

    @Override
    public int deleCost(Integer[] costId) {
        return YcostMapper.deleCost(costId);
    }

    @Override
    public List<Staff> getstaff() {
        return YcostMapper.getstaff();
    }

    @Override
    public int insert(Costs Costs) {
        return YcostMapper.insert(Costs);
    }

    @Override
    public int updaCost(Costs Costs) {
        return YcostMapper.updaCost(Costs);
    }
}
