package com.responsibility_chains;

public class InfoLogger extends AbstractLogger {
    InfoLogger() {
        this.LEVEL=this.INFO;
    }

    @Override
    void write(String log) {
        System.out.println("普通日志记录："+log);
    }
}
