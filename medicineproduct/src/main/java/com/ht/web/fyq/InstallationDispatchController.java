package com.ht.web.fyq;

import com.ht.pojo.Customer;
import com.ht.service.businessService.InstallationDispatchService;
import com.ht.service.dataService.CustomerService;
import com.ht.service.dataService.DistributeLeafletsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/idc")
@Controller
public class InstallationDispatchController {

    @Autowired
    private InstallationDispatchService service;


    /**
     * 查询安装派单信息
     * @return
     */
    @RequestMapping(value = "/findDL",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object findDL(String therealaddress){
       return service.findByAddress(therealaddress);
    }
}
