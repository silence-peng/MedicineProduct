package com.ht.web.hj;

import com.ht.pojo.HjRecord;
import com.ht.pojo.Record;
import com.ht.service.businessService.hejunservice.HeRecordservice;
import com.ht.service.dataService.RecordService;
import com.ht.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/hj")
@Controller
public class HeRecordController {
    @Autowired
    private HeRecordservice heRecordservice;
    @Autowired
    private RecordService recordService;
    //根据客户查询保养记录
    @ResponseBody
    @RequestMapping("/getRecord")
    public ResultMap<List<HjRecord>> loadSaleInfoTable(Integer page,Integer limit, String name ){
        Integer type=2;
        return  heRecordservice.getrecord(name,type,page,limit);
    }
    @ResponseBody
    @RequestMapping("/getRecords")
    public ResultMap<List<HjRecord>> getRecords(Integer page,Integer limit, String name ){
        Integer type=1;
        return  heRecordservice.getrecord(name,type,page,limit);
    }
    @ResponseBody
    @RequestMapping("/getRecordss")
    public ResultMap<List<HjRecord>> getRecordss(Integer page,Integer limit, String name ){
        Integer type=3;
        return  heRecordservice.getrecord(name,type,page,limit);
    }
    @RequestMapping("/updateMaintenanceevaluations")
    public String updateMaintenanceevaluations(Integer id, Model model){
        model.addAttribute("id",id);
        return "Maintenanceevaluation";
    }
    @RequestMapping("/addTheinstallationrecordss")
    public String addTheinstallationrecordss(Integer id, Model model){
        model.addAttribute("id",id);
        return "addTheinstallationrecords";
    }
    @RequestMapping("/addserviceactionlo")
    public String addserviceactionlo(Integer id, Model model){
        model.addAttribute("id",id);
        return "addserviceactionlog";
    }

    @ResponseBody
    @RequestMapping("/updaterecord")
    public String updaterecord(Record record){
        Integer a=recordService.upd(record);
        if(a>0){
            return "yes";
        }
        return "no";
    }
    @ResponseBody
    @RequestMapping("/Maintenancee")
    public HjRecord Maintenancee(Integer id){
        HjRecord list=heRecordservice.getrecordss(id);
        return list;
    }
    @RequestMapping("/shancubaoyangjilu")
    @ResponseBody
    public String shancubaoyangjilu(Integer [] ids){
        //ids删除的id值
        Integer shanchu=heRecordservice.deletes(ids);
        if(shanchu>0){
            return "yes";
        }else {
            return "";
        }
    }
}
