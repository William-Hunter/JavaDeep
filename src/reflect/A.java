package reflect;

/**
 * Created by william on 16-6-7.
 */
public class A {
    public String name;
    A(){
        System.out.println("A init");
    }
    public void show(){                 //这些方法的权限必须要为公共的
        System.out.println("hello,I am A instance");
        this.name="alpha";
    }
}
