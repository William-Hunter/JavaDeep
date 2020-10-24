package synchronize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 *
 * 重新多线程下的同时访问共享资源导致的数据错误，以及线程安全的效果
 *
 * Created by william on 17-2-10.
 * 同一段代码（内存里只有一个实例）被多个线程同时执行
 *
 */
public class ThreadSaler implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(ThreadSaler.class);

    private ArrayList<String> ticket;

    public ThreadSaler(ArrayList<String> ticket) {
        this.ticket = ticket;
    }

    synchronized boolean safeSale(){
        if(this.ticket.size()>0){
            logger.info(Thread.currentThread().getName()+"卖出了"+this.ticket.remove(this.ticket.size()-1)+"号票");
            return true;
        }else{
            return false;
        }
    }

    boolean dangerSale(){
        if(this.ticket.size()>0){
            logger.info(Thread.currentThread().getName()+"卖出了"+this.ticket.remove(this.ticket.size()-1)+"号票");
            return true;
        }else{
            return false;
        }
    }
    @Override
    /**
     * 随着睡眠时间加长，这种多线程之间的取得脏数据的现象会会更加明显
     * */
    public void run() {
        try {
//            while(this.dangerSale()) {
            while(this.safeSale()) {
//                Thread.sleep(new Double(Math.random() * 10000).intValue());
//                Thread.sleep(1000);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        ArrayList<String> list=new ArrayList<String>();
        for(int index=0;index<10;index++){
            list.add(index+"");
        }
        ThreadSaler saler=new ThreadSaler(list);
        new Thread(saler,"jack").start();
        new Thread(saler,"bean").start();
        new Thread(saler,"john").start();
        new Thread(saler,"william").start();
    }
}
