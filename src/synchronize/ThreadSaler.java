package synchronize;

/**
 * Created by william on 17-2-10.
 * 同一段代码（内存里只有一个实例）被多个线程同时执行
 *
 */
public class ThreadSaler implements Runnable {
    private int ticket=10;

    synchronized void sale() throws InterruptedException {
        while(this.ticket>0){
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+"卖出了"+this.ticket--+"号票");
        }
    }
    @Override
    public void run() {
        try {
            this.sale();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        ThreadSaler saler=new ThreadSaler();
        new Thread(saler,"jack").start();
        new Thread(saler,"bean").start();
        new Thread(saler,"john").start();
        new Thread(saler,"william").start();
    }
}
