package com.ht.web;

import com.ht.pojo.Staff;
import com.ht.service.dataService.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysController {
    @Autowired
    private StaffService staffService;
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }
    public Object checkLogin(){
        return true;
    }

}
