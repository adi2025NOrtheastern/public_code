/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author aditi
 */
@Entity
@Table(name = "buyer_table")
@PrimaryKeyJoinColumn(name = "buyerId")

public class Buyer implements Serializable //extends User 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyerId", nullable = false, unique = true)
    private long buyerId;

    @Column(name = "firstName", length = 50)
    private String firstName;

    @Column(name = "lastName", length = 50)
    private String lastName;

    @Column(name = "emailID", length = 30)
    private String emailID;

    @Column(name = "roleName", length = 50)
    private String roleName;

    @Column(name = "username", length = 10)
    private String username;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "buyerAddress")
    private String address;

//    @Column(name = "buyerCity")
//    private String buyerCity;
//
//    @Column(name = "buyerZip")
//    private String buyerZip;
//
//    @Column(name = "buyerState")
//    private String buyerState;
//
//    @Column(name = "buyerCountry")
//    private String buyerCountry;
    @Column(name = "buyerPhone")
    private String phone;

//    @Column(name = "buyerGender")
//    private String buyerGender;
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="buyerID")
//	private Set<Orders> orders = new HashSet<Orders>();
    public Buyer(String address, String city, String zip, String state, String country, String phone, String gender) {
        //this.buyerAddress = address;
//        this.buyerCity = city;
//        this.buyerZip = zip;
//        this.buyerState = state;
//        this.buyerCountry = country;
        this.phone = phone;
        // this.buyerGender = gender;
        this.roleName = "buyer";
        //this.orders=new HashSet<Orders>();
    }

    public Buyer() {
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerID) {
        this.buyerId = buyerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

     public String getAddress() {
        return address;
    }

    public void setAddress(String sellerAddress) {
        this.address = sellerAddress;
    }

//    public String getBuyerCity() {
//        return buyerCity;
//    }
//
//    public void setBuyerCity(String buyerCity) {
//        this.buyerCity = buyerCity;
//    }
//
//    public String getBuyerState() {
//        return buyerState;
//    }
//
//    public void setBuyerState(String buyerState) {
//        this.buyerState = buyerState;
//    }
//
//    public String getBuyerCountry() {
//        return buyerCountry;
//    }
//
//    public void setBuyerCountry(String buyerCountry) {
//        this.buyerCountry = buyerCountry;
//    }
//
//    public String getBuyerZip() {
//        return buyerZip;
//    }
//
//    public void setBuyerZip(String buyerZip) {
//        this.buyerZip = buyerZip;
//    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String buyerPhone) {
        this.phone = buyerPhone;
    }

//    public String getBuyerGender() {
//        return buyerGender;
//    }
//
//    public void setBuyerGender(String buyerGender) {
//        this.buyerGender = buyerGender;
//    }
}
