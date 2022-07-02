package com.test.hyperlocalgroceryservice.util;

import org.springframework.context.annotation.Bean;

public class PercentageHandler {

    public static Float findDiscountedPrice (Float mrp, Float discount, String discountUnit) {
        if (discountUnit.equalsIgnoreCase("percentage")) {
            return mrp - (mrp * discount / 100);
        }
        return mrp - discount;
    }
}
