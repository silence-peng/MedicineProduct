package com.ht.web.lx;

import com.github.pagehelper.PageInfo;
import com.ht.pojo.Role;
import com.ht.service.businessService.lx.RoleBusinessService;
import com.ht.service.dataService.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RoleController {
    @Autowired
   private RoleBusinessService roleBusinessService;
    @Autowired
    private RoleService roleService;
    /**
     * 查询role角色按条件模糊查询，分页
     * @param rname
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("QueryRole")
    @ResponseBody
    public Map<String,Object> QueryRole(String rname,Integer page,Integer limit)
    {
        if(page==null || page==0)
        {
            page=1;
        }
        PageInfo<Role> rolePageInfo=roleBusinessService.QueryRole(rname,page,limit);
        Map<String,Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;
    };

    /**
     * 添加角色
     * @param rname
     * @param rstate
     * @return
     */
    @RequestMapping("AddRole")
    @ResponseBody
    public String AddRole(String rname,String rstate)
    {
        //将传过来的值添加到角色实体类中
        Role role=new Role();
        role.setRname(rname);
        role.setRstate(rstate);

        int end=roleBusinessService.AddRole(role);

        if(end>=1)
        {
            return "yes";
        }

        return "no";
    }


    @RequestMapping("updeteRolehtml")
    public String updeteRolehtml(Model model,Integer rid)
    {
        model.addAttribute("rid",rid);

        return "UpdeteYlhtRoleManagement";
    }

    /**
     * 加载修改数据
     * @param rid
     * @return
     */
    @RequestMapping("updeteRoleready")
    @ResponseBody
    public Role updeteRoleready(Integer rid)
    {
        Role role=new Role();
        role.setRid(rid);
        return roleService.getOne(role);
    }
    /**
     * 修改角色
     * @param rname
     * @param rstate
     * @return
     */
    @RequestMapping("UpdeteRole")
    @ResponseBody
    public String UpdeteRole(Integer rid,String rname,String rstate)
    {
        //将传过来的值添加到角色实体类中
        Role role=new Role();
        role.setRid(rid);
        role.setRname(rname);
        role.setRstate(rstate);

        int end=roleBusinessService.UpdeteRole(role);

        if(end>=1)
        {
            return "yes";
        }

        return "no";
    }

    /**
     * 删除角色
     * @param rid
     * @return
     */
    @RequestMapping("DelRole")
    @ResponseBody
    public String DelRole(Integer rid)
    {
        int end=roleBusinessService.DelRole(rid);

        if(end>=1)
        {
            return "yes";
        }

        return "no";
    }

}
