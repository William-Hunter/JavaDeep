package com.template;

public abstract class GameTemplate {

    /**
     * 赛前准备，每种比赛不一样，各自实现
     */
    abstract protected void initGame();

    /**
     * 比赛开始
     */
    protected final void startGame(){
        System.out.println("裁判一声令下，比赛开始了");
    }

    /**
     * 中场休息，每种比赛休息的具体内容不同，各自实现
     */
    abstract protected void middleRest();


    /**
     * 比赛结束，
     */
    protected final void endGame(){
        System.out.println("裁判看了看时间，吹了哨，比赛结束了");
    }

    public final void playGame(){
        this.initGame();
        this.startGame();
        this.middleRest();
        if(this.needDelayGame()){
            this.delayGame();
        } else{
            this.endGame();
        }
    }

    /**
     * 钩子函数，通过这个函数，动态的改变流程
     * @return
     */
    protected boolean needDelayGame(){
        return false;
    }

    protected void delayGame(){
        System.out.println("比赛要延期了，结束看起来遥遥无期");
    }
}
