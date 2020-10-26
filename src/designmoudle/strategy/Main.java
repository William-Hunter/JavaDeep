package com.strategy;

public class Main {
    public static void main(String[] args){
        Context context=new Context();

        context.setStrategy(new FalseFlagStrategy());
        context.execute("袭击边境站");

        context.setStrategy(new RiotStrategy());
        context.execute("煽动");

        context.setStrategy(new BribeStrategy());
        context.execute("200,000,000");

    }
}
