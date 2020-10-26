package com.strategy;

public class BribeStrategy implements PoliticStrategy{
    @Override
    public void action(String question) {
        System.out.println("我收到你的钱"+question+"元，我现在是你的朋友了");
    }

}
