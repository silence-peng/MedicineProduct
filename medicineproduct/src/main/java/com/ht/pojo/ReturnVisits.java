package com.ht.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ht.pojo.Customer;
import com.ht.pojo.Staff;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ReturnVisits {
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
    private Customer customer;
    private Staff staff;

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

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getWayOfReturnVisit() {
        return wayOfReturnVisit;
    }

    public void setWayOfReturnVisit(Integer wayOfReturnVisit) {
        this.wayOfReturnVisit = wayOfReturnVisit;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Integer getReturnVisitPersonnel() {
        return returnVisitPersonnel;
    }

    public void setReturnVisitPersonnel(Integer returnVisitPersonnel) {
        this.returnVisitPersonnel = returnVisitPersonnel;
    }

    public Date getReturnVisitDate() {
        return returnVisitDate;
    }

    public void setReturnVisitDate(Date returnVisitDate) {
        this.returnVisitDate = returnVisitDate;
    }

    public Integer getReturnVisitType() {
        return returnVisitType;
    }

    public void setReturnVisitType(Integer returnVisitType) {
        this.returnVisitType = returnVisitType;
    }

}
