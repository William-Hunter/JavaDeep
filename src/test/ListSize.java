package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/1/29.
 */
public class ListSize {
    public static void main(String[] args){
//        first();
//        second();
//        third();
        Scanner sc=new Scanner(System.in);
        System.out.println(sc);

//        String number="3";
//        System.out.println(number.hashCode());
//        test_param(number);
    }
    static void test_param(String number){
        System.out.println(number.hashCode());
    }

    /**
     * 想要知道，list里面存储的是引用还是实例   answear：实例
     */
    static void first(){
        List list_a=new ArrayList();
        List list_b=new ArrayList();
        list_a.add("a");
        list_a.add("b");
        list_a.add("c");
        list_a.add("d");
        for (int i=0;i<list_a.size();i++){
            Object obj=list_a.get(i);
            list_b.add(obj);
        }
        list_a.remove(0);
        System.out.println("A:"+list_a.size()+"\t"+"B:"+list_b.size());
    }
    /**
     * list添加的是
     */
    static void second(){
        List<Object> list_a=new ArrayList<Object>();
        List<Object> list_b=new ArrayList<Object>();
        Object a=new String("a");
        Object b=new String("b");
        list_a.add(a);          //添加a指向的那个实例
        list_a.add(b);
        list_b.add(list_a.get(0));
        list_b.add(list_a.get(1));
        list_a.remove(b);
        System.out.println("1:"+list_b.get(1));
        b=new String("c");                  //这时无论原有的
        System.out.println("2:"+list_b.get(1));
    }
    static void third(){

        /*
         List<Object> list=new ArrayList<Object>();
        StringBuffer a=new StringBuffer("a");
        System.out.print(a.hashCode()+"\n");
        list.add(a);
        System.out.print(a.append("==").hashCode()+"\n");
        for(Object e:list){
            System.out.print(e+"\t");
        }
        //a==

        List<Object> list=new ArrayList<Object>();
        String a="a";
        list.add(a);
        a.toUpperCase();        //此处返回一个新实例，而引用a和所指向的实例没有变化
        System.out.println(list.get(0));
        //没有变化

        List<Object> list=new ArrayList<Object>();
        int a=1;
        list.add(a);    //将这个地址添加进去了
        a=2;        //旧的引用指向了新的实例
        System.out.println(list.get(0));
        //result: 1
        */
    }
}

/**
 * 总结：
 * 当使用add方法的时候，添加的是指针所指向的实例的地址
 * 同理，get方法返回的是一个地址
 *  notice：=号是赋值，让指针指向了一个新实例
 *  用hashcode来效验是否为同一个实例
 *  String.toUpperCase()  创建了一个新实例
 */
