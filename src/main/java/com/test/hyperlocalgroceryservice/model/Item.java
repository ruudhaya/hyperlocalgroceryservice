package com.test.hyperlocalgroceryservice.model;

import com.test.hyperlocalgroceryservice.util.PercentageHandler;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Item implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float mrp;
    private Float weight;
    private String weightUnit = "grams";       // Unit could be litre / grams / kg / count, etc.. Could be converted to enum later
    private Integer quantity;
    private Float discount;
    private String discountUnit = "percentage"; // Discount could be converted to enum with different options, flat discount, etc..
    private Integer availableQuantity;
    private Float discountedSellingPrice;

    public Item(String name, Float mrp, Float weight, Integer quantity, Float discount, Integer availableQuantity) {
        this.name = name;
        this.mrp = mrp;
        this.weight = weight;
        this.quantity = quantity;
        this.discount = discount;
        this.availableQuantity =availableQuantity;
        this.discountedSellingPrice = PercentageHandler.findDiscountedPrice(mrp, discount, discountUnit);
    }
    public Item(){}
}
