package org.learning.javainheritanceshop;

public class TV extends Product {
    private String size;
    private Boolean isSmart;

    public TV(String name, String description, String price, String size, Boolean isSmart) {
        super(name, description, price);
        this.size = size;
        this.isSmart = isSmart;
    }

    @Override
    public String printDetails() {
        return super.printDetails() + "\n" + "Size: " + size + "\n" + "Smart: " + (isSmart ? "Yes" : "No");
    }
}
