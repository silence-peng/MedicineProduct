package com.ht.web.fyq;

import com.ht.pojo.Product;
import com.ht.pojo.Record;
import com.ht.pojo.ReturnVisit;
import com.ht.service.businessService.fyq.HistoricalRecordsService;
import com.ht.service.dataService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/hrc")
@Controller
public class HistoricalRecordsController {

    @Autowired
    private HistoricalRecordsService service;

    @Autowired
    private RecordService recordService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private ReturnVisitService returnVisitService;

    @Autowired
    private FaultTypeService faultTypeService;


    /**
     * 根据地址和类型查询安装记录
     * @param therealaddress 地址
     * @param type 类型
     * @return
     */
    @RequestMapping(value = "/findByAddressAndType",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object findByAddressAndType(String therealaddress,Integer type,Integer pageNum){
        if(pageNum==null || pageNum<1){
            pageNum=1;
        }
        return service.findByAddressAndType(therealaddress,type,1,pageNum);
    }

    /**
     * 根据客户姓名查询
     * @param customerName 地址
     * @param pageNum 页码
     * @return
     */
    @RequestMapping(value = "/findRVByCname",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object findRVByCname(String customerName,Integer pageNum){
        if(pageNum==null || pageNum<1){
            pageNum=1;
        }
        return service.findByCname(customerName,1,pageNum);
    }

    /**
     * 根据ID查询安装记录
     * @param record
     * @return
     */
    @RequestMapping(value = "/findById",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object findById(Record record){

        return recordService.getOne(record);
    }

    /**
     * 根据ID查询产品信息
     * @param product
     * @return
     */
    @RequestMapping(value = "/findByProductId",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object findByProductId(Product product){

        return productService.getOne(product);
    }

    /**
     * 查询所有客户
     * @return
     */
    @RequestMapping(value = "/getCustomer",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object getCustomer(){
        return customerService.getAll();
    }

    /**
     * 查询故障类型
     * @return
     */
    @RequestMapping(value = "/getFaultType",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object getFaultType(){
        return faultTypeService.getAll();
    }

    /**
     * 查询所有员工
     * @return
     */
    @RequestMapping(value = "/getStaff",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object getStaff(){
        return staffService.getAll();
    }

    /**
     * 修改历史记录
     * @param record
     * @return
     */
    @RequestMapping(value = "/updIRC",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object updIRC(Record record, Product product, MultipartFile[] files) throws IOException {
        if (files != null) {
            for (int i=0;i<files.length;i++){
                if (!files[i].isEmpty()) {
                    String oldName = files[i].getOriginalFilename();
                    String suffix = oldName.substring(oldName.lastIndexOf("."));
                    if (!suffix.equals(".jpg") && !suffix.equals(".png") && !suffix.equals(".git") && !suffix.equals(".bmp")) {
                        return "ImgError";
                    }
                    String newName = UUID.randomUUID() + suffix;
                    File file1 = new File(ResourceUtils.getURL("classpath:").getPath(), "static/images/");
                    if (!file1.exists()) {
                        file1.createNewFile();
                    }
                    File path = new File(file1, newName);
                    files[i].transferTo(path);
                   if(i==0){
                       record.setPrePhotos(newName);
                   }else{
                       record.setSufPhotos(newName);
                   }
                }
            }
        }
        List<Product> product1= productService.getData(product);
        if(product1.size()==0){
            return "productCodeError";
        }else{
            record.setPid(product1.get(0).getPid());
            return  recordService.upd(record);
        }
    }

    /**
     * 查询安装回访
     * @param returnVisit
     * @return
     */
    @RequestMapping(value = "/getRVById",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object getRVById(ReturnVisit returnVisit){
        return returnVisitService.getOne(returnVisit);
    }

    /**
     * 修改安装回访
     * @param returnVisit
     * @return
     */
    @RequestMapping(value = "/updRV",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Integer updRV(ReturnVisit returnVisit){
        return returnVisitService.upd(returnVisit);
    }
}
