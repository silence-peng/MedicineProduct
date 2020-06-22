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
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid; //客户ID
    private String customerName;//客户名称
    private String customerPhone;//客户电话
    private String customerAddress;//客户详细地址
    private String corporateName;//公司名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date signingDate;//签约日期
    private Integer customerStatus;//客户状态
    private String remarks;//备注
    private String paymentAccountNo;//付款账号
    private Integer rid;//地区
    private String networkaddress;//网络地址
}
