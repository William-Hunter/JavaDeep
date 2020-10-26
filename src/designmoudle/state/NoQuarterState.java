package com.state;

public class NoQuarterState implements State{
    @Override
    public void insertQuarter(Machine machine) {
        machine.setState(new HasQuarterState());
        System.out.println("您投入了币，接下来请转动把手获取糖果");
    }

    @Override
    public void ejectQuarter(Machine machine) {
        System.out.println("机器里没有币，无法退币");
    }

    @Override
    public void trunCrank(Machine machine) {
        System.out.println("请您先投币，再转动把手");
    }

    @Override
    public void dispense(Machine machine) {
        System.out.println("请投币再转动把手");
    }

    @Override
    public String toString() {
        return "无币";
    }
}
