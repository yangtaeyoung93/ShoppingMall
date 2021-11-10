package com.shop.mall.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("Music")
public class Album extends Item{

    private String artist;
    private String etc;


    public Album() {
    }

    public Album(String name, int price, int stockQuantity,  String artist, String etc) {
        super(name, price, stockQuantity);
        this.artist = artist;
        this.etc = etc;
    }
}
