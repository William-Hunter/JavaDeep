package designmoudle.proxy.dynamic.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().startsWith("sayWord")){
            System.out.print("The robot said:");
        }
        return methodProxy.invokeSuper(o,objects);
    }
}
