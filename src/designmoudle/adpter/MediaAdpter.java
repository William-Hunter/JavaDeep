package com.adpter;

public class MediaAdpter implements MediaPlayer {

    private MediaPlayer advancedMediaPlayer;

    public MediaAdpter(String type){
        if(type.equals("mp4")) advancedMediaPlayer=new Mp4Player();
        if(type.equals("vlc")) advancedMediaPlayer=new VlcPlayer();
        if(type.equals("flv")) advancedMediaPlayer=new FlvPlayer();
    }


    @Override
    public void play(String type, String fileName) {
        advancedMediaPlayer.play(type,fileName);
    }
}
