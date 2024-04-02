package org.learning.javainheritanceshop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Product[] products = new Product[3];


        Product fishSticks = new Product("Fish Sticks", "Fresh and Fishy", BigDecimal.valueOf(26));
        products[0] = fishSticks;

        Product cheddar = new Product("Cheddar Cheese", "Perfect for late night cheese toasties", BigDecimal.valueOf(14));
        products[1] = cheddar;

        Product habaneroChips = new Product("Habanero Chips", "Will melt your face", BigDecimal.valueOf(8));
        products[2] = habaneroChips;

        for (Product product : products) {
            product.printDetails();
        }


    }
}
