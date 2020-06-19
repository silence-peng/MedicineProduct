package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.CustomerMapper;
import com.ht.mapper.dataMapper.ProductTypeMapper;
import com.ht.pojo.ProductType;
import com.ht.service.dataService.CustomerService;
import com.ht.service.dataService.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;
    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectAll();
    }

    @Override
    public List<ProductType> getData(ProductType productType) {
        return productTypeMapper.select(productType);
    }

    @Override
    public ProductType getOne(ProductType productType) {
        return productTypeMapper.selectByPrimaryKey(productType);
    }

    @Override
    public Integer add(ProductType productType) {
        return productTypeMapper.insert(productType);
    }

    @Override
    public Integer del(ProductType productType) {
        return productTypeMapper.delete(productType);
    }

    @Override
    public Integer upd(ProductType productType) {
        return productTypeMapper.updateByPrimaryKeySelective(productType);
    }
}
