package reflect;

/**
 * Created by william on 16-6-7.
 */
public class B {
    public String name;
    B(){
        System.out.println("B init");
    }
    public void tower(){
        System.out.println("*");
        System.out.println("***");
        System.out.println("******");
        System.out.println("********");
        this.name="beta";
    }
}
