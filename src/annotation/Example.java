package annotation;

import java.lang.reflect.Method;

public class Example {

	@Hello("hello,world")
	public static void printWord() {
		Class test = Example.class;
		Method[] methods = test.getMethods();
		for (Method method : methods) {
			Hello annotation = method.getAnnotation(Hello.class);
			if (annotation != null) {
				System.out.println(annotation.value());
			}
		}

	}

	@Inject(peoplename = "william", doing = "working with annotation")
	public static void report() {
		Class test = Example.class;
		Method[] methods = test.getMethods();
		for (Method method : methods) {
			Inject annotation = method.getAnnotation(Inject.class);
			if (annotation != null) {
				System.out.println(annotation.peoplename() + " is " + annotation.doing());
			}
		}
	}

}
