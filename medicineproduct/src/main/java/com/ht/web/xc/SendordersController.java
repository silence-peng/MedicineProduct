package com.ht.web.xc;

import com.ht.pojo.DistributeLeaflets;
import com.ht.pojo.xc.DistributeLeafletss;
import com.ht.service.dataService.DistributeLeafletsService;
import com.ht.service.businessService.SendordersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/send")
@Controller
@CrossOrigin
public class SendordersController {

    @Autowired
    private SendordersService sendordersService;

    @Autowired
    private DistributeLeafletsService distributeLeafletsService;

    /**
     * 查询派单信息
     * @return 派单信息
     */
    @RequestMapping("/getDistributeleaflets")
    @ResponseBody
    public List<DistributeLeafletss> getDistributeleaflets(HttpSession session){
        Integer sid= (Integer) session.getAttribute("sid");
        List<DistributeLeafletss> list=sendordersService.getDistributeleaflets(sid);
        return list;
    }

    /**
     * 删除派单信息
     * @return 是否成功
     */
    @RequestMapping("/delDistributeleaflets")
    @ResponseBody
    public String delDistributeleaflets(DistributeLeaflets distributeLeaflets){
        int del =  distributeLeafletsService.del(distributeLeaflets);
        if (del>0){
            return "YES";
        }else {
            return "NO";
        }
    }

    /**
     * 修改派单信息
     * @return 是否成功
     */
    @RequestMapping("/updDistributeleaflets")
    @ResponseBody
    public String updDistributeleaflets(DistributeLeaflets distributeLeaflets){
     int upd =  distributeLeafletsService.upd(distributeLeaflets);
     if (upd>0){
         return "YES";
     }else {
         return "NO";
     }
    }
    /**
     *
     * @param did 根据派单id查询下
     * @return 返回改派单详情
     */
    @ResponseBody
    @RequestMapping("/getDistributeleafletsparticulars")
     public  DistributeLeafletss getDistributeleafletsparticulars(Integer did){
        DistributeLeafletss  distributeleafletsparticulars=  sendordersService.getDistributeleafletsparticulars(did);
        return  distributeleafletsparticulars;
     }
}
