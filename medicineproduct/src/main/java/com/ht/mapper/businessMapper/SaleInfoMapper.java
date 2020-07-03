package com.ht.mapper.businessMapper;

import com.ht.pojo.Product;
import com.ht.pojo.SaleInfo;
import com.ht.pojo.SpecificationsDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("saleInfoMapper")
public interface SaleInfoMapper {
    List<SaleInfo> getSaleInfo(@Param("page") int page, @Param("limit") Integer limit, @Param("startDate") Date date1, @Param("endDate") Date date2, @Param("cid") Integer cid, @Param("sid") Integer sid
            , @Param("state") Integer state);
    Integer getSaleInfoCount();
    SaleInfo getSaleInfoById(Integer id);
    List<Product> getProductData(SpecificationsDetail specificationsDetail);

}
