package com.ht.service.businessService;

//import com.ht.util.XslxUtil;
import com.ht.mapper.businessMapper.SaleInfoMapper;
import com.ht.pojo.SaleInfo;
import com.ht.pojo.TestPojo;
import com.ht.util.ResultMap;
import com.ht.util.XlsxImporTexportTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class SaleInfoManageService {
    public List<TestPojo> readFile(MultipartFile file){
        List<TestPojo> list=XlsxImporTexportTemplate.importData(file, 1, TestPojo.class);
        System.out.println(list);
        return list;
    }
    @Autowired
    private SaleInfoMapper saleInfoMapper;
    public ResultMap<List<SaleInfo>> getSaleInfo(Integer page, Integer limit){
        List<SaleInfo> list=saleInfoMapper.getSaleInfo(page, limit);
        Integer count=saleInfoMapper.getSaleInfoCount();
        String msg="";
        int code=0;
        return new ResultMap<>(msg, list, code, count);
    }
}
