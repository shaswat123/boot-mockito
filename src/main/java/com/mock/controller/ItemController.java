package com.mock.controller;

import com.mock.model.Item;
import com.mock.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public Item getItem(){

        return new Item("122","Key Board",20.0);

    }

    @GetMapping("/items-service")
    public Item getItemService(){
        return itemService.getItem();

    }

    @GetMapping("/listItems")
    public List<Item> listItems(){

        return itemService.retrieveAll();

    }
}
