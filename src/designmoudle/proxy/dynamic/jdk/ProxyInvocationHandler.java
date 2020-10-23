package designmoudle.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocationHandler<T> implements InvocationHandler {

    private T t;

    public ProxyInvocationHandler(T t) {
        this.t = t;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("sayWord")){
            System.out.print("now,you said:");
        }
        return method.invoke(this.t,args);
    }
}
