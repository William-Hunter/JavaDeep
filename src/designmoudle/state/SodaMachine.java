package com.state;

public class SodaMachine implements Machine {
    State state=null;
    int count = 0;

    public SodaMachine(int count){
        this.setCount(count);
        if (this.count > 0) {
            this.setState(new NoQuarterState());
        } else {
            this.setState(new SoldOutState());
        }
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void setState(State state) {
        this.state=state;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public void setCount(int count) {
        this.count=count;
    }

    @Override
    public void insertQuarter() {
        this.getState().insertQuarter(this);
    }

    @Override
    public void ejectQuarter() {
        this.getState().ejectQuarter(this);
    }

    @Override
    public void trunCrank() {
        this.getState().trunCrank(this);
    }

    @Override
    public void dispense() {
        this.getState().dispense(this);
    }

    @Override
    public String toString() {
        return "STATE:"+this.state.toString()+"\tCOUNT:"+this.count;
    }
}
