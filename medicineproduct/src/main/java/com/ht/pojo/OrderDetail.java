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
public class OrderDetail implements Serializable{
    @Id
    private String odid;//订单明细ID
    private Integer oid;//外键 订单表
    private Integer pid;//外键 产品表
    private Float totalSalesPrice;//销售价格


}
