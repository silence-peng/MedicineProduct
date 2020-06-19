package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.CostMapper;
import com.ht.mapper.dataMapper.ProductInAndOutMapper;
import com.ht.pojo.ProductInAndOut;
import com.ht.service.dataService.CostService;
import com.ht.service.dataService.ProductInAndOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInAndOutServiceImpl implements ProductInAndOutService {
    @Autowired
    private ProductInAndOutMapper productInAndOutMapper;

    @Override
    public List<ProductInAndOut> getAll() {
        return productInAndOutMapper.selectAll();
    }

    @Override
    public List<ProductInAndOut> getData(ProductInAndOut productInAndOut) {
        return productInAndOutMapper.select(productInAndOut);
    }

    @Override
    public ProductInAndOut getOne(ProductInAndOut productInAndOut) {
        return productInAndOutMapper.selectByPrimaryKey(productInAndOut);
    }

    @Override
    public Integer add(ProductInAndOut productInAndOut) {
        return productInAndOutMapper.insert(productInAndOut);
    }

    @Override
    public Integer del(ProductInAndOut productInAndOut) {
        return productInAndOutMapper.delete(productInAndOut);
    }

    @Override
    public Integer upd(ProductInAndOut productInAndOut) {
        return productInAndOutMapper.updateByPrimaryKeySelective(productInAndOut);
    }
}
