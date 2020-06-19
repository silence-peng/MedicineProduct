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
public class Warehouse implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wid;//仓库ID
    private String warehouseName;//仓库名称
    private String warehouseAddress;//仓库地址
    private Integer created_by;//外键
    private Date created_date;//创建时间
    private Integer region;//地区
}
