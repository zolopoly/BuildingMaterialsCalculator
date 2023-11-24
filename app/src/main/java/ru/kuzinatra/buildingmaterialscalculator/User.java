package ru.kuzinatra.buildingmaterialscalculator;

import java.util.ArrayList;
import java.util.List;

public class User {
    private double wallet;
    private List<Item> cart;

    public User(double wallet) {
        this.wallet = wallet;
        this.cart = new ArrayList<>();
    }

    public double getWallet() {
        return wallet;
    }

    public List<Item> getCart() {
        return cart;
    }

    public boolean buy(Item item) {
        if (item.getDiscountPrice() <= wallet) {
            wallet -= item.getDiscountPrice();
            cart.add(item);
            return true;
        }
        return false;
    }
}
