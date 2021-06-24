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
@Table(name = "orderDetails_table")
public class OrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderDetailId")
    private long orderDetailId;

    //@OneToMany(fetch = FetchType.EAGER)
    @Column(name = "orderId")
    private long orderId;

    @Column(name = "bookId")
    private long bookId;

    @Column(name = "buyerId")
    private long buyerId;

    @Column(name = "bookName")
    private String bookName;

    @Column(name = "bookAuthor")
    private String bookAuthor;

    @Column(name = "price")
    private float price;

    @Column(name = "date")
    private String date;

    @Column(name = "sellerId")
    private long sellerId;

    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderDetails(long bookId, long orderId, long BuyerId, float price, String bookName, String bookAuthor, String date, long sellerId) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.buyerId = BuyerId;
        this.price = price;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.date = date;
        this.sellerId = sellerId;
    }

    public OrderDetails() {

    }

    public long getOrderDetailID() {
        return orderDetailId;
    }

    public void setOrderDetailID(long orderDetailID) {
        this.orderDetailId = orderDetailID;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long BuyerId) {
        this.buyerId = BuyerId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
