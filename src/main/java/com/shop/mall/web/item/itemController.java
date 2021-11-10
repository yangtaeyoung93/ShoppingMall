package com.shop.mall.web.item;

import java.util.List;
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

    @GetMapping("/add/{type}")
    public String addItemForm(@PathVariable("type") String type, Model model){

        if(type.equals("book")){
            model.addAttribute("form",new BookForm());
        }else if(type.equals("music")){
            model.addAttribute("form",new AlbumForm());
        }else{
            model.addAttribute("form",new MovieForm());
        }

        model.addAttribute("type", type);
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

    @GetMapping("")
    public String  itemList(Model model){
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping("/{itemId}/edit/{type}")
    public String updateItemForm(@PathVariable("itemId") Long itemId, @PathVariable("type") String type, Model model) {
       if(type.equalsIgnoreCase("book")){
            Book item = (Book) itemService.findOne(itemId);
            model.addAttribute("form",new BookForm(item.getId(),item.getName(),item.getPrice(),item.getStockQuantity(),item.getDtype(),item.getAuthor(),item.getIsbn()));
        }else if(type.equalsIgnoreCase("music")){
            Album item = (Album) itemService.findOne(itemId);
           model.addAttribute("form", new AlbumForm(item.getId(), item.getName(), item.getPrice(), item.getStockQuantity(), item.getDtype(), item.getArtist(), item.getEtc()));
        }else{
            Movie item = (Movie) itemService.findOne(itemId);
           model.addAttribute("form", new MovieForm(item.getId(), item.getName(), item.getPrice(), item.getStockQuantity(), item.getDtype(), item.getDirector(), item.getActor()));
        }

        model.addAttribute("dtype", type);
        return "items/updateItemForm";
    }


    @PostMapping("/{itemId}/edit/{type}")
    public String editItem(@PathVariable("itemId") Long itemId,@ModelAttribute(name = "form") ItemDTO itemDTO) {
        log.info("name ={},price={},stockquantity={},item={}",itemDTO.getName(), itemDTO.getPrice(),itemDTO.getStockQuantity(),itemDTO.getArtist());
            itemService.updateItem(itemId,itemDTO);
        return "redirect:/items";
    }


}
