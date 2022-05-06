package com.codegym.listenMusic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    private long id;

    private String title;
    private String author;
    private String category;

    @Column(columnDefinition = "nvarchar")
    private String url;

    public Music() {
    }

    public Music(long id, String title, String author, String category, String url) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
