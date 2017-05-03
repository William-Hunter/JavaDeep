package set;

import java.util.Vector;

/**
 * Created by william on 2017/3/5.
 */
public class VectorTest {

    public static void main(String[] args) {
        Vector<String> list=new Vector<String>();
        for(int index=0;index<10;index++){
            list.add(index+"");
        }
        Worker worker=new Worker(list);

        new Thread(worker,"张三").start();
        new Thread(worker,"李四").start();

    }


}

class Worker implements Runnable {
    Vector<String> list;

    public Worker(Vector<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int index = 0; index < 5; index++) {
            try {
                while(this.list.size()>0){
//                    String value = this.list.get(this.list.size() - 1);       //不要分两步对数组进行操作，否则remove的时候操作的是不存在的元素
                    System.out.println(Thread.currentThread().getName() + "取出了" + this.list.remove(this.list.size() - 1));
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
