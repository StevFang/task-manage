package com.yoyo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Book
 *
 * Created by fbin on 2018/3/15.
 */
@Component
public class Book {

    @Value("${book.name}")
    private String name;

    @Value("${book.author}")
    private String author;

    @Value("${book.version}")
    private String version;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}
