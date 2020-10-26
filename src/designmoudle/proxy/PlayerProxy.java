package designmoudle.proxy;

public class PlayerProxy extends SystemImagePlayer implements ImagePlayer {

    private SystemImagePlayer player;

    PlayerProxy(){
        this.player=new SystemImagePlayer();
    }

    @Override
    public void player(String filename) {
        this.player.player(filename);
    }

}
