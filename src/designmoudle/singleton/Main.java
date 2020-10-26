package com.singleton;

public class Main {

    public static void main(String[] args){
        HungrySingleton one=HungrySingleton.getInstance();
        HungrySingleton two=HungrySingleton.getInstance();
        if(one==two) System.out.println("one和two是一个实例");

        LazySingleton three=LazySingleton.getInstance("3");
        LazySingleton four=LazySingleton.getInstance("4");
        if(three==four) System.out.println("three和four是一个实例");
    }
}
