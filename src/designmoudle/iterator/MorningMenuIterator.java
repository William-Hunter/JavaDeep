package com.iterator;

import java.util.Iterator;

public class MorningMenuIterator implements Iterator {
    MenuItem[] items;
    int CURRENTINDEX=-1;

    public MorningMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return CURRENTINDEX<this.items.length-1  &&  this.items[this.CURRENTINDEX+1]!=null ;
    }

    @Override
    public MenuItem next() {
        this.CURRENTINDEX++;
        return this.items[this.CURRENTINDEX];
    }
}
