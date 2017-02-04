package test;

/**
 * Created by Administrator on 2017/2/1.
 * 看 父类是否能够获取子类成员，最好是以反射的方式
 */
public class ParentSon {
    public static void main(String[] args) {
        new Derived();                                                  //①
    }
}
class Base {
    private int i = 2;
    public Base() {
        System.out.println("000");
        this.display();
    }
    public void display() {
        System.out.println(i+"---");
    }
}
class Derived extends Base {
    private int i = 22;
    public Derived() {
        System.out.println("111");
        i = 222;
    }
    public void display() {
        System.out.println(i+"===");
    }
}