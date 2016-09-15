package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Scanner scan=new Scanner(System.in);

        System.out.println("input your class name:");
        Class _class=Class.forName(scan.nextLine());     //通过输入的类名加载类，
        Object obj=_class.newInstance();                //将这个类实例化
        System.out.println("tell me which method you wanted call:");
        Method method=_class.getMethod(scan.nextLine());
        method.invoke(obj);
        System.out.println("tell me which field you wanted call:");
        Field field=_class.getField(scan.nextLine());
        System.out.println(field.get(obj));
    }
}
