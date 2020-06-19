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
public class Staff implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;//ID
    private String sname;//员工姓名
    private String accountNumber;//账号
    private String password;//密码
    private String phoneNumber;//手机号码
    private Integer sex;//0男 1女
    private String email;//邮箱号码
    private Date birthday;//出生日期
    private String residentialAddress;//居住地址
    private Integer role;//角色
    private Integer state;//状态
    private Date creationTime;//创建时间
}