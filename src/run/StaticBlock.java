package run;

/**
 * Created by william on 17-2-10.
 * 结论：静态代码块是在类加载时自动执行的，非静态代码块是在创建对象时自动执行的代码，不创建对象不执行该类的非静态代码块。
 */
public class StaticBlock {

    static {
        System.out.println("static block is running");
    }

    {
        System.out.println("non static block is running when new Object be create.");
    }


    public static void main(String[] args){
        System.out.println("================START================");

        StaticBlock test1=new StaticBlock();
        StaticBlock test2=new StaticBlock();

        System.out.println("================END================");
    }

}
