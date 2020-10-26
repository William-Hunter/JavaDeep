package com.adpter;

public class FlvPlayer implements MediaPlayer {
    @Override
    public void play(String type, String fileName) {
        System.out.println("FLV播放器正在播放:"+fileName);
    }
}
