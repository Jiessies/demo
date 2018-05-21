package com.example.demo.entity;

import java.util.Date;

/**
 * Created by huangmingjie on 2018/1/11.
 */
public class Order {
    private String orderNo;
    private Date createtime;
    private int orderstatus;
    private int orderprice;
    
    public String getOrderNo() {
        return orderNo;
    }
    
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    
    public Date getCreatetime() {
        return createtime;
    }
    
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    
    public int getOrderstatus() {
        return orderstatus;
    }
    
    public void setOrderstatus(int orderstatus) {
        this.orderstatus = orderstatus;
    }
    
    public int getOrderprice() {
        return orderprice;
    }
    
    public void setOrderprice(int orderprice) {
        this.orderprice = orderprice;
    }
}
