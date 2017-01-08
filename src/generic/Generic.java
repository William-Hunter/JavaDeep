package generic;

import java.util.ArrayList;
import java.util.List;

public class Generic {
	/**
	 * <T,M>    尖括号包围的区域是用来定义类型的，只有先预先定义了类型，才能去使用这个类进行指代。
	 * 
	 * */
	
	
	
	//M就像代数上的X，代指某个类型，可以是String，也可以是int
	public static <M> M process(M argv) {
		return argv;
	}

	//测试数组
	public static <T> T array(T[] args) {
		return args[args.length - 1];
	}
	
	//测试两个参数
	public static <T, S> T both(T a,S b){
		System.out.println("both:"+a+" AND "+b);	
		return a;
	}
	
	//可变长参数,params是一个数组，但是长度不定，可以随意写参数个数
	public static <S> void longParm(S... params){
		for(S e:params){
			System.out.print(e+"\t");
		}	
		System.out.println();
	}
	
	//可使用的参数类型的范围为  T和任何从T继承的S
	public static <T,S extends T> S extend(T t,S s){
		return s;		
	}
	

}

class Store<E>{
	private List<E> list;	
	
	Store(){
		this.list=new ArrayList<E>();
	}
	
	public void add(E e){
		this.list.add(e);
	}
	
	public void removeByIndex(int index){
		this.list.remove(index);
	}
	
	public E getByIndex(int index){
		return this.list.get(index);
		
	}
	public void change(E e,int index){
		this.list.set(index, e);		
	}
	
}

class Store2 extends Store{
	
}

