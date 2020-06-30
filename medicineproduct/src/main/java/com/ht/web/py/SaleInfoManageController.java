package com.ht.web.py;

import com.ht.pojo.Order;
import com.ht.pojo.OrderDetail;
import com.ht.pojo.Product;
import com.ht.pojo.SaleInfo;
import com.ht.service.businessService.py.SaleInfoManageService;
import com.ht.service.dataService.CustomerService;
import com.ht.service.dataService.ProductService;
import com.ht.service.dataService.StaffService;
import com.ht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SaleInfoManageController {
    @Autowired
    private SaleInfoManageService saleInfoManageService;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private StaffService staffService;
    @PostMapping("base/upload")
    public Object upload(@RequestParam("file") MultipartFile file) throws IOException {
        int code=0;
        String msg="";
        List list=null;
        if (file.isEmpty()) {
            msg= "上传失败，请选择文件";
        }else{
           list=saleInfoManageService.readFile(file);
        }
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", list);
        return map;
    }
    @RequestMapping("/loadSaleInfoTable")
    public ResultMap<List<SaleInfo>> loadSaleInfoTable(Integer page, Integer limit, String startDate, String endDate, Order order){
        return  saleInfoManageService.getSaleInfo(page, limit);
    }
    @RequestMapping("/loadCustomerInfo")
    public Object loadCustomerInfo(){
        return  customerService.getAll();
    }
    @RequestMapping("/loadStaffInfo")
    public Object loadStaffInfo(){
        return  staffService.getAll();
    }
    @RequestMapping("/getSaleInfoById")
    public SaleInfo getSaleInfoById(Integer id){
        return  saleInfoManageService.getSaleInfoById(id);
    }
    @RequestMapping("/loadProductInfo")
    public ResultMap<List<Product>> loadProductInfo(Integer page, Integer limit){
        return  saleInfoManageService.HandleProductInfo(page, limit);
    }
    @RequestMapping("/updOrder")
//    :id,
    public boolean updSaleInfo(@RequestParam("salesVolumes") Integer salesVolumes,
                               @RequestParam("totalSalesPrice") Float totalSalesPrice,
                               @RequestParam("salesman") Integer salesman,
                               @RequestParam("cid") Integer cid,
                               @RequestParam("oid") Integer oid,
                               @RequestParam("odid") List<Integer> odid,
                               @RequestParam("pid") List<Integer> pid,
                               @RequestParam("salePrices") List<Float> salePrices){
        Order order=new Order();
        order.setOid(oid);
        order.setSalesman(salesman);
        order.setTotalSalesPrice(totalSalesPrice);
        order.setSalesVolumes(salesVolumes);
        order.setCid(cid);
        return saleInfoManageService.updOrder(order, odid, salePrices,pid);
    }

}
