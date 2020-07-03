package com.ht.web.xc;

import com.ht.pojo.*;
import com.ht.pojo.xc.DistributeLeafletss;
import com.ht.service.dataService.*;
import com.ht.service.businessService.xc.SendordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/send")
@Controller
@CrossOrigin
public class SendordersController {

    @Autowired
    private SendordersService sendordersService;

    @Autowired
    private DistributeLeafletsService distributeLeafletsService;

    @Autowired
    private FaultTypeService faultTypeService;

    @Autowired
    private RecordService recordService;

    /**
     *0
     * @return 派单信息
     */
    @RequestMapping("/getDistributeleaflets")
    @ResponseBody
    public List<DistributeLeafletss> getDistributeleaflets(HttpSession session){
        Integer sid= (Integer) session.getAttribute("sid");
        List<DistributeLeafletss> list=sendordersService.getDistributeleaflets(sid);
        System.out.println(list);
        return list;
    }

    /**
     *
     * @return 返回故障类型
     */
    @RequestMapping("/getfaultType")
    @ResponseBody
    public List<FaultType> getfaultType(){
     List<FaultType> faultType= faultTypeService.getAll();
     System.out.println(faultType);
     return  faultType;
    }

    /**
     *
     * @param record 新增派单记录
     * @return 是否成功
     */
    @RequestMapping("/addRecord")
    @ResponseBody
    public String getfaultType(Record record, MultipartFile[] files)throws IOException {
        System.out.println(files+"**********************1");
        if (files != null) {
            System.out.println(files+"**********************2");
            for (int i=0;i<files.length;i++){
                System.out.println(files+"*******************3");
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
        int addRecord= recordService.add(record);
        if(addRecord>0){
            return "YES";
        }
        return  "NO";
    }
    /**
     * 删除派单信息
     * @return 是否成功
     */
    @RequestMapping("/delDistributeleaflets")
    @ResponseBody
    public String delDistributeleaflets(Integer did){
        int del =  sendordersService.delDistributeLeaflets(did);
        if (del>0){
            return "YES";
        }else {
            return "NO";
        }
    }
}
