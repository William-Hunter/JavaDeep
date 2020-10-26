package com.state;

public class Main {
    public static void main(String[] args) {
        Machine machine=new GumBallMachine(7);
        for(int index=1;index<=6;index++){
            System.out.println("================"+index+"================");
            machine.insertQuarter();
            System.out.println(machine.toString());
            machine.trunCrank();
            System.out.println(machine.toString());
        }

        machine=new SodaMachine(7);
        for(int index=1;index<=6;index++){
            System.out.println("================"+index+"================");
            machine.insertQuarter();
            System.out.println(machine.toString());
            machine.trunCrank();
            System.out.println(machine.toString());
        }
    }
}
