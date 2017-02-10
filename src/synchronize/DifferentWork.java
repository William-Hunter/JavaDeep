package synchronize;

/**
 * Created by william on 17-2-10.
 * 要在线程里面加上sleep，这样，能把cpu资源留出来执行，有同步感
 */
public class DifferentWork {
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
    @Override
    public void run() {
        for(int index=0;index<5;index++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在看书的第"+(index+1)+"页");
        }

    }
}

class WorkTwo implements Runnable{
    @Override
    public void run() {
        for(int index=0;index<5;index++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在吃第"+(index+1)+"个鸡蛋");
        }
    }
}