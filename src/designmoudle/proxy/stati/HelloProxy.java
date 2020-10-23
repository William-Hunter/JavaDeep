package designmoudle.proxy.stati;

import designmoudle.proxy.Hello;
import designmoudle.proxy.HelloImpl;

public class HelloProxy implements Hello {

    private Hello hello;

    public HelloProxy() {
        this.hello = new HelloImpl();
    }

    public void sayWord(String words) {
        if(this.hello==null)this.hello = new HelloImpl();
        System.out.print("you said:");
        this.hello.sayWord(words);
    }

    public void doSomething(String thingName) {
        if(this.hello==null)this.hello = new HelloImpl();
        System.out.print("you do:");
        this.hello.doSomething(thingName);
    }

}
