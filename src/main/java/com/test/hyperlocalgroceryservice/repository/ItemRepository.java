package com.test.hyperlocalgroceryservice.repository;

import com.test.hyperlocalgroceryservice.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
