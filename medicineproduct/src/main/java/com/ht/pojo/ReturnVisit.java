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
public class ReturnVisit implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer rid;//
    private  Integer sid;//外键
    private  Integer cid;//外键
    private  Integer record_id;//外键
    private  Integer wayOfReturnVisit;//
    private  String describe;//
    private  Integer returnVisitPersonnel;//外键 员工表
    private Date returnVisitDate;//
    private  Integer returnVisitType;//1安装，2保养，3，维修

}
