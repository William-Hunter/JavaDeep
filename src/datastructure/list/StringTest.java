package datastructure.list;

/**
 * Created by Administrator on 2017/1/6.
 */

public class StringTest {

    public static void main(java.lang.String[] args){
        StringNode point=new StringNode();
//        if(assign(point,"hello".toCharArray())){
//            System.out.println(point.array);
//            System.out.println(getLength(point));
//        }
//        point=null;
//        if(concat(point,"hello,".toCharArray(),"world".toCharArray())){
//            System.out.println(point.array);
//            System.out.println(getLength(point));
//        }
        StringNode whole=new StringNode();
        StringNode subs=new StringNode();
        if(assign(whole,"hello,world".toCharArray())&&assign(subs,"world".toCharArray())){
            subString(whole,subs);
        }

    }

    public static boolean assign(StringNode string,char[] array){
        try {
            string.array=new char[array.length];
            int index=0;
            while(index<array.length){
                string.array[index]=array[index];
                index++;
            }
            string.length=index;
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static int getLength(StringNode string){
        return string.length;
    }

    public static boolean concat(StringNode string,char[] s1,char[] s2){
        try{
            string.length=0;
            string.array=new char[s1.length+s2.length];
            int index=0;
            while(index<s1.length){
                string.array[index]=s1[index];
                index++;
            }
            string.length+=index;
            index=0;
            while(index<s2.length){
                string.array[string.length+index]=s2[index];
                index++;
            }
            string.length+=index;
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean subString(StringNode whole,StringNode subs){
        for(int index=0;index<=(whole.length-subs.length);index++){         //没必要读到最后一个,长度不够了肯定不匹配,而且可以预付下标越界
//            System.out.println(whole.array[index]+"=="+subs.array[0]);
            if(whole.array[index]==subs.array[0]){
                int compareValue=0;
                for(int count=1;count<subs.length;count++){     //从模式串的第二个开始比较
//                    System.out.println(whole.array[index+count]+"=="+subs.array[count]);
                    if (whole.array[index+count]==subs.array[count]){
                        compareValue++;
                    }else{
                        break;      //如果有一个不匹配，那么就没必要继续比对了。
                    }
                }
                if(compareValue==subs.length-1){
                    System.out.println("的确有子串");
                    return true;
                }
            }
        }
        System.out.println("没有子串");
        return false;
    }

}

class StringNode{
    char[] array;
    int length;
}
