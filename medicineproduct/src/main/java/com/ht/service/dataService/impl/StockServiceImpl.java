package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.StockMapper;
import com.ht.pojo.ReturnVisit;
import com.ht.pojo.Stock;
import com.ht.service.dataService.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    @Override
    public List<Stock> getAll() {
        return stockMapper.selectAll();
    }

    @Override
    public List<Stock> getData(Stock stock) {
        return stockMapper.select(stock);
    }

    @Override
    public Stock getOne(Stock stock) {
        return stockMapper.selectByPrimaryKey(stock);
    }

    @Override
    public Integer add(Stock stock) {
        return stockMapper.insert(stock);
    }

    @Override
    public Integer del(Stock stock) {
        return stockMapper.delete(stock);
    }

    @Override
    public Integer upd(Stock stock) {
        return stockMapper.updateByPrimaryKeySelective(stock);
    }
}
