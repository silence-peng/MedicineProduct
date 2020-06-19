package com.ht.mapper.dataMapper;

import com.ht.pojo.Product;
import org.springframework.stereotype.Repository;


@Repository("ProductMapper")
public interface ProductMapper extends tk.mybatis.mapper.common.Mapper<Product>{
}
