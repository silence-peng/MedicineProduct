package com.ht.web.xc;

import com.ht.pojo.Staff;
import com.ht.service.businessService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping("/staff")
@Controller
@CrossOrigin
public class StaffController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     * 根据账号密码登录
     * accountNumber 账号
     * password 密码
     */

    @ResponseBody
    @RequestMapping("/getstaff")
    public String getstaff(String accountnumber, String password, HttpSession session){
        Staff staff=loginService.getstaff(accountnumber,password);
     if (staff==null){
         return "NO";
     }else if(staff!=null){
         session.setAttribute("sid",staff.getSid());
         return "YES";
     }
     return "";
    }
}
