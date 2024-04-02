package org.learning.javainheritanceshop;

import java.util.Random;

public class Phone extends Product {
    private String IMEI, memory;

    public Phone(String name, String description, String price, String memory) {
        super(name, description, price);
        this.IMEI = generateIMEI();
        this.memory = memory;
    }

    public String generateIMEI() {
        IMEI = "";
        for (int i = 0; i < 15; i++) {
            IMEI += new Random().nextInt(10);
        }
        return IMEI;
    }

    @Override
    public String printDetails() {
        return super.printDetails() + "\n" + "IMEI: " + IMEI + "\n" + "Memory: " + memory + "GB";
    }
}
