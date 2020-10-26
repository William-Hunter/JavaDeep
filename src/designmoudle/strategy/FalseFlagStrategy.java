package com.strategy;

public class FalseFlagStrategy implements PoliticStrategy {
    @Override
    public void action(String question) {
        System.out.println("现在发生了"+question+"事件，舆论非常激愤");
    }
}
