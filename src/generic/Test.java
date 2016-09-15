package generic;

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
	}

}
