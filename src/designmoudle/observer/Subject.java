package com.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    static List<Observer> observers=new ArrayList<>();

    void register(Observer observer){
        observers.add(observer);
        System.out.println("将"+observer.getName()+"加入到观察队列");
    }

    void remove(Observer observer){
        observers.remove(observer);
        System.out.println("将"+observer.getName()+"移除了观察队列");
    }

    public void notifyAllObserver(String message){
        for (Observer o:observers) {
            o.getMessage(message);
        }
    }


}
