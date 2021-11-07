package com.shop.mall.web.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public  class ItemForm {

    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
}
