package lambda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static final Logger logger=LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1(){
        logger.debug("=======================");
        Face face=new Face() {                         //匿名方法   如果接口里面有若干个方法声明，那么可以在此处给予方法实现
            @Override
            public void doSomething() {
                System.out.println("shit1");
            }
//            @Override
//            public void fixWood() {
//                System.out.println("fix1");
//            }
        };
        face.doSomething();
//	    face.fixWood();
        logger.debug("=======================");
        Face perttyFace=new PerttyFace();
        perttyFace.doSomething();
        logger.debug("=======================");
        Face bigface=()->{              //lambda表达式     如果接口里面有单个方法声明，那么可以在此处给予一个方法实现，但是不适用于多个
            System.out.println("shit3");
        };
        bigface.doSomething();
        logger.debug("=======================");
    }

    public static void test2(){
        List<String> list=new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.forEach((e)->{System.out.println(e);});

    }

}
