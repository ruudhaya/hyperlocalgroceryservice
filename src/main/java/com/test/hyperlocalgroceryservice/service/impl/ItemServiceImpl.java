package com.test.hyperlocalgroceryservice.service.impl;

import com.test.hyperlocalgroceryservice.model.Item;
import com.test.hyperlocalgroceryservice.repository.ItemRepository;
import com.test.hyperlocalgroceryservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
