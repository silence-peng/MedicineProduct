package com.ht.web.yzj;

import com.ht.pojo.DistributeLeaflets;
import com.ht.pojo.Staff;
import com.ht.pojo.YDistributeLeafletss;
import com.ht.service.businessService.yservice.YInstallationDispatchService;
import com.ht.service.dataService.DistributeLeafletsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/yzj")
public class YInstallationDispatchController {
    @Autowired
    private YInstallationDispatchService YInstallationDispatchService;
    @Autowired
    private DistributeLeafletsService distributeLeafletsService;


    @RequestMapping("getpageINfo")
    @ResponseBody
    public Map<String, Object> getInstallationDispatchtwo(Integer page, Integer limit, String sname, String customerAddress) {
        List<YDistributeLeafletss> YDistributeLeafletss = YInstallationDispatchService.getInstallationDispatch(limit, page, sname, customerAddress);
        int i = YInstallationDispatchService.getInstallationDispatchs(sname, customerAddress);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", i);
        map.put("data", YDistributeLeafletss);
        return map;
    }

    @RequestMapping("deleInstallationDispatchs")
    @ResponseBody
    public String deleInstallationDispatchs(@RequestBody Integer[] ids) {
        int i = YInstallationDispatchService.deleInstallationDispatchs(ids);
        if (i > 0) {
            return "ok";
        }
        return "";
    }

    @RequestMapping("getstaff")
    @ResponseBody
    public List<Staff> getstaff() {
        List<Staff> Staff = YInstallationDispatchService.getstaff();
        return Staff;
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insert(YDistributeLeafletss YDistributeLeafletss) {
        int random = (int) (Math.random() * 3 + 1);
        int random1 = (int) (Math.random() * 3 + 1);
        YDistributeLeafletss.setCid(random);
        YDistributeLeafletss.setOid(random1);
        int i = YInstallationDispatchService.insert(YDistributeLeafletss);
        if (i > 0) {
            return "ok";
        }


        return "";
    }

    @RequestMapping("getid")
    public String getid() {
        return "yModifyInstallation";
    }

    @RequestMapping("getInstallationDispatchse")
    @ResponseBody
    public DistributeLeaflets getInstallationDispatchse(Integer did) {
        DistributeLeaflets distributeLeaflets=new DistributeLeaflets();
        distributeLeaflets.setDid(did);
        DistributeLeaflets DistributeLeafletss = distributeLeafletsService.getOne(distributeLeaflets);
        return DistributeLeafletss;
    }

    @RequestMapping("updaInstallationDispatchs")
    @ResponseBody
    public String updaInstallationDispatchs(YDistributeLeafletss YDistributeLeafletss) {
        int i = YInstallationDispatchService.updaInstallationDispatchs(YDistributeLeafletss);
        if (i > 0) {
            return "ok";
        }
        return "";
    }
}

