package com.ht.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SaleInfo implements Serializable {
    private String oid;//订单ID
    private Integer salesman;//外键 员工表
    private Float totalSalesPrice;//销售总价
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date saleDate;//销售日期
    private Integer cid;//外键 对应客户表
    private Integer salesVolumes;//销售数量
    private Integer orderStatus;//已完成，未完成，配送中，
    private Customer customer;
    private Staff staff;
    private List<Product> list;
    private List<OrderDetail> orderDetails;

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Integer getSalesman() {
        return salesman;
    }

    public void setSalesman(Integer salesman) {
        this.salesman = salesman;
    }

    public Float getTotalSalesPrice() {
        return totalSalesPrice;
    }

    public void setTotalSalesPrice(Float totalSalesPrice) {
        this.totalSalesPrice = totalSalesPrice;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSalesVolumes() {
        return salesVolumes;
    }

    public void setSalesVolumes(Integer salesVolumes) {
        this.salesVolumes = salesVolumes;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
}
