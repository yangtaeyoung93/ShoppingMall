package com.shop.mall.web.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MovieForm extends ItemForm{

    private String director;
    private String actor;

    public MovieForm() {
    }

    public MovieForm(Long id, String name, int price, int stockQuantity, String dtype, String director, String actor) {
        super(id, name, price, stockQuantity, dtype);
        this.director = director;
        this.actor = actor;
    }
}
