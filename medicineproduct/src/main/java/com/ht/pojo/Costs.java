package com.ht.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ht.pojo.Customer;
import com.ht.pojo.Staff;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Costs {
    private Integer costId; //费用ID
    private Integer sid; //外键 对应员工表
    private Integer cid; //外键 对应客户表
    private Float cost; //费用
    private Integer enteredBy; //外键 员工表
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date enteredDate; //录入时间
    private Integer costType; //1安装，2保养，3，维修
    private Integer oid;//订单表外键
    private Customer customer;
    private Staff staff;

    public Integer getCostType() {
        return costType;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Integer getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(Integer enteredBy) {
        this.enteredBy = enteredBy;
    }

    public Date getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
    }

    public Integer getCostType(int i) {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }
}
