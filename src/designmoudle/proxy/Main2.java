package designmoudle.proxy;


public class Main2 {
    public static void main(String[] args){
        PlayerProxy       proxy  =new PlayerProxy();
        SystemImagePlayer player =new SystemImagePlayer();
        player.player("/opt/picture/我爱我的祖国.jpg");
//        proxy.player("/opt/picture/我爱我的祖国.jpg");
    }
}
