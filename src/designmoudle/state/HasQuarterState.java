package com.state;

import java.util.Random;

public class HasQuarterState implements State {
    @Override
    public void insertQuarter(Machine machine) {
        System.out.println("机器里已经有币，不接受您的投币");
    }

    @Override
    public void ejectQuarter(Machine machine) {
        machine.setState(new NoQuarterState());
        System.out.println("退出硬币");
    }

    @Override
    public void trunCrank(Machine machine) {
        double d = Math.random();
        int random = (int)(d*100);
//        System.out.println("random:"+random);
        if(random>50){
            machine.setState(new SoldState());
        }else{
            machine.setState(new LuckyState());
        }
        machine.dispense();
    }

    @Override
    public void dispense(Machine machine) {
        System.out.println("请转动把手");
    }

    @Override
    public String toString() {
        return "持币";
    }
}
