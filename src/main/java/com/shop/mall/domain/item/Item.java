package com.shop.mall.domain.item;

import com.shop.mall.domain.CategoryItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
@Entity
@Getter @Setter
public class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private List<CategoryItem> categoryItems = new ArrayList<>();


}
