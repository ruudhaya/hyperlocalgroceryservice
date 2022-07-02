package com.test.hyperlocalgroceryservice.service.impl;

import com.test.hyperlocalgroceryservice.model.Item;
import com.test.hyperlocalgroceryservice.service.ItemService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Override
    public List<Item> getAllItems() {
        return List.of(new Item("Onion"), new Item("Tomato"));
    }
}
