package com.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Waiter {
    DinerMenu dinerMenu;
    MorningMenu morningMenu;
    CoffeeMenu coffeeMenu;

    public Waiter() {
        this.dinerMenu=new DinerMenu();
        this.dinerMenu.addItem("大盘鸡","一盘香扑扑的大盘鸡。",80.0);
        this.dinerMenu.addItem("麻辣鱼","无辣不欢的鱼，保证你爽口。",100.0);
        this.dinerMenu.addItem("羊肉串","来一来看一看了，正宗新疆羊肉串。",1.0);
        this.dinerMenu.addItem("土豆肉丝盖饭","我最喜欢的一道菜。",1.0);
        DinerMenu subDinerMenu=new DinerMenu();
        subDinerMenu.addItem("奶茶","牛奶加茶",11.0);
        subDinerMenu.addItem("猫屎咖啡","猫屎产量低啊",10.0);
        this.dinerMenu.setSubDinerMenu(subDinerMenu);

        this.morningMenu=new MorningMenu();
        this.morningMenu.addItem("煎鸡蛋","溏心的，喜欢吧。",80.0);
        this.morningMenu.addItem("烤面包","热爽的面包。",100.0);
        this.morningMenu.addItem("热牛奶","伊利牛奶。",1.0);
        this.morningMenu.addItem("冰淇淋","有没有人喜欢早上吃冰淇淋。",1.0);

        this.coffeeMenu=new CoffeeMenu();
        this.coffeeMenu.addItem("拿铁咖啡", "不太懂，但是感觉很小资", 18.0);
        this.coffeeMenu.addItem("鸟巢咖啡", "和雀巢是不是很类似", 10.0);
    }

    public void printMenuCu(){
        System.out.println("这是晚餐菜单");
        Iterator iterator=dinerMenu.createIterator();
        while(iterator.hasNext()){
            MenuItem e=(MenuItem)iterator.next();
            e.print();
        }

        System.out.println("接下来是早餐菜单");
        iterator=morningMenu.createIterator();
        while(iterator.hasNext()){
            MenuItem e=(MenuItem)iterator.next();
            e.print();
        }

        System.out.println("接下来是咖啡菜单");
        iterator=coffeeMenu.createIterator();
        while(iterator.hasNext()){
            MenuItem e=(MenuItem)iterator.next();
            e.print();
        }
    }

    void printMenuIte(){
        System.out.println("这是晚餐菜单");
        Iterator iterator=dinerMenu.createIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

        System.out.println("接下来是早餐菜单");
        iterator=morningMenu.createIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

        System.out.println("接下来是咖啡菜单");
        iterator=coffeeMenu.createIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    void printMenu(){
        System.out.println("这是晚餐菜单");
        ArrayList<MenuItem> list=(ArrayList<MenuItem>) dinerMenu.getMenuItems();
        for(MenuItem item:list){
            System.out.println(item.toString());
        }

        System.out.println("接下来是早餐菜单");
        MenuItem[] array=morningMenu.getMenuItems();
        for(int index=0;index<morningMenu.size;index++){
            System.out.println(array[index].toString());
        }
    }







}
