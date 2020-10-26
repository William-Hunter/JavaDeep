package com.state;

public class GumBallMachine implements Machine{
    private State state;
    private int count = 0;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public GumBallMachine(int count) {
        this.count = count;
        if (this.count > 0) {
            this.setState(new NoQuarterState());
        } else {
            this.setState(new SoldOutState());
        }
    }

    /**
     * 投币
     */
    public void insertQuarter() {
        this.state.insertQuarter(this);
    }

    /**
     * 退币
     */
    public void ejectQuarter() {
        this.state.ejectQuarter(this);
    }

    /**
     * 转动把手
     */
    public void trunCrank() {
        this.state.trunCrank(this);
    }

    /**
     * 发糖果
     */
    public void dispense() {
        this.state.dispense(this);
    }

    public String toString(){
        return "STATE:"+this.state.toString()+"\tCOUNT:"+this.count;
    }

}
