package com.observer;

public class User implements Observer {
    String name;

    User(String name){
        this.name=name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void getMessage(String message) {
        System.out.println(this.name+"收到了消息："+message);
    }
}
