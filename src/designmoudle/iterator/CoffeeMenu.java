package com.iterator;

import java.util.*;
import java.util.Iterator;

public class CoffeeMenu {
    Hashtable menuItems;

    public CoffeeMenu() {
        this.menuItems = new Hashtable();
    }

    public void addItem(String name, String descript, Double price) {
        MenuItem item = new MenuItem(name, descript, price);
        menuItems.put(item.name, item);
    }


    public Hashtable getMenuItems() {
        return menuItems;
    }

    public Iterator createIterator() {
        return this.menuItems.values().iterator();
    }


}
