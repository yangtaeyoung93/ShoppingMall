package com.shop.mall.web.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public  class ItemForm {

    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
    private String dtype;

    public ItemForm() {
    }

    public ItemForm(Long id, String name, int price, int stockQuantity, String dtype) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.dtype = dtype;
    }

    private String artist;
    private String etc;
    private String author;
    private String isbn;
    private String director;
    private String actor;
}
