package com.ht.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class XslxHelpPojo {
    @Excel(name ="使用科室")
    private String dname;
    @Excel(name ="科室间数")
    private Integer rooms;
    @Excel(name ="房间床位数")
    private Integer deds;
    private Integer did;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getDeds() {
        return deds;
    }

    public void setDeds(Integer deds) {
        this.deds = deds;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "XslxHelpPojo{" +
                "dname='" + dname + '\'' +
                ", rooms='" + rooms + '\'' +
                ", deds='" + deds + '\'' +
                ", did=" + did +
                '}';
    }
}
