package com.singleton;

public class LazySingleton {

    private  LazySingleton(String name){
        System.out.println("饿汉"+name+"单例实例化了");
    }

    private static LazySingleton instance;

    synchronized public static LazySingleton getInstance(String name){
        if(instance==null)instance=new LazySingleton(name);
        return instance;
    }


}
