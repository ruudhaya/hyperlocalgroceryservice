package com.test.hyperlocalgroceryservice.repository;

import com.test.hyperlocalgroceryservice.model.Customer;
import com.test.hyperlocalgroceryservice.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query(value = "select c from Customer as c where c.email=?1 and c.password=?2")
    Customer findValidCustomer(String email, String password);

}
