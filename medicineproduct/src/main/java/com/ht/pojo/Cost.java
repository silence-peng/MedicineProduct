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
public class Cost implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costid; //费用ID
    private String sid; //外键 对应员工表
    private String cid; //外键 对应客户表
    private Float cost; //费用
    private Integer enteredBy; //外键 员工表
    private Date enteredDate; //录入时间
    private Integer costType; //1安装，2保养，3，维修
    private Integer oid;//订单表外键
}
