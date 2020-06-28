package com.ht.service.businessService.lx;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.mapper.businessMapper.StaffBusinessMapper;
import com.ht.mapper.dataMapper.StaffMapper;
import com.ht.pojo.Role;
import com.ht.pojo.Staff;
import com.ht.pojo.lx.StaffAndRole;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class StaffBusinessService {

    @Autowired
    private StaffBusinessMapper mapper;
    @Autowired
    private StaffMapper staffMapper;
    public PageInfo<StaffAndRole> FindEmployeeConditionQuery(StaffAndRole staffAndRole, Integer PageNum, Integer PageSize) {
        //分页
        PageHelper.startPage(PageNum,PageSize);
        //查询
        return new PageInfo<>(mapper.EmployeeConditionQuery(staffAndRole));
    }


    /**
     * 新增员工
     * @param staff
     * @return
     */
    public Integer AddStaff(Staff staff)
    {
        return staffMapper.insertSelective(staff);
    };


}
