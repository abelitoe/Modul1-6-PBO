package com.book;

public class history extends Book{
    public String category;

    public history(String id, String title, String author, String category, int stock) {
        super(id, title, author, category, stock);
        this.category = category;
    }

}
