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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private DistributeLeafletsService distributeLeafletsService;

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
    public ResultMap<List<SaleInfo>> getSaleInfo(Integer page, Integer limit, String startDate, String endDate, Order order) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=null;
        Date date2=null;
        if (startDate!=null && !startDate.equals("")){
            date1=simpleDateFormat.parse(startDate);
        }
        if (endDate!=null && !endDate.equals("")){
            date2=simpleDateFormat.parse(endDate);
        }
        List<SaleInfo> list=saleInfoMapper.getSaleInfo(page-1, limit,date1,date2,order.getCid(),order.getSalesman(),order.getOrderStatus());
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
        product.setState(1);
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
                product.setState(5);
                productService.upd(product);
            }
        }
        return orderService.upd(order)>0;
    }
    public boolean saveSaleInfo(Order order,List<Float> salePrices,List<Integer> pid){
        int result=orderService.add(order);
        for (int i=0;i<pid.size();i++){
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setOid(order.getOid());
            orderDetail.setPid(pid.get(i));
            orderDetail.setTotalSalesPrice(salePrices.get(i));
            Product product=new Product();
            product.setPid(pid.get(i));
            product.setState(5);
            result+=productService.upd(product);
            result+=orderDetailService.add(orderDetail);
        }
        return result>0;
    }

    public boolean delSaleInfo(List<Integer> delOrder) {
        int result=0;
        for (Integer i:delOrder) {
            Order order=new Order();
            order.setOid(i);
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setOid(i);
            List<OrderDetail> orderDetails=orderDetailService.getData(orderDetail);
            DistributeLeaflets distributeLeaflet=new DistributeLeaflets();
            distributeLeaflet.setOid(i);
            List<DistributeLeaflets> distributeLeaflets=distributeLeafletsService.getData(distributeLeaflet);
            for (DistributeLeaflets d:distributeLeaflets) {
                distributeLeafletsService.del(d);
            }
            for (OrderDetail o:orderDetails) {
                Product product=new Product();
                product.setPid(o.getPid());
                product.setState(1);
                productService.upd(product);
                orderDetailService.del(o);
            }
            result= orderService.del(order);
        }
        return result>0;
    }
}
