package org.learning.javainheritanceshop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ShoppingCart {
    public static String name, description, price, memory, size, color;
    public static int productCategory, productCount;
    public static boolean isSmart, isWireless, loyaltyDiscount;
    public static Product[] products;
    public static Product product;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean shopping = true;
        loyaltyDiscount = false;
        productCount = 0;
        products = new Product[1];

        while (shopping) {

            System.out.println("Select product category \n 0: General \n 1: Smartphone \n 2: TV \n 3: Headphones");
            productCategory = Integer.parseInt(scan.nextLine());

            System.out.println("Enter product name");
            name = scan.nextLine();

            System.out.println("Enter product description");
            description = scan.nextLine();

            System.out.println("Enter product price");
            price = scan.nextLine();

            switch (productCategory) {

                case 1:
                    System.out.println("Enter memory");
                    memory = scan.nextLine();
                    product = new Phone(name, description, price, memory);
                    if (Integer.parseInt(memory) < 32) product.setDiscountRate(BigDecimal.valueOf(0.95));
                    break;

                case 2:
                    System.out.println("Enter screen size");
                    size = scan.nextLine();
                    System.out.println("Smart? (y/n)");
                    isSmart = Objects.equals(scan.nextLine(), "y");
                    product = new TV(name, description, price, size, isSmart);
                    if (!isSmart) product.setDiscountRate(BigDecimal.valueOf(0.90));
                    break;

                case 3:
                    System.out.println("Enter color");
                    color = scan.nextLine();
                    System.out.println("Wireless? (y/n)");
                    isWireless = Objects.equals(scan.nextLine(), "y");
                    product = new Headphones(name, description, price, color, isWireless);
                    if (!isWireless) product.setDiscountRate(BigDecimal.valueOf(0.93));
                    break;

                default:
                    product = new Product(name, description, price);
                    product.setDiscountRate(BigDecimal.valueOf(0.98));
                    break;
            }

            if (productCount > 0) products = Arrays.copyOf(products, products.length + 1);
            products[productCount] = product;
            productCount++;

            System.out.println("add more items? (y/n)");
            shopping = (Objects.equals(scan.nextLine(), "y"));
        }

        BigDecimal originalPrice = BigDecimal.valueOf(0);
        BigDecimal discountedPrice = BigDecimal.valueOf(0);
        BigDecimal saving = BigDecimal.valueOf(0);
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        BigDecimal totalSaving = BigDecimal.valueOf(0);

        System.out.println("Do you possess a loyalty card? (y/n)");
        loyaltyDiscount = (Objects.equals(scan.nextLine(), "y"));


        for (Product product : products) {

            if (loyaltyDiscount) {

                originalPrice = product.getPrice();
                discountedPrice = product.getDiscountedPrice().setScale(2, RoundingMode.HALF_EVEN);
                saving = originalPrice.subtract(discountedPrice).setScale(2, RoundingMode.HALF_EVEN);

                totalSaving = totalSaving.add(saving);
                product.setPrice(discountedPrice);

            }

            System.out.println(product.printDetails());
            totalPrice = totalPrice.add(product.getPrice());
            System.out.println("Price: €" + product.getPrice() + " (€" + product.getPriceWithVAT() + " including VAT of " + product.getVAT().movePointRight(2) + "%)");
            if (loyaltyDiscount) System.out.println("Saving: €" + saving + " (was €" + originalPrice + ")");

        }

        System.out.println("\n" + "*************** Order Summary ***************");
        System.out.println("Total Product(s): " + productCount);
        System.out.println("Total Price: €" + totalPrice.setScale(2, RoundingMode.HALF_EVEN));

        if (totalSaving.compareTo(BigDecimal.valueOf(0)) > 0) System.out.println("You saved €" + totalSaving + "!");

        scan.close();

    }
}


