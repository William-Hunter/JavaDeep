package com.strategy;

public class RiotStrategy implements PoliticStrategy{

    @Override
    public void action(String question) {
        System.out.println("您要是不追随我的脚步，我就发动暴乱");
    }
}
