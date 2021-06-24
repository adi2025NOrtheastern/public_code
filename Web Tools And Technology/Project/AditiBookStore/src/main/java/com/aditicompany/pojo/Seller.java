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
@Table(name = "seller_table")
@PrimaryKeyJoinColumn(name = "sellerId")
public class Seller implements Serializable //extends User
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sellerId", nullable = false, unique = true, length = 50)
    private Long sellerId;

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

    @Column(name = "sellerAddress")
    private String address;

    public String getApprove() {
        return approve;
    }

    public void setApprove(String approve) {
        this.approve = approve;
    }
    
     @Column(name = "approve")
    private String approve;

//    @Column(name = "sellerCity")
//    private String sellerCity;
//
//    @Column(name = "sellerZip")
//    private String sellerZip;
//
//    @Column(name = "sellerState")
//    private String sellerState;
//
//    @Column(name = "sellerCountry")
//    private String sellerCountry;

    @Column(name = "sellerPhone")
    private String phone;


//	@OneToMany(fetch=FetchType.LAZY, mappedBy="sellerID")
//	private Set<Orders> orders = new HashSet<Orders>();
    public Seller(String address, String city, String zip, String state, String country, String phone, String gender) {
        this.address = address;
//        this.sellerCity = city;
//        this.sellerZip = zip;
//        this.sellerState = state;
//        this.sellerCountry = country;
        this.phone = phone;
        this.gender = gender;
        this.roleName = "seller";

        this.approve="No";
        
        //this.orders=new HashSet<Orders>();
    }

    public Seller() {
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long buyerID) {
        this.sellerId = buyerID;
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
//
//    public String getSellerCity() {
//        return sellerCity;
//    }
//
//    public void setSellerCity(String sellerCity) {
//        this.sellerCity = sellerCity;
//    }
//
//    public String getSellerState() {
//        return sellerState;
//    }
//
//    public void setSellerState(String sellerState) {
//        this.sellerState = sellerState;
//    }
//
//    public String getSellerCountry() {
//        return sellerCountry;
//    }
//
//    public void setSellerCountry(String sellerCountry) {
//        this.sellerCountry = sellerCountry;
//    }
//
//    public String getSellerZip() {
//        return sellerZip;
//    }
//
//    public void setSellerZip(String sellerZip) {
//        this.sellerZip = sellerZip;
//    }

     public String getPhone() {
        return phone;
    }

    public void setPhone(String buyerPhone) {
        this.phone = buyerPhone;
    }

  

}
