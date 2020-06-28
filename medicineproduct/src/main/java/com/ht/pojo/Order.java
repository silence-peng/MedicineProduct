package com.ht.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class Order implements Serializable{
    @Id
    private Integer oid;//订单ID
    private Integer salesman;//外键 员工表
    private Float totalSalesPrice;//销售总价
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date saleDate;//销售日期
    private Integer cid;//外键 对应客户表
    private Integer salesVolumes;//销售数量
    private Integer orderStatus;//已完成，未完成，配送中，


}