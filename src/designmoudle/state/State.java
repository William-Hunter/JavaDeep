package com.state;

public interface State {
    void insertQuarter(Machine machine);

    void ejectQuarter(Machine machine);

    void trunCrank(Machine machine);

    void dispense(Machine machine);
}
