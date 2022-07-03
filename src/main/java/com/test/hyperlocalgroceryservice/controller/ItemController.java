package com.test.hyperlocalgroceryservice.controller;

import com.test.hyperlocalgroceryservice.model.Item;
import com.test.hyperlocalgroceryservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public Iterable<Item> getAllItems(Model map) {
        return itemService.getAllItems();
    }
}