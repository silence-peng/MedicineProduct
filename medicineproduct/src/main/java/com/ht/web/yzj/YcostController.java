package com.ht.web.yzj;

import com.ht.pojo.Cost;
import com.ht.pojo.Staff;
import com.ht.pojo.Costs;
import com.ht.service.businessService.yservice.YcostService;
import com.ht.service.dataService.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/yzjs")
public class YcostController {
    @Autowired
    private CostService costService;
    @Autowired
    private YcostService ycostService;
    @RequestMapping("getCoset")
    @ResponseBody
    public Map<String, Object> getInstallationDispatchtwo(Integer page, Integer limit, String sname, String customerAddress) {
        Integer costType=1;
        List<Costs> DistributeLeafletss = ycostService.getCost(limit, page, sname, customerAddress,costType);
        int i = ycostService.getCostes(sname, customerAddress,costType);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", i);
        map.put("data", DistributeLeafletss);
        return map;
    }

    @RequestMapping("deleCost")
    @ResponseBody
    public String deleInstallationDispatchs(@RequestBody Integer[] ids) {
        int i = ycostService.deleCost(ids);
        if (i > 0) {
            return "ok";
        }
        return "";
    }

    @RequestMapping("getstaff")
    @ResponseBody
    public List<Staff> getstaff() {
        List<Staff> Staff = ycostService.getstaff();
        return Staff;
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insert(Costs costs) {
        int random = (int) (Math.random() * 3 + 1);
        int random1 = (int) (Math.random() * 3 + 1);
        costs.setCid(random);
        costs.setOid(random1);
        int o=1;
        costs.setEnteredBy(costs.getSid());
        costs.setCostType(o);
        int i = ycostService.insert(costs);
        if (i > 0) {
            return "ok";
        }


        return "";
    }

    @RequestMapping("getid")
    public String getid() {
        return "yModifyInstallationCost";
    }
    @RequestMapping("getids")
    public String getids() {
        return "YModifyMaintenanceFee";
    }
    @RequestMapping("getidse")
    public String getidse() {
        return "YModifyMaintenanceCost";
    }

    @RequestMapping("getCosetss")
    @ResponseBody
    public Cost getInstallationDispatchse(Integer costId) {
        Cost cost=new Cost();
        cost.setCostId(costId);
        Cost Cost = costService.getOne(cost);
        return Cost;
    }

    @RequestMapping("updaCosett")
    @ResponseBody
    public String updaInstallationDispatchs(Costs costs) {
        int i = ycostService.updaCost(costs);
        if (i > 0) {
            return "ok";
        }
        return "";
    }
}
