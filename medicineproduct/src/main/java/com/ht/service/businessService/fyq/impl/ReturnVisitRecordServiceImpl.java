package com.ht.service.businessService.fyq.impl;

import com.ht.mapper.businessMapper.fyq.ReturnVisitRecordMapper;
import com.ht.pojo.ReturnVisit;
import com.ht.service.businessService.fyq.ReturnVisitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReturnVisitRecordServiceImpl implements ReturnVisitRecordService {
    @Autowired
    private ReturnVisitRecordMapper mapper;

    @Override
    public List<ReturnVisit> findByCname(String customerName) {
        return mapper.findByCname(customerName);
    }
}
