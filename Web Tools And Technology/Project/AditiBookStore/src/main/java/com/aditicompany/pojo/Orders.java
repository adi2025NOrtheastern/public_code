/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aditi
 */
@Entity
@Table(name = "order_table")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private long orderId;

    @Column(name = "buyerId")
    private long buyerId;

    @Column(name = "buyerFirstName")
    private String buyerFirstName;

    @Column(name = "buyerLastName")
    private String buyerLastName;

    @Column(name = "buyerEmailId")
    private String buyerEmailId;

    @Column(name = "total")
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }

    @Column(name = "itemNumber")
    private int itemNumber;

    @Column(name = "orderDate")
    private String orderDate;

    //@Column(name = "sellerId")
    //private long sellerId;
    public String getBuyerEmailId() {
        return buyerEmailId;
    }

    public void setBuyerEmailId(String buyerEmailId) {
        this.buyerEmailId = buyerEmailId;
    }

    public Orders(long buyerId, String orderDate, int itemNumber, long sellid) {
        this.itemNumber = itemNumber;
        this.buyerId = buyerId;
        this.orderDate = orderDate;
        //  this.sellerId = sellid;
        //this.status = "New";
    }

//    public long getSellerId() {
//        return sellerId;
//    }
//
//    public void setSellerId(long sellerId) {
//        this.sellerId = sellerId;
//    }
    public Orders() {
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderID) {
        this.orderId = orderID;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

}
