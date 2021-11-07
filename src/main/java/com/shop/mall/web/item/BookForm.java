package com.shop.mall.web.item;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class BookForm extends ItemForm{

    private String author;
    private String isbn;
}
