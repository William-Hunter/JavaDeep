package com.adpter;

public class AudioPlayer implements MediaPlayer {

    MediaAdpter adpter;

    @Override
    public void play(String type,String fileName) {
        switch (type){
            case "mp3":
                System.out.println("mp3播放器正在播放:"+fileName);
                break;
            case "mp4":
                adpter=new MediaAdpter("mp4");
                adpter.play(type,fileName);
                break;
            case "vlc":
                adpter=new MediaAdpter("vlc");
                adpter.play(type,fileName);
                break;
            case "flv":
                adpter=new MediaAdpter("flv");
                adpter.play(type,fileName);
                break;
            default:break;
        }
    }
}
