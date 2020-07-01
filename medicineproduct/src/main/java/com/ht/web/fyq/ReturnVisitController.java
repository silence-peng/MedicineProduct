package com.ht.web.fyq;

import com.ht.pojo.Record;
import com.ht.pojo.ReturnVisit;
import com.ht.service.businessService.ReturnVisitRecordService;
import com.ht.service.dataService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/rv")
@Controller
public class ReturnVisitController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private ReturnVisitService returnVisitService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private ReturnVisitRecordService returnVisitRecordService;

    /**
     * 查询所有客户
     * @return
     */
    @RequestMapping(value = "/getCustomer",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object getCustomer(){
        return customerService.getAll();
    }

    /**
     * 查询所有员工
     * @return
     */
    @RequestMapping(value = "/getStaff",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object getStaff(){
        return staffService.getAll();
    }

    /**
     * 新增安装回访
     * @param returnVisit
     * @return
     */
    @RequestMapping(value = "/addRV",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Integer addRV(ReturnVisit returnVisit){
        returnVisit.setReturnVisitType(1);
        return returnVisitService.add(returnVisit);
    }

    /**
     * 修改安装回访
     * @param returnVisit
     * @return
     */
    @RequestMapping(value = "/updRV",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Integer updRV(ReturnVisit returnVisit){
        return returnVisitService.upd(returnVisit);
    }

    /**
     * 查询安装回访
     * @param returnVisit
     * @return
     */
    @RequestMapping(value = "/getRVById",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object getRVById(ReturnVisit returnVisit){
        return returnVisitService.getOne(returnVisit);
    }

    /**
     * 查询安装记录
     * @return
     */
    @RequestMapping(value = "/getRecord",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Record getRecord(Record record){
        return recordService.getOne(record);
    }

    /**
     * 根据客户姓名查询安装记录
     * @param customerName
     * @return
     */
    @RequestMapping(value = "/findRVByName",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object findRVByName(String customerName){
        return returnVisitRecordService.findByCname(customerName);
    }

    /**
     * 根据id删除回访记录
     * @param returnVisit
     * @return
     */
    @RequestMapping(value = "/delRV",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Integer delRV(ReturnVisit returnVisit){
        return  returnVisitService.del(returnVisit);
    }
}
