package run;

/**
 * Created by Administrator on 2017/12/17.
 */
public class Super extends This{
    private String fans;

    public Super(String fans){
        this.fans=fans;
    }

    public void printf() {
        System.out.println("child:"+this.fans);
        super.print("done");
    }

    public void function(){
        System.out.println("function.....");
    }

}
