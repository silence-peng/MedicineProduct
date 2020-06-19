package com.ht.mapper.dataMapper;

import com.ht.pojo.Customer;
import org.springframework.stereotype.Repository;


@Repository("customerMapper")
public interface CustomerMapper extends tk.mybatis.mapper.common.Mapper<Customer>{
}
