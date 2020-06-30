package com.ht.web.hj;

import com.ht.pojo.HjRecord;
import com.ht.service.businessService.hejunservice.HeRecordservice;
import com.ht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/hj")
@Controller
public class HeRecordController {
    @Autowired
    private HeRecordservice heRecordservice;
    //根据客户查询保养记录
    @ResponseBody
    @RequestMapping("/getRecord")
    public ResultMap<List<HjRecord>> loadSaleInfoTable(Integer page, Integer limit, String name ){
        return  heRecordservice.getrecord(name,page,limit);
    }
}
