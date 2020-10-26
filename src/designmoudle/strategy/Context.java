package com.strategy;

public class Context {
    PoliticStrategy strategy;

    public void setStrategy(PoliticStrategy strategy) {
        this.strategy = strategy;
    }

    void execute(String question){
        this.strategy.action(question);
    }


}
