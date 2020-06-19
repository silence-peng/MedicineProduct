package com.ht.mapper.dataMapper;


import com.ht.pojo.Order;
import org.springframework.stereotype.Repository;


@Repository("OrderMapper")
public interface OrderMapper extends tk.mybatis.mapper.common.Mapper<Order>{
}
