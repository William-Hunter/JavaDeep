package com.template;

public class Main {
    public static void main(String[] args){
        GameTemplate game=new FootBall();
        game.playGame();
        System.out.println("------------------------------------------");
        game=new Swim();
        game.playGame();

    }
}
