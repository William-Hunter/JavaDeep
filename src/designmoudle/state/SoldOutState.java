package com.state;

public class SoldOutState implements State {
    @Override
    public void insertQuarter(Machine machine) {
        System.out.println("糖果售罄，请退款");
    }

    @Override
    public void ejectQuarter(Machine machine) {
        System.out.println("糖果售罄，压根没收钱，无法退款");
    }

    @Override
    public void trunCrank(Machine machine) {
        System.out.println("糖果售罄，压根没收钱，您不能转动把手");
    }

    @Override
    public void dispense(Machine machine) {
        System.out.println("糖果告罄，请退币");
    }

    @Override
    public String toString() {
        return "售罄";
    }
}
