package com.ht.service.businessService.lx;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.mapper.dataMapper.MachineRoomMapper;
import com.ht.pojo.MachineRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class MachineRoomBusinessService {
    @Autowired
    private MachineRoomMapper machineRoomMapper;

    /**
     * 分页
     *
     * @param Filename
     * @param page
     * @param limit
     * @return
     */
    public PageInfo<MachineRoom> QuyMachineRoomPage(String Filename, Integer page, Integer limit) {
        //分页
        PageHelper.startPage(page, limit);
        //条件
        Example example = new Example(MachineRoom.class);
        if (Filename != null) {
            example.createCriteria().orLike("fileName", "%" + Filename.toLowerCase() + "%");
        }
        //返回
        return new PageInfo<>(machineRoomMapper.selectByExample(example));
    }

    /**
     * 新增
     *
     * @param machineRoom
     * @return
     */
    public Integer AddMachineRoom(MachineRoom machineRoom) {
        return machineRoomMapper.insertSelective(machineRoom);
    }

    /**
     * 修改
     *
     * @param machineRoom
     * @return
     */
    public Integer UpdateMachineRoom(MachineRoom machineRoom) {
        return machineRoomMapper.updateByPrimaryKey(machineRoom);
    }

    /**
     * 修改前查询
     *
     * @param machineRoom
     * @return
     */
    public MachineRoom UpdateMachineRoomQuy(MachineRoom machineRoom) {
        return machineRoomMapper.selectOne(machineRoom);
    }

    /**
     * '
     * 删除
     *
     * @param machineRoom
     * @return
     */
    public Integer DelMachineRoom(MachineRoom machineRoom) {
        return machineRoomMapper.deleteByPrimaryKey(machineRoom);
    }
}
