package com.iterator;

import java.util.List;

public class MenuItem {
    String name;
    String descript;
    Double price;



    public MenuItem(String name, String descript, Double price) {
        this.name = name;
        this.descript = descript;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void print(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "名称:"+this.name+"\t\t介绍:"+this.descript+"\t\t价格:"+this.price;
    }
}
