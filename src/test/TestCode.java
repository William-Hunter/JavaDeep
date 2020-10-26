package test;

/**
 * Created by Administrator on 2017/1/17.
 */
public class TestCode {
    public static void main(String[] args){
//        for(int index=0;index<10;System.out.println(index),index++){
//            if(index==7){
//                continue;
//            }
//        }
//        This a=new This();
//        a.print("done");
//        Super b=new Super("fans running");
//        b.printf();

        System.out.println("=================");
        Super entity=new Super("ddd"){
            @Override
            public void function() {
                System.out.println("function is override....");
                printf();
            }
        };
        entity.function();


    }
}
