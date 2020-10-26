package com.responsibility_chains;

public abstract class AbstractLogger {
    public static final int INFO=1;
    public static final int DEBUG=2;
    public static final int ERROR=3;

    protected Integer LEVEL;

    protected AbstractLogger nextLogger;

    public AbstractLogger getNextLogger() {
        return nextLogger;
    }

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    synchronized protected void recordLog(int level,String log){
        if(this.nextLogger==null){
            System.out.println("没有下一个责任点了，我工作了");
            this.write(log);
        } else if(LEVEL<level){
            System.out.println("不是当前责任点的工作，进入下一个责任点");
            this.nextLogger.recordLog(level,log);
        } else{
            this.write(log);
        }
    }

    abstract void write(String log);

}
