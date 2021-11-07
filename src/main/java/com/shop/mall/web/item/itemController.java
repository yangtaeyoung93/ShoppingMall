package com.shop.mall.web.item;

import com.shop.mall.domain.item.Album;
import com.shop.mall.domain.item.Book;
import com.shop.mall.domain.item.Item;
import com.shop.mall.domain.item.Movie;
import com.shop.mall.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/items")
@RequiredArgsConstructor
public class itemController {

    private final ItemService itemService;

    @GetMapping("/add/{category}")
    public String addItemForm(@PathVariable("category") String category, Model model){

        if(category.equals("book")){
            model.addAttribute("form",new BookForm());
        }else if(category.equals("music")){
            model.addAttribute("form",new AlbumForm());
        }else{
            model.addAttribute("form",new MovieForm());
        }

        model.addAttribute("category", category);
        return "items/createItemForm";
    }

     @PostMapping("/add")
    public String create(ItemDTO itemDTO){
        String dtype = itemDTO.getDtype();
         Item item;
        if(dtype.equals("B")){
            item = new Book(itemDTO.getName(),itemDTO.getPrice(), itemDTO.getStockQuantity(), itemDTO.getAuthor(),itemDTO.getIsbn());
        }else if(dtype.equals("A")){
            item = new Album(itemDTO.getName(),itemDTO.getPrice(), itemDTO.getStockQuantity(), itemDTO.getArtist(),itemDTO.getEtc());
        }else{
            item = new Movie(itemDTO.getName(), itemDTO.getPrice(), itemDTO.getStockQuantity(), itemDTO.getDirector(), itemDTO.getActor());
        }

         itemService.saveItem(item);

        return "redirect:/";
    }


}
