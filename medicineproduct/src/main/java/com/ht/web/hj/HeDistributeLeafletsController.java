package com.ht.web.hj;




import com.ht.pojo.HjDistributeLeaflets;
import com.ht.pojo.Order;
import com.ht.pojo.SaleInfo;
import com.ht.service.businessService.hejunservice.HeDistributeLeafletsService;
import com.ht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/hj")
@Controller
public class HeDistributeLeafletsController{
  @Autowired
    private HeDistributeLeafletsService service;

  @ResponseBody
  @RequestMapping("/getdistributeleaflets")
  public ResultMap<List<HjDistributeLeaflets>> loadSaleInfoTable(Integer page, Integer limit, String name ){
    return  service.getdistributeleaflets(name,page,limit);
  }
}
