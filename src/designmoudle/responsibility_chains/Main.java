package com.responsibility_chains;

public class Main {
    public static void main(String[] args){
        AbstractLogger start=setChains();
        System.out.println("=============================");
        start.recordLog(AbstractLogger.ERROR,"有致命错误");
        System.out.println("=============================");
        start.recordLog(AbstractLogger.INFO,"现在一切正常");
        System.out.println("=============================");
        start.recordLog(AbstractLogger.DEBUG,"这里变量值为100");
        System.out.println("=============================");

    }

    static AbstractLogger setChains(){
        AbstractLogger info=new InfoLogger();
        AbstractLogger debug=new DebugLogger();
        AbstractLogger error=new ErrorLogger();

        info.setNextLogger(debug);
        debug.setNextLogger(error);
        return info;
    }

}
