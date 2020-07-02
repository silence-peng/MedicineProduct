package com.ht.pojo.xc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ht.pojo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)//链式写法
public class DistributeLeafletss implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer did;//派单ID
    private  Integer sid;//外键 对应员工表
    private  Integer cid;//外键 对应客户表
    private  Integer oid;//外键 对应订单表
    private  Integer type;//1安装，2保养，3，维修
    private  Integer status;//已接收，待接收，已完成
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;//派单日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private  Date endDate;//截止日期
    private Staff staffs;
    private Customer customers;
    private OrderDetail OrderDetails;
    private  Product products;
    private  Order orders;

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
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

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Staff getStaffs() {
        return staffs;
    }

    public void setStaffs(Staff staffs) {
        this.staffs = staffs;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public OrderDetail getOrderDetails() {
        return OrderDetails;
    }

    public void setOrderDetails(OrderDetail orderDetails) {
        OrderDetails = orderDetails;
    }
}
