package com.ht.service.businessService.lx;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.mapper.dataMapper.RoleMapper;
import com.ht.pojo.Role;
import com.ht.service.dataService.RoleService;
import com.ht.util.DataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class RoleBusinessService  {
    @Autowired
    public RoleMapper roleMapper;
    @Autowired
    public RoleService roleService;



    public PageInfo<Role> QueryRole(String rname, Integer PageNum, Integer PageSize) {
        //分页
        PageHelper.startPage(PageNum,PageSize);
        //条件查询过滤
        Example example=new Example(Role.class);

        if(StringUtils.isNotBlank(rname))
        {
            //条件
            example.createCriteria().orLike("rname","%"+rname.toLowerCase()+"%");
        }

        List<Role> roles=roleMapper.selectByExample(example);

        return new PageInfo<>(roles);
    }


    public Integer AddRole(Role role) {
        return roleMapper.insertSelective(role);
    }


    public Integer UpdeteRole(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }


    public Integer DelRole(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }
}
