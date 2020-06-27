package com.ht.service.businessService.py;

//import com.ht.util.XslxUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.mapper.businessMapper.SaleInfoMapper;
import com.ht.pojo.Product;
import com.ht.pojo.SaleInfo;
import com.ht.pojo.TestPojo;
import com.ht.service.dataService.ProductService;
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
        return list;
    }
    @Autowired
    private SaleInfoMapper saleInfoMapper;
    @Autowired
    private ProductService productService;
    public ResultMap<List<SaleInfo>> getSaleInfo(Integer page, Integer limit){
        List<SaleInfo> list=saleInfoMapper.getSaleInfo(page-1, limit);
        Integer count=saleInfoMapper.getSaleInfoCount();
        String msg="";
        int code=0;
        return new ResultMap<>(msg, list, code, count);
    }
    public SaleInfo getSaleInfoById(Integer id){
        return  saleInfoMapper.getSaleInfoById(id);
    }
    public ResultMap<List<Product>> HandleProductInfo(Integer page,Integer limit){
        PageHelper.startPage(page, limit);
        Product product=new Product();
        product.setState(0);
        List<Product> list=productService.getData(product);
        PageInfo<Product> productPageInfo= new PageInfo<>(list);
        return new ResultMap<>("", productPageInfo.getList(), 0, productPageInfo.getTotal());
    }
}
