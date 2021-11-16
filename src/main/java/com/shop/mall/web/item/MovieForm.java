package com.shop.mall.web.item;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MovieForm extends ItemForm{

    @NotEmpty
    private String director;
    @NotEmpty
    private String actor;

    public MovieForm() {
    }

    public MovieForm(Long id, String name, int price, int stockQuantity, String dtype, String director, String actor) {
        super(id, name, price, stockQuantity, dtype);
        this.director = director;
        this.actor = actor;
    }
}
