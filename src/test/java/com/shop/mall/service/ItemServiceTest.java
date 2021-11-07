package com.shop.mall.service;

import com.shop.mall.domain.item.Item;
import com.shop.mall.repository.ItemRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(readOnly = true)
public class ItemServiceTest {
        @Autowired private ItemService itemService;
        @Autowired private ItemRepository itemRepository;

        @Test
        @Transactional
        public void 아이템_등록(){
                //given
                Item item = new Item();
                item.setName("Book");

                //when
                Long savedItemId = itemService.saveItem(item);

                //then
                assertEquals(item, itemRepository.findOne(savedItemId));
        }
}