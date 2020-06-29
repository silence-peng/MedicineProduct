package com.ht.service.businessService.py;

//import com.ht.util.XslxUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.mapper.businessMapper.SaleInfoMapper;
import com.ht.pojo.*;
import com.ht.service.dataService.*;
import com.ht.util.ResultMap;
import com.ht.util.XlsxImporTexportTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleInfoManageService {

    @Autowired
    private SaleInfoMapper saleInfoMapper;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private DepartmentService departmentService;

    public List<XslxHelpPojo> readFile(MultipartFile file){
        String str="";
        List<Department> departments=departmentService.getAll();
        List<XslxHelpPojo> list=XlsxImporTexportTemplate.importData(file, 1, XslxHelpPojo.class);
        for (XslxHelpPojo pojo : list) {
            for (Department d: departments) {
                if (pojo.getDname().equals(d.getDname())){
                    pojo.setDid(d.getDid());


                }
            }
        }
        return list;
    }
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

    public ResultMap<List<Product>> HandleProductInfo(Integer page,Integer limit,SpecificationsDetail specificationsDetail){
        PageHelper.startPage(page, limit);
        Product product=new Product();
        product.setState(0);
        specificationsDetail.setSdid(page-1);
        specificationsDetail.setSid(limit);
        List<Product> list=saleInfoMapper.getProductData(specificationsDetail);


        PageInfo<Product> productPageInfo= new PageInfo<>(list);
        return new ResultMap<>("", productPageInfo.getList(), 0, productPageInfo.getTotal());
    }
    public boolean updOrder(Order order,List<Integer> odid,List<Float> salePrices,List<Integer> pid){
        for (int i=0;i<odid.size();i++){
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setOid(order.getOid());
            orderDetail.setPid(pid.get(i));
            orderDetail.setTotalSalesPrice(salePrices.get(i));
            if (odid.get(i)!=null){
               orderDetail.setOdid(odid.get(i));
                System.out.println(orderDetail);
               orderDetailService.upd(orderDetail);
            }else{
                orderDetailService.add(orderDetail);
                Product product=new Product();
                product.setPid(pid.get(i));
                product.setState(4);
                productService.upd(product);
            }
        }
        return orderService.upd(order)>0;
    }
}
