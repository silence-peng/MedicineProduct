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
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;//产品ID
    private String productCode;//产品编码
    private String productName;//产品名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date warehousingDate;//入库日期
    private String BOMSingleName;//bom单名称
    private Float presalePrice;//预售价格
    private Integer warehouse;//外键
    private Integer state;//0未使用1使用中2已维修3已损坏
    private Integer productType;//外键
    private Integer airOutputPower;//空气输出功率
    private Integer vacuumOutputPower;//真空输出功率
    private Integer oxygenOutputPower;//氧气输出功率
}
