package com.task.haulmont.entity;

public class Genre {
    private Long id;
    private String genre;

//    public Genre(String genre) {
//        this.genre = genre;
//    }

    public Genre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

}
