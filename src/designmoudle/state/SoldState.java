package com.state;

public class SoldState implements State {
    @Override
    public void insertQuarter(Machine machine) {
        System.out.println("请等待状态切换完毕");
    }

    @Override
    public void ejectQuarter(Machine machine) {
        System.out.println("您已经转动曲柄了，不能退款");
    }

    @Override
    public void trunCrank(Machine machine) {
        System.out.println("您不能转动曲柄两次");
    }

    @Override
    public void dispense(Machine machine) {
        if(machine.getCount()>0){
            System.out.println("正在出货请稍后");
            machine.setCount(machine.getCount()-1);
            System.out.println("请拿好您的一个糖果");
        }else{
            System.out.println("应该给您一个糖果，但是数量不足，退款");
            machine.setState(new HasQuarterState());
            machine.ejectQuarter();
        }

        if(machine.getCount()>0){
            machine.setState(new NoQuarterState());
        }else{
            machine.setState(new SoldOutState());
        }
    }

    @Override
    public String toString() {
        return "已售";
    }

}
