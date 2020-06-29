package com.ht.mapper.dataMapper;


import com.ht.pojo.Staff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("StaffMapper")
public interface StaffMapper extends tk.mybatis.mapper.common.Mapper<Staff>{
}
