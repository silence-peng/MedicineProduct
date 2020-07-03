package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.ProductMapper;
import com.ht.pojo.Product;
import com.ht.pojo.ReturnVisit;
import com.ht.service.dataService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> getAll() {
        return productMapper.selectAll();
    }

    @Override
    public List<Product> getData(Product product) {
        return productMapper.select(product);
    }

    @Override
    public Product getOne(Product product) {
        return productMapper.selectByPrimaryKey(product);
    }

    @Override
    public Integer add(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public Integer del(Product product) {
        return productMapper.delete(product);
    }

    @Override
    public Integer upd(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }
}
