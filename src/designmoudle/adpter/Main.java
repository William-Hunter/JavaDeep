package com.adpter;

public class Main {
    public static void main(String[] args){
        AudioPlayer player=new AudioPlayer();
        player.play("mp3","以父之名.mp3");
        player.play("mp4","赵氏孤儿.mp4");
        player.play("mp4","建国大业.mp3");
        player.play("vlc","建党伟业.vlc");
        player.play("flv","新闻联播.flv");
    }
}
