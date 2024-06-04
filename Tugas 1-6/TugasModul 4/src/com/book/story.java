package com.book;

public class story extends Book{
    public String category;

    public story(String id, String title, String author, String category, int stock) {
        super(id, title, author, category, stock);
        this.category = category;
    }

}
