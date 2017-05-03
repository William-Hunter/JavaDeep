package asynchronous;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by william on 2017/5/3.
 */
public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args){
        logger.info("=============START============");

        Worker worker=new Worker();
        logger.info("send order");
        String key1=worker.order();
        logger.info("send order");
        String key2=worker.order();
        logger.info("send order");
        String key3=worker.order();
        logger.info("send order");

        try {
            logger.info("sleep");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info(worker.pickup(key1));
        logger.info(worker.pickup(key2));
        logger.info(worker.pickup(key3));

        logger.info("==============END=============");
    }
}