package org.learning.javainheritanceshop;

import java.util.Objects;
import java.util.Scanner;

public class ShoppingCart {
    public static String name, description, price, memory, size, color;
    public static int productCategory, productCount;
    public static boolean isSmart, isWireless;
    public static Product[] products, finalProducts;
    public static Product product;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean shopping = true;
        productCount = 0;
        products = new Product[99];

        while (shopping) {

            System.out.println("Enter product name");
            name = scan.nextLine();

            System.out.println("Enter product description");
            description = scan.nextLine();

            System.out.println("Enter product price");
            price = scan.nextLine();

            System.out.println("Select product category \n 0: General \n 1: Smartphone \n 3: TV \n 4: Headphones");
            productCategory = Integer.parseInt(scan.nextLine());

            switch (productCategory) {

                case 1:
                    System.out.println("Enter memory");
                    memory = scan.nextLine();
                    product = new Phone(name, description, price, memory);
                    break;

                case 2:
                    System.out.println("Enter screen size");
                    size = scan.nextLine();
                    System.out.println("Smart? (y/n)");
                    isSmart = Objects.equals(scan.nextLine(), "y");
                    product = new TV(name, description, price, size, isSmart);
                    break;

                case 3:
                    System.out.println("Enter color");
                    color = scan.nextLine();
                    System.out.println("Wireless? (y/n)");
                    isWireless = Objects.equals(scan.nextLine(), "y");
                    product = new Headphones(name, description, price, color, isWireless);
                    break;

                default:
                    product = new Product(name, description, price);
                    break;
            }

            products[productCount] = product;
            productCount++;

            System.out.println("add more items? (y/n)");
            shopping = (Objects.equals(scan.nextLine(), "y"));
        }

        finalProducts = new Product[productCount];
        System.arraycopy(products, 0, finalProducts, 0, productCount);
        products = null;
        for (Product item : finalProducts) {
            System.out.println(item.printDetails());
        }

        scan.close();

    }
}

