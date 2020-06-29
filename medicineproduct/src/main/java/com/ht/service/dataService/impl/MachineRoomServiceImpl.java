package com.ht.service.dataService.impl;

import com.ht.mapper.dataMapper.MachineRoomMapper;
import com.ht.pojo.FaultType;
import com.ht.pojo.MachineRoom;
import com.ht.service.dataService.FaultTypeService;
import com.ht.service.dataService.MachineRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineRoomServiceImpl implements MachineRoomService {

    @Autowired
    private MachineRoomMapper machineRoomMapper;

    @Override
    public List<MachineRoom> getAll() {
        return machineRoomMapper.selectAll();
    }

    @Override
    public List<MachineRoom> getData(MachineRoom machineRoom) {
        return machineRoomMapper.select(machineRoom);
    }

    @Override
    public MachineRoom getOne(MachineRoom machineRoom) {
        return machineRoomMapper.selectByPrimaryKey(machineRoom);
    }

    @Override
    public Integer add(MachineRoom machineRoom) {
        return machineRoomMapper.insert(machineRoom);
    }

    @Override
    public Integer del(MachineRoom machineRoom) {
        return machineRoomMapper.delete(machineRoom);
    }

    @Override
    public Integer upd(MachineRoom machineRoom) {
        return machineRoomMapper.updateByPrimaryKeySelective(machineRoom);
    }
}
