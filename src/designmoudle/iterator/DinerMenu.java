package com.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class DinerMenu{
    ArrayList menuItems;
    private DinerMenu subDinerMenu;

    public DinerMenu getSubDinerMenu() {
        return subDinerMenu;
    }

    public void setSubDinerMenu(DinerMenu subDinerMenu) {
        this.subDinerMenu = subDinerMenu;
    }

    public ArrayList getMenuItems() {
        return menuItems;
    }

    public void addItem(String name ,String descript,Double price){
        MenuItem item=new MenuItem( name , descript, price);
        this.menuItems.add(item);
    }

    public DinerMenu() {
        this.menuItems=new ArrayList();
    }

    public Iterator createIterator(){
        DinerMenuIterator dinerMenuIterator=new DinerMenuIterator(getMenuItems());
        dinerMenuIterator.add(this.subDinerMenu.getMenuItems());
        return dinerMenuIterator;
    }

}
