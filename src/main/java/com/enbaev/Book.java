package com.enbaev;

import java.util.UUID;

public class Book {
    String id;
    String title;
    String authorId;
    int pagesCount;

    public Book(String title,String authorId,int pagesCount) {
        this.id = UUID.randomUUID().toString();
        this.title=title;
        this.authorId=authorId;
        this.pagesCount=pagesCount;
    }
}
