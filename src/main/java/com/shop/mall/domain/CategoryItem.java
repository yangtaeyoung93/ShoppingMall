package com.shop.mall.domain;

import com.shop.mall.domain.item.Item;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class CategoryItem {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ITEM_ID")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;


    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

}
