package org.learning.javainheritanceshop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Product testProduct = new Product("Fish Sticks", "Fresh", BigDecimal.valueOf(26));
        System.out.println("code: " + testProduct.getCode());
        System.out.println("extended name: " + testProduct.getExtendedName());
        System.out.println("name: " + testProduct.getName());
        System.out.println("description: " + testProduct.getDescription());
        System.out.println("price: " + testProduct.getPrice());
        System.out.println("price + VAT: " + testProduct.getPriceWithVAT());
    }
}
