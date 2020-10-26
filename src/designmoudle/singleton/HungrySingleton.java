package com.singleton;

public class HungrySingleton {

    private  HungrySingleton(String name){
        System.out.println("饿汉"+name+"单例实例化了");
    }

    private static HungrySingleton instance=new HungrySingleton("");

    public static HungrySingleton getInstance(){
        return instance;
    }


}
