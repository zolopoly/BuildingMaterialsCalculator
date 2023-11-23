package ru.kuzinatra.buildingmaterialscalculator;

public class Item{
    private final String name;
    private double price;
    private double discount;


    public Item(String name, long price, long discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public double getDiscountPrice() {
        return price - price * discount / 100;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }
}
