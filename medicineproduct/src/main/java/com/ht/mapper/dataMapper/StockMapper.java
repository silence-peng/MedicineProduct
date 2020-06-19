package com.ht.mapper.dataMapper;

import com.ht.pojo.Stock;
import org.springframework.stereotype.Repository;


@Repository("StockMapper")
public interface StockMapper extends tk.mybatis.mapper.common.Mapper<Stock>{
}
