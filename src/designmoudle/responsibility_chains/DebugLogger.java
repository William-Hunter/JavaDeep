package com.responsibility_chains;

public class DebugLogger extends AbstractLogger {
    DebugLogger(){
        this.LEVEL=this.DEBUG;
    }

    @Override
    void write(String log) {
        System.out.println("调试日志记录："+log);
    }
}
