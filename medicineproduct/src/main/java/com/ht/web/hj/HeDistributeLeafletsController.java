package com.ht.web.hj;




import com.ht.pojo.HjDistributeLeaflets;
import com.ht.pojo.Staff;
import com.ht.service.businessService.hejunservice.HeDistributeLeafletsService;
import com.ht.service.dataService.StaffService;
import com.ht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/hj")
@Controller
public class HeDistributeLeafletsController{
  @Autowired
    private HeDistributeLeafletsService service;

  @Autowired
  private StaffService staffService;

  //根据客户查询保养信息
  @ResponseBody
  @RequestMapping("/getdistributeleaflets")
  public ResultMap<List<HjDistributeLeaflets>> loadSaleInfoTable(Integer page, Integer limit, String name ){
    return  service.getdistributeleaflets(name,page,limit);
  }


  //查询员工id
  @ResponseBody
  @RequestMapping("/zhi")
  public List<Staff> zhi(){
   return  staffService.getAll();
  }
}
