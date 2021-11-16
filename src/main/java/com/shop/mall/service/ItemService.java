package com.shop.mall.service;

import com.shop.mall.domain.item.Album;
import com.shop.mall.domain.item.Book;
import com.shop.mall.domain.item.Item;
import com.shop.mall.domain.item.Movie;
import com.shop.mall.repository.ItemRepository;
import com.shop.mall.web.item.ItemForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private  final ItemRepository itemRepository;

    @Transactional
    public Long saveItem(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    @Transactional
    public void updateItem(Long itemId, ItemForm itemForm) {

        Item item = itemRepository.findOne(itemId);
        String dtype = itemForm.getDtype();

        if(dtype.equalsIgnoreCase("book")){
            item = (Book) item;
            ((Book) item).setAuthor(itemForm.getAuthor());
            ((Book) item).setIsbn(itemForm.getIsbn());
        } else if (dtype.equalsIgnoreCase("music")) {
           item = (Album) item;
           ((Album) item).setArtist(itemForm.getArtist());
           ((Album) item).setEtc(itemForm.getEtc());
        }else{
            item = (Movie)item;
            ((Movie) item).setDirector(itemForm.getDirector());
            ((Movie) item).setActor(itemForm.getActor());
        }

        item.setName(itemForm.getName());
        item.setPrice(itemForm.getPrice());
        item.setStockQuantity(itemForm.getStockQuantity());

        log.info("name ={}, price={}, StockQuantity={}" , item.getName(),item.getPrice(),item.getStockQuantity());

    }
}
