package com.observer;

public class Main {
    public static void main(String[] args){
        Subject subject=new Subject();

        User zhangsan=new User("张三");
        User lisi=new User("李四");

        subject.register(zhangsan);
        subject.register(lisi);
        subject.notifyAllObserver("公司最近开不了门，大家放假啊");

        subject.remove(zhangsan);
        subject.notifyAllObserver("刚才发错消息了，工作正常，不来的扣钱");
    }
}
