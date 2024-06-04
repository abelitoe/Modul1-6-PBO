package com.book;

public class text extends Book{
    public String category;

    public text(String id, String title, String author, String category, int stock) {
        super(id, title, author, category, stock);
        this.category = category;
    }

}
