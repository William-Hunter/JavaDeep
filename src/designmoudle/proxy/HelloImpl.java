package designmoudle.proxy;

public class HelloImpl  implements Hello {

    public void sayWord(String words) {
        System.out.println(words);
    }

    public void doSomething(String thingName) {
        System.out.println(thingName);
    }
}
