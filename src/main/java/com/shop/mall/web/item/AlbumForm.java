package com.shop.mall.web.item;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter @Getter
public class AlbumForm  extends ItemForm{

    @NotEmpty
    private String artist;
    @NotEmpty
    private String etc;

    public AlbumForm() {
    }

    public AlbumForm(Long id, String name, int price, int stockQuantity, String dtype, String artist, String etc) {
        super(id, name, price, stockQuantity, dtype);
        this.artist = artist;
        this.etc = etc;
    }
}
