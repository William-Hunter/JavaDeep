package designmoudle.proxy;

public class SystemImagePlayer implements ImagePlayer {

    protected SystemImagePlayer(){

    }

    @Override
    public void player(String filename) {
        if(this.loadImage(filename)){
            System.out.println("正在播放"+filename);
        }
    }

    private Boolean loadImage(String imgPath) {
        System.out.println("正在加载"+imgPath);
        return true;
    }
}
