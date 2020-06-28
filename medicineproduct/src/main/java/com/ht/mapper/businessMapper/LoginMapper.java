package com.ht.mapper.businessMapper;


import com.ht.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository("LoginMapper")
public interface LoginMapper{
    /**
     * 登录
     * 根据账号密码登录
     * accountNumber 账号
     * password 密码
     */
    @Select("SELECT * FROM staff WHERE account_number=#{accountNumber} AND  `PASSWORD`=#{password}")
    Staff getstaff(@Param("accountNumber") String accountNumber, @Param("password") String password);
}
