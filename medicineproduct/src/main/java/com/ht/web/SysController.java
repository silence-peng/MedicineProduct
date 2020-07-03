package com.ht.web;

import com.ht.pojo.Staff;
import com.ht.service.dataService.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SysController {
    @Autowired
    private StaffService staffService;
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){

        return page;
    }
    @RequestMapping("/checkLogin")
    @ResponseBody
    public Object checkLogin(Staff staff, HttpSession session){
        List<Staff> list=staffService.getData(staff);
        if (list.size()==0){
            return false;
        }else {
            session.setAttribute("staff", list.get(0));
        }
        return true;
    }
    @RequestMapping("/loginOut")
    @ResponseBody
    public void loginOut(HttpSession httpSession){
        httpSession.invalidate();
    }
    @RequestMapping("/getLoginInfo")
    @ResponseBody
    public Object getLoginInfo(HttpSession httpSession){
       return httpSession.getAttribute("staff");
    }

}
