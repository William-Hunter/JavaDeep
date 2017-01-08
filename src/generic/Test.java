package generic;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		
		String word1="hello",word2;
		word2=Generic.process(word1);
		System.out.println("content2:"+word2);
		
		int number1=6,number2;
		number2=Generic.process(number1);
		System.out.println("number2:"+number2);
		
		String[] array={"1","2","3"};
		String element;
		element=Generic.array(array);
		System.out.println("the last element is "+element);		
		
		String a="a";
		int b=2;
		Generic.both(a, b);
		Generic.both(b, a);
		Generic.both(b, b);
		
		Generic.longParm(1,2,3,4,5);
		Generic.longParm("a","b","c","d","e");
		
		AbstractList t = new ArrayList();
		t.add(2L);
		ArrayList s = new ArrayList(),s2=null;
		s.add("hello");
		s2=Generic.extend(t, s);
		System.out.println("extends:"+s2.get(0));

		Store sto=null;
		Store2 sto2=null;		
		System.out.println(Generic.extend(sto, sto2));
		
		
		Store<String> store=new Store<String>();
//		store.add(1);	//当定义的时候设置类型为String后，添加数字类型是不被允许的。
		
		
	}

}
