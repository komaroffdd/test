package com.task.haulmont.entity;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Book {
    private Long id;

    @NotNull
    private String bookName;
    @NotNull
    private Integer author_id;
    @NotNull
    private Integer genre_id;
    @NotNull
    private String publisher;
    @NotNull
    private Date year;
    @NotNull
    private String city;

//    public Book(String bookName, Integer author_id, Integer genre_id) {
//        this.bookName = bookName;
//        this.author_id = author_id;
//        this.genre_id = genre_id;
//    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getAuthor() {
        return author_id;
    }

    public void setAuthor(Integer author_id) {
        this.author_id = author_id;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
