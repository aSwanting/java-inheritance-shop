package org.learning.javainheritanceshop;


public class Headphones extends Product {
    private String color;
    private Boolean isWireless;

    public Headphones(String name, String description, String price, String color, Boolean isWireless) {
        super(name, description, price);
        this.color = color;
        this.isWireless = isWireless;
    }

    @Override
    public String printDetails() {
        return super.printDetails() + "\n" + "Color: " + color + "\n" + "Wirless: " + (isWireless ? "Yes" : "No");
    }
}
