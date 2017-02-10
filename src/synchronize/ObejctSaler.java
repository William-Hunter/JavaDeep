package synchronize;

/**
 * Created by william on 17-2-10.
 * 不是同时执行的，内存里有多个实例(代码段)
 */
public class ObejctSaler {
    private static int ticket=10;
    private String name;
    public ObejctSaler(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sale() throws InterruptedException {
        while(this.ticket>0){
//            Thread.sleep(500);
            System.out.println(this.getName()+"卖出了"+this.ticket--+"号票");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ObejctSaler saler1=new ObejctSaler("jack");
        ObejctSaler saler2=new ObejctSaler("william");
        ObejctSaler saler3=new ObejctSaler("john");
        ObejctSaler saler4=new ObejctSaler("bean");
        saler1.sale();
        saler2.sale();
        saler3.sale();
        saler4.sale();
    }
}
