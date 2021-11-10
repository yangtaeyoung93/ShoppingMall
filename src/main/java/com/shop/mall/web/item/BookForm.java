package com.shop.mall.web.item;

import lombok.Getter;

@Getter
public class BookForm extends ItemForm{

    private String author;
    private String isbn;


    public BookForm() {
    }

    public BookForm(Long id, String name, int price, int stockQuantity, String dtype, String author, String isbn) {
        super(id, name, price, stockQuantity, dtype);
        this.author = author;
        this.isbn = isbn;
    }
}
