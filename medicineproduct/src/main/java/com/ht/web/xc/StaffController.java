package com.ht.web.xc;

import com.ht.pojo.Staff;
import com.ht.service.businessService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
         session.setAttribute("sname",staff.getSname());
         session.setAttribute("password",staff.getPassword());
         return "YES";
     }
     return "";
    }

    /**
     *
     * @param session 获取员工名字
     * @return 员工名字
     */
    @ResponseBody
    @RequestMapping("/getstafftoto")
    public Map<String,Object>  getstafftoto(HttpSession session){
        String sname= (String) session.getAttribute("sname");
        String phone= (String) session.getAttribute("phone");
        System.out.println(phone);
        Map<String,Object> map=new HashMap<>();
        map.put("sname",sname);
        return map;
    }

    /**
     *
     * @param password 密码
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/upstaff")
    public String upstaff(String password, String passwords, HttpSession session, SessionStatus sessionStatus){
        Integer sid= (Integer) session.getAttribute("sid");
        String passwordss= (String) session.getAttribute("password");
        if(passwords.equals(passwordss)){
            loginService.upstaff(password,sid);
            session.invalidate();
            sessionStatus.setComplete();
            return "YES";
        }else{
            return "NO";
        }
        }
    @ResponseBody
    @RequestMapping("/logout")
    public void upstaff( HttpSession session, SessionStatus sessionStatus){
            session.invalidate();
            sessionStatus.setComplete();
    }
}
