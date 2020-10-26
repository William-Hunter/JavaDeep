package com.state;

public class LuckyState implements State {
    @Override
    public void insertQuarter(Machine machine) {
        System.out.println("请勿重复投币");
    }

    @Override
    public void ejectQuarter(Machine machine) {
        System.out.println("请勿等待状态切换");
    }

    @Override
    public void trunCrank(Machine machine) {
        System.out.println("请等待状态切换");
    }

    @Override
    public void dispense(Machine machine) {
        System.out.println("您今天是一个幸运儿!");
        int count=machine.getCount();
        if(count<2){
            System.out.println("应该得到两个糖果，但是数量不足，正在退币");
            machine.setState(new HasQuarterState());
            machine.ejectQuarter();
        }else{
            machine.setCount(count-2);
            System.out.println("你得到了两个糖果");
        }
        if(machine.getCount()>0){
            machine.setState(new NoQuarterState());
        }else{
            machine.setState(new SoldOutState());
        }
    }
}
