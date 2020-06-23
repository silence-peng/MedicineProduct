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
public class ReturnVisit implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer rid;//
    private  Integer cid;//外键
    private  Integer recordId;//外键
    private  Integer wayOfReturnVisit;//
    private  String describes;//
    private  Integer returnVisitPersonnel;//外键 员工表
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date returnVisitDate;//
    private  Integer returnVisitType;//1安装，2保养，3，维修

    public Integer getReturnVisitType() {
        return returnVisitType;
    }

    public void setReturnVisitType(Integer returnVisitType) {
        this.returnVisitType = returnVisitType;
    }
}
