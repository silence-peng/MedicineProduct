package com.ht.web.fyq;

import com.ht.pojo.Customer;
import com.ht.service.dataService.CustomerService;
import com.ht.service.dataService.DistributeLeafletsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/idc")
@Controller
public class InstallationDispatchController {

    @Autowired
    private DistributeLeafletsService distributeLeafletsService;

    @Autowired
    private CustomerService customerService;

    /**
     * 查询所有客户
     * @return
     */
    @RequestMapping(value = "/getCustomer",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object getCustomer(){
        List<Customer> a=customerService.getAll();
        return a;
    }
}
