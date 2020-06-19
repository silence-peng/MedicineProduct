package com.ht.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Record implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mid;//记录ID
    private Integer sid;//外键 对应员工表
    private Integer cid;//外键 对应 客户表
    private String takePhotosBeforeMaintenance;//维修前拍照
    private String takePhotosAfterMaintenance;//维修后拍照
    private Date repairDate;//维修日期
    private String repairAssessment;//维修评估
    private Integer whetherTheRepairIsSuccessful;//0成功 1失败
    private String faultDescription;//故障描述
    private Integer region;//外键
    private Integer faultType;//故障类型
    private Integer type;//1安装，2保养，3，维修
    private Integer pid;//外键 对应产品表
}
