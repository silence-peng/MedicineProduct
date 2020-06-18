package com.ht.service.businessService;

//import com.ht.util.XslxUtil;
import com.ht.pojo.TestPojo;
import com.ht.util.XlsxImporTexportTemplate;
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
}
