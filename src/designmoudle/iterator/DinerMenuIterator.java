package com.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DinerMenuIterator implements Iterator {
    int CURRENTINDEX=-1;

    ArrayList menuItems;

    public void add(List list){
        this.menuItems.addAll(list);
    }


    public DinerMenuIterator(ArrayList menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return CURRENTINDEX<this.menuItems.size()-1;
    }


    @Override
    public MenuItem next() {
        this.CURRENTINDEX++;
        return (MenuItem) this.menuItems.get(this.CURRENTINDEX);
    }

}
