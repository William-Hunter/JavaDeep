package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * create by william-lone
 * 注解类，创造了两个注解
 * */


@Target(ElementType.METHOD)			//设置这个注解可以存在的位置，指定给哪一类java成员注解，指定注解目标该是什么样的东西
@Retention(RetentionPolicy.RUNTIME)			//定义该注解的生命周期,表示注解运行的状态，换句话说，注解改在什么样的状态下才能运行。
public @interface Inject {
	String peoplename();							
	String doing();
}


@Target(ElementType.METHOD)			
@Retention(RetentionPolicy.RUNTIME)	
@interface Hello {
	String value();		//默认为value,使用时候可以省去字段名
	
}
