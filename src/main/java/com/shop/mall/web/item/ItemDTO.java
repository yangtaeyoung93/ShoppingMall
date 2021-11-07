package com.shop.mall.web.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDTO extends ItemForm{

    private String artist;
    private String etc;
    private String author;
    private String isbn;
    private String director;
    private String actor;
    private String dtype;
}
