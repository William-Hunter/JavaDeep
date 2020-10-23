package designmoudle.proxy;

import designmoudle.proxy.dynamic.cglib.MyMethodInterceptor;
import designmoudle.proxy.stati.HelloProxy;
import net.sf.cglib.proxy.Enhancer;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        testStaticProxy();
//        testJDKDynamicProxy();
        testCglibDynamicProxy();
    }

    static public void testStaticProxy(){
        System.out.println("静态代理");
        Hello hello = new HelloProxy();
        hello.sayWord("Hello");
        hello.doSomething("eat breakfast");
    }

    static public void testJDKDynamicProxy(){
        /**
         * jdk动态代理，不需要代理类了,代理对象是在程序运行时产生的，
         * 但是需要被代理的接口以及其实现，如果代码中没有接口以及实现类，那么就无法使用jdk的动态代理
         */
        System.out.println("jdk动态代理,");
//        Hello hello2 = (Hello) Proxy.newProxyInstance(Main.class.getClassLoader(), // 1. 类加载器
//                                                      new Class<?>[] {Hello.class}, // 2. 代理需要实现的接口，可以有多个
//                                                      new ProxyInvocationHandler<Hello>(new HelloImpl()));// 3. 方法调用的实际处理者
//        hello2.sayWord("I love you!");
//        hello2.doSomething("eat dinner");

//        System.out.println("另外一个jdk动态代理，不需要新建代理类");
//
//        Car car=(Car) Proxy.newProxyInstance(Main.class.getClassLoader(), // 1. 类加载器
//                                             new Class<?>[] {Car.class}, // 2. 代理需要实现的接口，可以有多个
//                                             new ProxyInvocationHandler<Car>(new CarImpl()));
//        car.reciveCarRadio("Free asia radio");
    }

    static public void testCglibDynamicProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());
        HelloConcrete hello3 = (HelloConcrete)enhancer.create();
        hello3.sayWord("I love you!");
        List list =new ArrayList();
        List<String> list2 =new ArrayList();
    }

}
