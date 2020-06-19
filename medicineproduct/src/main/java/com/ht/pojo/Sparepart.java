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
public class Sparepart implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;//备件ID
    private String sparePartCode;//备件编码
    private String sparepartName;//备件名称
    private Integer sparepartWarehouse;//外键 对应仓库表
    private Integer sparepartType;//对应备件类型表
    private Integer state;//0未使用1使用中2已维修3已损坏

}
