package com.test.hyperlocalgroceryservice.controller;

import com.test.hyperlocalgroceryservice.model.Item;
import com.test.hyperlocalgroceryservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> getAllItems(Model map) {
        List<Item> products = itemService.getAllItems();
        return products;
    }
}