package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.RecordMapper;
import com.ht.pojo.Record;
import com.ht.service.dataService.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService{
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public List<Record> getAll() {
        return recordMapper.selectAll();
    }

    @Override
    public List<Record> getData(Record record) {
        return recordMapper.select(record);
    }

    @Override
    public Record getOne(Record record) {
        return recordMapper.selectByPrimaryKey(record);
    }

    @Override
    public Integer add(Record record) {
        return recordMapper.insert(record);
    }

    @Override
    public Integer del(Record record) {
        return recordMapper.delete(record);
    }

    @Override
    public Integer upd(Record record) {
        return recordMapper.updateByPrimaryKeySelective(record);
    }
}
