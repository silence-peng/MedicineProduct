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
public class    ProductInAndOut implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer pid;//出入库ID
    private  Integer productName;//产品类型
    private  Integer operator;//外键 员工表
    private  Integer operationType;//0出库 1入库
    private  Integer inAndOutQuantity;//出入库数量
    private Date inOutDate;//出入库日期
    private  Integer inPrice;//入库金额

}
