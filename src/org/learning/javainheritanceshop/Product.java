package org.learning.javainheritanceshop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Product {
    private int code;
    private String name, description;
    private BigDecimal price;
    private final BigDecimal VAT = BigDecimal.valueOf(0.20);

    public Product(String name, String description, String price) {
        this.code = new Random().nextInt(100000000);
        this.name = name;
        this.description = description;
        this.price = BigDecimal.valueOf(Double.parseDouble(price)).setScale(2, RoundingMode.HALF_EVEN);
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtendedName() {
        return String.format("%08d", code) + "-" + name.toLowerCase().replace(" ", "");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_EVEN);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithVAT() {
        return (price.add(price.multiply(VAT))).setScale(2, RoundingMode.HALF_EVEN);
    }

    public String printDetails() {
        return "\n" +
                "*************** " + getExtendedName() + " ***************" + "\n" +
                "Product N°" + getCode() + "\n" +
                "Name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Price: €" + price + " (€" + getPriceWithVAT() + " including VAT of " + VAT.movePointRight(2) + "%)";
    }
}
