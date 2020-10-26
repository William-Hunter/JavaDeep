package com.adpter;

public class VlcPlayer implements MediaPlayer {

    @Override
    public void play(String type,String filename) {
        System.out.println("VLC播放器正在播放:"+filename);
    }
}
