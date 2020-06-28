package com.ht.service.businessService;




import com.ht.mapper.businessMapper.LoginMapper;
import com.ht.mapper.dataMapper.StaffMapper;
import com.ht.pojo.Staff;
import com.ht.util.DataService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 登录
     * 根据账号密码登录
     * accountNumber 账号
     * password 密码
     */
    public Staff getstaff(String accountnumber, String password){
     return  loginMapper.getstaff(accountnumber,password);
    }

}
