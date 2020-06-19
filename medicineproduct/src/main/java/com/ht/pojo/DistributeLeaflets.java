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
public class DistributeLeaflets implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer did;//派单ID
    private  Integer sid;//外键 对应员工表
    private  Integer cid;//外键 对应客户表
    private  Integer oid;//外键 对应订单表
    private  Integer type;//1安装，2保养，3，维修
    private  Integer status;//已接收，待接收，已完成
    private Date createDate;//派单日期
    private  Date endDate;//截止日期


}
