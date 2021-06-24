/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author aditi
 */
@Entity
@Table(name = "genre_table")
public class Genre implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genreId", unique = true, nullable = false)
    private long genreId;

    @Column(name = "genreName")
    private String genreName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genreId")
    
    private Set<Book> books = new HashSet<Book>();

    public Genre(String genreName) {
        this.genreName = genreName;
        this.books = new HashSet<Book>();
    }

    Genre() {
    }

    //adding books into the genre
    public void addBook(Book book) {
        getBooks().add(book);
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreID) {
        this.genreId = genreID;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Set<Book> getBooks() {
        return books;
    }
    
    public String removeBookById(long ID) {
        for(Book b: books)
        {
            if(b.getBookId()==ID)
            {
                books.remove(b);
                
                return "success";
                
            }
        }
        return "failed";
    }
    

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
