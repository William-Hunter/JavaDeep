package com.responsibility_chains;

public class ErrorLogger extends AbstractLogger {
    ErrorLogger(){
        this.LEVEL=this.ERROR;
    }

    @Override
    void write(String log) {
        System.out.println("错误日志记录："+log);
    }
}
