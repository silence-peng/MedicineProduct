package com.ht.web.py;

import com.ht.pojo.Order;
import com.ht.pojo.SaleInfo;
import com.ht.service.businessService.SaleInfoManageService;
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
}
