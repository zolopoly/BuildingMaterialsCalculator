package ru.kuzinatra.buildingmaterialscalculator;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int soldItemCount;
    private User user;
    private static List<Item> items = new ArrayList<>();

    static {
        items.add(new Item("Бетон", 120, 12));
        items.add(new Item("Доска обрезная", 90, 7));
        items.add(new Item("Металлочерепица", 30, 22));
        items.add(new Item("Кирпич", 55, 0));
        items.add(new Item("Метизы", 19, 19));
    }

    public Store(User user) {
        this.user = user;
    }

    public static List<Item> getItems() {
        return items;
    }

    public boolean sell() {
        for (Item item : items) {
            if (user.buy(item)) {
                soldItemCount++;
            }
        }
        return soldItemCount == items.size();
    }
}
