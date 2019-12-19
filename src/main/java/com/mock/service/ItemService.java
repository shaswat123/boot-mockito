package com.mock.service;

import com.mock.model.Item;
import com.mock.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item getItem(){

        return new Item("444","Peripheral Device",50.0);
    }

    public List<Item> retrieveAll(){

        return itemRepository.findAll();
    }
}
