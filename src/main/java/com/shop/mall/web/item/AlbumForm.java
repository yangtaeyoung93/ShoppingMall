package com.shop.mall.web.item;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class AlbumForm  extends ItemForm{

    private String artist;
    private String etc;

    public AlbumForm() {
    }

    public AlbumForm(Long id, String name, int price, int stockQuantity, String dtype, String artist, String etc) {
        super(id, name, price, stockQuantity, dtype);
        this.artist = artist;
        this.etc = etc;
    }
}
