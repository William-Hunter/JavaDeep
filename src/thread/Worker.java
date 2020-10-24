package asynchronous;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by william on 2017/5/3.
 */
public class Worker {
    private Logger logger = LoggerFactory.getLogger(Worker.class);

    private Map<String, String> map;

    Worker() {
        map = new HashMap<String, String>();
    }

    public String order() {
        String number = (Math.random() * 100)+"";

        new Thread(){
            public void run(){
                try {
                    Thread.sleep(new Double(Math.random() * 100).intValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("do work......");
                map.put(number,number+"="+Math.random());
                logger.info("work done......");
            }
        }.start();

        return number;
    }

    public String pickup(String key) throws InterruptedException {
        Thread.sleep(new Double(Math.random() * 100).intValue());
        return this.map.get(key);
    }

}
