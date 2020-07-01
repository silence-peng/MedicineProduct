package com.ht.web.fyq;

import com.ht.pojo.Product;
import com.ht.pojo.Record;
import com.ht.service.businessService.fyq.InstallationRecordService;
import com.ht.service.dataService.ProductService;
import com.ht.service.dataService.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/irc")
public class InstallationRecordController {
    @Autowired
    private InstallationRecordService service;

    @Autowired
    private RecordService recordService;

    @Autowired
    private ProductService productService;

    /**
     * 根据地址查询安装记录
     * @param therealaddress
     * @return
     */
    @RequestMapping(value = "/findByAddress",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object findByAddress(String therealaddress){
        return service.findByAddress(therealaddress);
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
     * 根据id删除安装记录
     * @param record
     * @return
     */
    @RequestMapping(value = "/delRecord",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Integer delRecord(Record record){
        return  recordService.del(record);
    }

    /**
     * 新增安装记录
     * @param record
     * @return
     */
    @RequestMapping(value = "/addIRC",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object addIRC(Record record, Product product, MultipartFile files) throws IOException {
       /* if (files != null) {
            System.out.println(files+"*******************");
                if (!files.isEmpty()) {
                    String oldName = files.getOriginalFilename();
                    System.out.println(oldName+"*******************");
                    String suffix = oldName.substring(oldName.lastIndexOf("."));
                    if (!suffix.equals(".jpg") && !suffix.equals(".png") && !suffix.equals(".git") && !suffix.equals(".bmp")) {
                        return "formatError";
                    }
                    String newName = UUID.randomUUID() + suffix;
                    File file1 = new File(ResourceUtils.getURL("classpath:").getPath(), "static/images/");
                    if (!file1.exists()) {
                        file1.createNewFile();
                    }
                    File path = new File(file1, newName);
                    files.transferTo(path);

            }
        }*/
        List<Product> product1= productService.getData(product);
        if(product1.size()==0){
            return "productCodeError";
        }else{
            record.setPid(product1.get(0).getPid());
            return  recordService.add(record);
        }
    }

    /**
     * 修改装记录
     * @param record
     * @return
     */
    @RequestMapping(value = "/updIRC",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object updIRC(Record record, Product product, MultipartFile files) throws IOException {
       /* if (files != null) {
            System.out.println(files+"*******************");
                if (!files.isEmpty()) {
                    String oldName = files.getOriginalFilename();
                    System.out.println(oldName+"*******************");
                    String suffix = oldName.substring(oldName.lastIndexOf("."));
                    if (!suffix.equals(".jpg") && !suffix.equals(".png") && !suffix.equals(".git") && !suffix.equals(".bmp")) {
                        return "formatError";
                    }
                    String newName = UUID.randomUUID() + suffix;
                    File file1 = new File(ResourceUtils.getURL("classpath:").getPath(), "static/images/");
                    if (!file1.exists()) {
                        file1.createNewFile();
                    }
                    File path = new File(file1, newName);
                    files.transferTo(path);

            }
        }*/
        List<Product> product1= productService.getData(product);
        if(product1.size()==0){
            return "productCodeError";
        }else{
            record.setPid(product1.get(0).getPid());
            return  recordService.add(record);
        }
    }
}
