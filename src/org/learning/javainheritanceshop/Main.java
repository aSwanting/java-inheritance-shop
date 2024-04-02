package org.learning.javainheritanceshop;

public class Main {
    public static void main(String[] args) {

        Product[] products = new Product[4];

        Product testProduct = new Product("Fish Sticks", "Fresh and Fishy", "26");
        products[0] = testProduct;

        Phone testPhone = new Phone("Samsung Galaxy", "Flagship Samsung", "500", "256");
        products[1] = testPhone;

        TV testTV = new TV("LG CX", "Gaming TV", "800", "52", false);
        products[2] = testTV;

        Headphones testHeadphones = new Headphones("Astro A40's", "Optical Surround", "60", "grey", true);
        products[3] = testHeadphones;

        for (Product product : products) {
            System.out.println(product.printDetails());
        }


    }
}
