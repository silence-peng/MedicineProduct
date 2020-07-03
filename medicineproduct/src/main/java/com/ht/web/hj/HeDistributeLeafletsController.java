package com.ht.web.hj;




import com.ht.pojo.*;
import com.ht.service.businessService.hejunservice.HeDistributeLeafletsService;
import com.ht.service.dataService.DistributeLeafletsService;
import com.ht.service.dataService.OrderDetailService;
import com.ht.service.dataService.OrderService;
import com.ht.service.dataService.StaffService;
import com.ht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RequestMapping("/hj")
@Controller
public class HeDistributeLeafletsController{
  @Autowired
    private HeDistributeLeafletsService service;

  @Autowired
  private StaffService staffService;

  @Autowired
  private OrderDetailService orderDetailService;

  @Autowired
  private OrderService orderService;

  @Autowired
  private DistributeLeafletsService distributeLeafletsService;
  //根据客户查询保养信息
  @ResponseBody
  @RequestMapping("/getdistributeleaflets")
  public ResultMap<List<HjDistributeLeaflets>> loadSaleInfoTable(Integer page, Integer limit, String name ){
    Integer type=2;
    return  service.getdistributeleaflets(name,type,page,limit);
  }

  @ResponseBody
  @RequestMapping("/getdistributeleafletss")
  public ResultMap<List<HjDistributeLeaflets>> loadSaleInfoTables(Integer page, Integer limit, String name ){
    Integer type=3;
    return  service.getdistributeleaflets(name,type,page,limit);
  }
  //查询员工id
  @ResponseBody
  @RequestMapping("/zhi")
  public List<Staff> zhi(){
   return  staffService.getAll();
  }

    //查询订单id
    @ResponseBody
    @RequestMapping("/zhi1")
    public List<OrderDetail> zhi1(){
        return  orderDetailService.getAll();
    }

  //新增派单
  @ResponseBody
  @RequestMapping("/addpaidan")
  public String addpaidan( DistributeLeaflets  distributeLeaflets,Integer yuangongid,Integer dingdanid,String paidandate,String jiezdate) throws Exception {
    Order orders=new Order();
    orders.setOid(dingdanid);
    Order order = orderService.getOne(orders);
    //客户id
    Integer kehuid = order.getCid();
    distributeLeaflets.setCid(kehuid);
    distributeLeaflets.setSid(yuangongid);
    distributeLeaflets.setOid(dingdanid);
    distributeLeaflets.setType(2);
    distributeLeaflets.setStatus(1);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    distributeLeaflets.setCreateDate(simpleDateFormat.parse(paidandate));
    distributeLeaflets.setEndDate(simpleDateFormat.parse(jiezdate));
    Integer list = distributeLeafletsService.add(distributeLeaflets);
    if (list > 0) {
      return "yes";
    }
    return "no";
  }
  //维修派单
  @ResponseBody
  @RequestMapping("/addweixiupaidan")
  public String addweixiupaidan( DistributeLeaflets  distributeLeaflets,Integer yuangongid,Integer dingdanid,String paidandate,String jiezdate) throws Exception {
    Order orders=new Order();
    orders.setOid(dingdanid);
    Order order = orderService.getOne(orders);
    //客户id
    Integer kehuid = order.getCid();
    distributeLeaflets.setCid(kehuid);
    distributeLeaflets.setSid(yuangongid);
    distributeLeaflets.setOid(dingdanid);
    distributeLeaflets.setType(3);
    distributeLeaflets.setStatus(1);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    distributeLeaflets.setCreateDate(simpleDateFormat.parse(paidandate));
    distributeLeaflets.setEndDate(simpleDateFormat.parse(jiezdate));
    Integer list = distributeLeafletsService.add(distributeLeaflets);
    if (list > 0) {
      return "yes";
    }
    return "no";
  }
  //修改派单
  @ResponseBody
  @RequestMapping("/updatepaidan")
  public String updatepaidan(DistributeLeaflets  distributeLeaflets,Integer yuangongid,Integer dingdanid,String paidandate,String jiezdate,Integer sex) throws Exception {
    Order orders=new Order();
    orders.setOid(dingdanid);
    Order order = orderService.getOne(orders);
    //客户id
    Integer kehuid = order.getCid();
    distributeLeaflets.setCid(kehuid);
    distributeLeaflets.setSid(yuangongid);
    distributeLeaflets.setOid(dingdanid);
    distributeLeaflets.setStatus(sex);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    distributeLeaflets.setCreateDate(simpleDateFormat.parse(paidandate));
    distributeLeaflets.setEndDate(simpleDateFormat.parse(jiezdate));
    Integer list = distributeLeafletsService.upd(distributeLeaflets);
    if (list > 0) {
      return "yes";
    }
    return "no";
  }
  @RequestMapping("/shancu")
  @ResponseBody
  public String shancu(Integer [] ids){
    int shanchu=service.deletes(ids);
    if(shanchu>0){
      return "yes";
    }else {
      return "";
    }
  }
  @RequestMapping("/update")
  public String update(Integer id, Model model){
    DistributeLeaflets distributeLeaflets=new DistributeLeaflets();
    distributeLeaflets.setDid(id);
    DistributeLeaflets list=distributeLeafletsService.getOne(distributeLeaflets);
    model.addAttribute("list",list);
    return "updateMaintainsendsingle";
  }
  @RequestMapping("/updates")
  public String updates(Integer id, Model model){
    DistributeLeaflets distributeLeaflets=new DistributeLeaflets();
    distributeLeaflets.setDid(id);
    DistributeLeaflets list=distributeLeafletsService.getOne(distributeLeaflets);
    model.addAttribute("list",list);
    return "updateSendasinglemaintenance";
  }
}
