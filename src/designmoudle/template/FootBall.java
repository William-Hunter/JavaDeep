package com.template;

public class FootBall extends GameTemplate {
    @Override
    protected void initGame() {
        System.out.println("现在足球赛正在准备，双方的队员来到了绿茵场上，向观众致意，然后彼此面对，互相握手");
    }

    @Override
    protected void middleRest() {
        System.out.println("大家比赛的都都很疲劳，裁判吹响了中场休息哨，他们将休息十分钟");
        for (int i = 1; i <=10 ; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("中场休息结束了，裁判吹响了下半场的哨子，我们继续观看精彩的比赛吧");
    }


    protected boolean needDelayGame(){
        return true;
    }

}
