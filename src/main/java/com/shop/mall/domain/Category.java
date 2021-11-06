package com.shop.mall.domain;

import com.shop.mall.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.*;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<CategoryItem> categoryItems = new ArrayList<>();

    public void addCategoryItem(CategoryItem categoryItem) {
        categoryItems.add(categoryItem);
        categoryItem.setCategory(this);
    }



}
