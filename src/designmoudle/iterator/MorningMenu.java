package com.iterator;

import java.util.Iterator;

public class MorningMenu {
    MenuItem[] menuItems;
    public int size=0;
    static final int MAXSIZE=10;

    public MorningMenu() {
        this.menuItems=new MenuItem[MAXSIZE];
    }

    public void addItem(String name ,String descript,Double price){
        if(this.size>=MAXSIZE){
            System.out.println("超了超了，不能加了");
            return;
        }
        MenuItem item=new MenuItem( name , descript, price);
        this.menuItems[this.size]=item;
        this.size++;
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public Iterator createIterator(){
        return new MorningMenuIterator(getMenuItems());
    }

}
