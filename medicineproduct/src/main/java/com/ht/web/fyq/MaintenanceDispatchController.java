package com.ht.web.fyq;

import com.ht.pojo.Customer;
import com.ht.pojo.DistributeLeaflets;
import com.ht.service.businessService.InstallationDispatchService;
import com.ht.service.businessService.MaintenanceDispatchService;
import com.ht.service.dataService.CustomerService;
import com.ht.service.dataService.DistributeLeafletsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/mdc")
@Controller
public class MaintenanceDispatchController {
    @Autowired
    private MaintenanceDispatchService service;

    @Autowired
    private DistributeLeafletsService distributeLeafletsService;

    @Autowired
    private CustomerService customerService;


    /**
     * 根据地址查询保养派单信息
     * @return
     */
    @RequestMapping(value = "/findDL",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object findDL(String therealaddress){
        return service.findByAddress(therealaddress);
    }

    /**
     * 根据id查询客户
     * @param customer
     * @return
     */
    @RequestMapping(value = "/findCustomerByID",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object findCustomerByID(Customer customer)
    {
        return customerService.getOne(customer);
    }

    /**
     * 删除
     * @param distributeLeaflets
     * @return
     */
    @RequestMapping(value = "/delDL",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Integer delDL(DistributeLeaflets distributeLeaflets){
        return  distributeLeafletsService.del(distributeLeaflets);
    }

    /**
     * 根据id查询派单信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/findByID",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object findByID(Integer id){
        return service.findByID(id);
    }

    /**
     * 修改
     * @param distributeLeaflets
     * @return
     */
    @RequestMapping(value = "/upd",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Integer upd(DistributeLeaflets distributeLeaflets, Customer customer){
        //修改地址电话等信息 修改成功判断通过
        if(customerService.upd(customer)>0){
            //修改安装派单
            return  distributeLeafletsService.upd(distributeLeaflets);
        }else{
            return 0;
        }
    }
}
