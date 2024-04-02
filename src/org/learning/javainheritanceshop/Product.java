package org.learning.javainheritanceshop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Product {
    private int code;
    private String name, description;
    private BigDecimal price, priceWithVAT;
    private final BigDecimal VAT = BigDecimal.valueOf(0.20);

    public Product(String name, String description, BigDecimal price) {
        this.code = new Random().nextInt(100000000);
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getExtendedName() {
        return String.format("%08d", code) + "-" + name.toLowerCase().replace(" ", "");
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getPriceWithVAT() {
        return (
                price.add(price.multiply(VAT))
        ).setScale(2, RoundingMode.HALF_EVEN);
    }
}
