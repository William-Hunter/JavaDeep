package thread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by william on 17-2-10.
 * 要在线程里面加上sleep，这样，能把cpu资源留出来执行，有同步效果
 * 测试多线程执行
 *
 */
public class DifferentWork {
    private static Logger logger = LoggerFactory.getLogger(DifferentWork.class);

    public static void main(String[] args){
        WorkOne one=new WorkOne();
        WorkTwo two= new WorkTwo();
        new Thread(one,"张三").start();
        new Thread(one,"李四").start();
        new Thread(two,"赵二").start();
        new Thread(two,"王五").start();
    }
}
class WorkOne implements Runnable{
    private static Logger logger = LoggerFactory.getLogger(WorkOne.class);
    @Override
    public void run() {
        for(int index=0;index<5;index++){
            try {
                Thread.sleep(new Double(Math.random() * 100).intValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info(Thread.currentThread().getName()+"正在看书的第"+(index+1)+"页");
        }

    }
}

class WorkTwo implements Runnable{
    private static Logger logger = LoggerFactory.getLogger(WorkTwo.class);
    @Override
    public void run() {
        for(int index=0;index<5;index++){
            try {
                Thread.sleep(new Double(Math.random() * 100).intValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info(Thread.currentThread().getName()+"正在吃第"+(index+1)+"个鸡蛋");
        }
    }
}