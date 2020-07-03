package com.ht.web.yzj;

import com.ht.pojo.Customer;
import com.ht.pojo.ReturnVisit;
import com.ht.pojo.Staff;
import com.ht.pojo.ReturnVisits;
import com.ht.service.businessService.yservice.YreturnVisitService;
import com.ht.service.dataService.CustomerService;
import com.ht.service.dataService.ReturnVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/yzjse")
public class YreturnVisitController {
    @Autowired
    private YreturnVisitService yreturnVisitService;
    @Autowired
    private  ReturnVisitService returnVisitService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("getreturnVisit")
    @ResponseBody
    public Map<String, Object> getInstallationDispatchtwo(Integer page, Integer limit, String sname, String customerName) {
        Integer costType=1;
        List<ReturnVisits> ReturnVisit = yreturnVisitService.getreturnVisit(limit, page, sname, customerName,costType);
        int i = yreturnVisitService.getreturnVisitse(sname, customerName,costType);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", i);
        map.put("data", ReturnVisit);
        return map;
    }

    @RequestMapping("delereturnVisit")
    @ResponseBody
    public String deleInstallationDispatchs(@RequestBody Integer[] ids) {
        int i = yreturnVisitService.deleReturn(ids);
        if (i > 0) {
            return "ok";
        }
        return "";
    }

    @RequestMapping("getstaff")
    @ResponseBody
    public List<Staff> getstaff() {
        List<Staff> Staff = yreturnVisitService.getstaff();
        return Staff;
    }
@RequestMapping("getCustomer")
@ResponseBody
public List<Customer> getCustomer(){
        List<Customer> Customer=customerService.getAll();
        return Customer;
}
    @RequestMapping("insertreturnVisit")
    @ResponseBody
    public String insert(ReturnVisits returnVisits) {
        int random = (int) (Math.random() * 3 + 1);
        int random1 = (int) (Math.random() * 3 + 1);
returnVisits.setRecordId(random);
returnVisits.setWayOfReturnVisit(random1);
        int o=1;
        returnVisits.setReturnVisitPersonnel(returnVisits.getCid());
        returnVisits.setReturnVisitType(o);
        int i = yreturnVisitService.insertReturn(returnVisits);
        if (i > 0) {
            return "ok";
        }


        return "";
    }

    @RequestMapping("getid")
    public String getid() {
        return "YModifyTheFollowupRecord";
    }
    @RequestMapping("getids")
    public String getids() {
        return "YModificationAndMaintenanceReturnVisit";
    }
    @RequestMapping("getidse")
    public String getidse() {
        return "YModificationAndMaintenanceVisits";
    }

    @RequestMapping("getreturnVisitss")
    @ResponseBody
    public ReturnVisit getInstallationDispatchse(Integer rid) {
        ReturnVisit returnVisit=new ReturnVisit();
        returnVisit.setRid(rid);
        ReturnVisit returnVisits = returnVisitService.getOne(returnVisit);
        return returnVisits;
    }

    @RequestMapping("updareturnVisit")
    @ResponseBody
    public String updaInstallationDispatchs(ReturnVisits returnVisits) {
        int i = yreturnVisitService.updaReturn(returnVisits);
        if (i > 0) {
            return "ok";
        }
        return "";
    }
}
