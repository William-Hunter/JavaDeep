package com.adpter;

public class Mp4Player implements MediaPlayer {
    @Override
    public void play(String type,String filename) {
        System.out.println("MP4播放器正在播放:"+filename);
    }

}
