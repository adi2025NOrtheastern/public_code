/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.pojo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author aditi
 */
@Entity
@Table(name = "book_table")
public class Book implements Serializable {

    //identity means take id from auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private long bookId;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private float price;

    @Column(name = "description")
    private String description;

    @Transient
    private String genre_name;

  // // @ManyToOne(targetEntity = Genre.class, cascade = CascadeType.PERSIST)
  //  @JoinColumn(name = "genreId", referencedColumnName = "genreId")
//    private Domain domain;
    @JoinColumn(name = "genreId")
    private long genreId;

    @Column(name = "photoName")
    private String photoName;

    
    //previously was-->  @Column(name = "sellerId") no one on one--> chekcing if join works
    //@ManyToOne(targetEntity = Seller.class, cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "sellerId", referencedColumnName = "sellerId")
    @JoinColumn(name = "sellerId")
    private long sellerId;
    
    
    @Column(name = "sold")
    private String sold;

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }


    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getSellerId() {
        return sellerId;
    }

    /*
    @Transient annotation is used to mark a field to be transient for the mapping framework, 
    which means the field marked with @Transient is ignored by mapping framework 
    and the field not mapped to any database column (in RDBMS) or Document property (in NOSQL)    
    
    */
    @Transient
    private MultipartFile photo;

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Book(String isbn, String title, String author, String genre_name, long genreId, float price, String description, long sellerId) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genreId = genreId;
        this.price = price;
        this.genre_name = genre_name;
        this.description = description;
        //this.photoName = photoName;
        this.sellerId = sellerId;
        this.sold="No";
    }

    public Book() {
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookID(long bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public String toString()
    {
        return "| Id: "+this.bookId +", Title: "+ this.title + " | ";
        
    }

}
