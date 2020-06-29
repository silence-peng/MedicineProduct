package com.ht.web.lx;

import com.github.pagehelper.PageInfo;
import com.ht.pojo.Role;
import com.ht.pojo.Staff;
import com.ht.pojo.lx.StaffAndRole;
import com.ht.service.businessService.lx.StaffBusinessService;
import com.ht.service.dataService.RoleService;
import com.ht.service.dataService.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StaffAndRoleController {
    //自定义sql
    @Autowired
    private StaffBusinessService staffBusinessService;
    //通用mapper
    @Autowired
    private StaffService staffService;
    @Autowired
    private RoleService roleService;
    /**
     * 查询staff按条件查询，分页
     * @return
     */
    @RequestMapping("QueryEmployees")
    @ResponseBody
    public Map<String,Object> QueryEmployees(String sname,String accountNumber,Integer roleid,Integer state, Integer page, Integer limit)
    {
        if(page==null || page==0)
        {
            page=1;
        }
        StaffAndRole staffAndRole=new StaffAndRole();
        staffAndRole.setSname(sname);
        staffAndRole.setAccountNumber(accountNumber);
        staffAndRole.setRole(roleid);
        staffAndRole.setState(state);

        PageInfo<StaffAndRole> rolePageInfo=staffBusinessService.FindEmployeeConditionQuery(staffAndRole,page,limit);
        Map<String,Object> map=new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", rolePageInfo.getTotal());
        map.put("data", rolePageInfo.getList());
        return map;
    };

    /**
     * 查询角色
     * @return
     */
    @RequestMapping("RoleAll")
    @ResponseBody
    public List<Role> RoleAll()
    {
        return roleService.getAll();
    }

    /**
     * 查询要修改的员工表的数据
     * @param sid
     * @return
     */
    @RequestMapping("StaffUpdateAssignment")
    @ResponseBody
    public Staff StaffUpdateAssignment(int sid)
    {
        Staff staff=new Staff();
        staff.setSid(sid);
        return  staffService.getOne(staff);
    };

    /**
     * 跳转到修改页面，传参
     * @param sid
     * @param model
     * @return
     */
    @RequestMapping("GetUpdateEmployees")
    public String GetUpdateEmployees( String sid, Model model)
    {
        model.addAttribute("sid",sid);

        return "UpdateEmployees";
    }


    @RequestMapping("UpdateStaffquery")
    @ResponseBody
    public Staff UpdateStaffquery(Integer sid)
    {
        //实体类
        Staff staff=new Staff();
        //主键
        staff.setSid(sid);
        //查询
      return staffService.getOne(staff);
    };
    /**
     * 修改员工
     * @param staff
     * @return
     */
    @RequestMapping("UpdateStaff")
    @ResponseBody
    public String UpdateStaff(Staff staff)
    {
        //调用修改
        Integer retn=staffService.upd(staff);
        if(retn>=1)
        {
            //修改成功
            return "yes";
        }
        //修改失败
        return  "no";
    };

    /**
     * 新增员工
     * @param staff
     * @return
     */
    @RequestMapping("AddStaff")
    @ResponseBody
    public String AddStaff(Staff staff)
    {
        //状态默认为正常
        staff.setState(1);
        //调用新增
        Integer retn=staffBusinessService.AddStaff(staff);
        if(retn>=1)
        {
            //新增成功
            return "yes";
        }
        //新增失败
        return  "no";
    };

    /**
     * 查询员工账号是否重复
     * @param
     * @return
     */
    @RequestMapping("RepeatedQueryOfAccountNumber")
    @ResponseBody
    public String RepeatedQueryOfAccountNumber(Staff staff)
    {
        //调用查询
        staff=staffService.getOne(staff);
        if(staff==null)
        {
            //不重复
            return "yes";
        }
        //重复
        return  "no";
    };

    /**
     * 删除员工
     * @param staff
     * @return
     */
    @RequestMapping("DelStaff")
    @ResponseBody
    public String DelStaff(Staff staff)
    {

        //调用删除
        Integer retn=staffService.del(staff);
        if(retn>=1)
        {
            //删除成功
            return "yes";
        }
        //删除失败
        return  "no";
    };

    /**
     * 冻结，解冻
     * @param sid
     * @return
     */
    @RequestMapping("FroZen")
    @ResponseBody
    private String FroZen(Integer sid)
    {
        //创建实体类
        Staff staff=new Staff();
        Staff staffrent=new Staff();
        //要修改的员工主键
        staffrent.setSid(sid);

        staff.setSid(sid);

        //判断

        staff=staffService.getOne(staff);
        Integer retn;
        //如果状态为正常，就修改为冻结
        if(staff.getState()==1)
        {
            staffrent.setState(2);
            retn=staffService.upd(staffrent);
            if(retn>=1)
            {
            return "To freeze";
            }
        }
        //如果状态为冻结，就修改为正常
        else if(staff.getState()==2)
        {
            staffrent.setState(1);
            retn=staffService.upd(staffrent);
            if(retn>=1)
            {
                return "To thaw";
            }
        }
        //修改失败
        return  "no";
    };

}
