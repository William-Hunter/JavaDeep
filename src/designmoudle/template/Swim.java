package com.template;

public class Swim extends GameTemplate {
    @Override
    protected void initGame() {
        System.out.println("现在游泳比赛正在准备，她们正在自己的身上抹上润滑油，以减少在水下的摩擦");
    }

    @Override
    protected void middleRest() {
        System.out.println("大家比赛的都都很疲劳，裁判吹响了中场休息哨，他们将休息3分钟，然后花2分钟洗个澡");
        for (int i = 1; i <=3 ; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("正在洗澡");
        for (int i = 1; i <=2 ; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("中场休息结束了，裁判吹响了下半场的哨子，我们继续观看精彩的比赛吧");
    }

}
