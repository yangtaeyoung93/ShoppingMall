package com.shop.mall.service;

import com.shop.mall.domain.item.Album;
import com.shop.mall.domain.item.Book;
import com.shop.mall.domain.item.Item;
import com.shop.mall.domain.item.Movie;
import com.shop.mall.repository.ItemRepository;
import com.shop.mall.web.item.ItemDTO;
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
    public void updateItem(Long itemId, ItemDTO itemDTO) {
        Item item = itemRepository.findOne(itemId);

        String dtype = itemDTO.getDtype();


        if(dtype.equalsIgnoreCase("book")){
            item = (Book) item;
            ((Book) item).setAuthor(itemDTO.getAuthor());
            ((Book) item).setIsbn(itemDTO.getIsbn());
            item.setName(itemDTO.getName());
            item.setPrice(itemDTO.getPrice());
            item.setStockQuantity(itemDTO.getStockQuantity());
        } else if (dtype.equalsIgnoreCase("music")) {
           item = (Album) item;
           ((Album) item).setArtist(itemDTO.getArtist());
           ((Album) item).setEtc(itemDTO.getEtc());
            item.setName(itemDTO.getName());
            item.setPrice(itemDTO.getPrice());
            item.setStockQuantity(itemDTO.getStockQuantity());
        }else{
            item = (Movie)item;
            ((Movie) item).setDirector(itemDTO.getDirector());
            ((Movie) item).setActor(itemDTO.getActor());
            item.setName(itemDTO.getName());
            item.setPrice(itemDTO.getPrice());
            item.setStockQuantity(itemDTO.getStockQuantity());
        }
        log.info("name ={}, price={}, StockQuantity={}" , itemDTO.getName(),item.getPrice(),item.getStockQuantity());

    }
}
