package com.ht.mapper.businessMapper;


import com.ht.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    /**
     *
     * @param password 密码
     * @param sid 员工id
     * @return 是否成功
     */
    @Update("update staff set password=#{password} where sid=#{sid}")
    int upstaff(@Param("password") String password,@Param("sid") Integer sid);


}
