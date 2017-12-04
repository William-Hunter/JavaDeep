package cglib;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by william on 2017/7/26.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        test();

    }

    static void test() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException {
// 设置类成员属性
        HashMap propertyMap = new HashMap();
        propertyMap.put("id", Class.forName("java.lang.String"));
        propertyMap.put("name", Class.forName("java.lang.String"));
        propertyMap.put("address", Class.forName("java.lang.String"));

        // 生成动态 Bean
        CglibBean bean = new CglibBean(propertyMap);

        // 给 Bean 设置值
        bean.setValue("id", "123");
        bean.setValue("name", "454");
        bean.setValue("address", "789");

        // 从 Bean 中获取值，当然了获得值的类型是 Object
//        System.out.println("  >> id      = " + bean.getValue("id"));
//        System.out.println("  >> name    = " + bean.getValue("name"));
//        System.out.println("  >> address = " + bean.getValue("address"));

        // 获得bean的实体
        Object object = bean.getObject();
        // 通过反射查看所有方法名
        Class    clazz   = object.getClass();

        System.out.println("FIELDS==================================");
        Field[] fields=clazz.getDeclaredFields();
        for(int index=0;index<fields.length;index++){
//            System.out.println(fields[index].getName()+":"+fields[index].get(object));
//            fields[index].
        }

        System.out.println("methods==============================");
        Method[] methods = clazz.getDeclaredMethods();

        printAllMethod(object,methods);
        for (Integer i = 0; i < methods.length; i++) {
            String methodname= methods[ i ].getName();
            if (methodname.startsWith("set")){
                System.out.print(methodname+":");
                methods[i].invoke(object,(Object)i.toString());
                System.out.println("赋值了");
            }
        }
        printAllMethod(object,methods);
    }

    static void printAllMethod(Object object,Method[] methods) throws InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < methods.length; i++) {
            String methodname= methods[ i ].getName();
            if (methodname.startsWith("get")){
                System.out.print(methodname+":");
                System.out.println(methods[i].invoke(object));
            }
        }
    }



}
