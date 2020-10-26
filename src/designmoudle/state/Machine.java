package com.state;

public interface Machine {

    public State getState() ;

    public void setState(State state);

    public int getCount();

    public void setCount(int count);


    /**
     * 投币
     */
    public void insertQuarter();

    /**
     * 退币
     */
    public void ejectQuarter() ;

    /**
     * 转动把手
     */
    public void trunCrank();

    /**
     * 售货
     */
    public void dispense();

}
