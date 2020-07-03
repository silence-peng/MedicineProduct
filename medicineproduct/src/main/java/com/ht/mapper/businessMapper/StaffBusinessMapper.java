package com.ht.mapper.businessMapper;

import com.ht.pojo.lx.StaffAndRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("StaffbusinessMapper")
public interface StaffBusinessMapper {
    /**
     * 连表查询员工，连接角色表
     * @param staffAndRole
     * @return
     */
    List<StaffAndRole> EmployeeConditionQuery(StaffAndRole staffAndRole);

}
