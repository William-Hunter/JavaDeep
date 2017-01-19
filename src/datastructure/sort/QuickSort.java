package datastructure.sort;

/**
 * Created by Administrator on 2017/1/17.
 */
public class QuickSort {
    static int[] array={71,22,5,34,57,84,95,51,81,100,58,39,65};
    public static void main(String[] args){
        list(0,array.length-1);
        sort(0,array.length-1);
        list(0,array.length-1);
    }
    static void list(int start,int end){
        for(int index=start;index<=end;index++){
            System.out.print(index+":"+array[index]+"\t");
        }
        System.out.print("\n");
    }
    public static void sort(int head,int rear){                         //如果开头减去结尾，小于1，说明不能再循环了
        if(rear-head<1){
//            System.out.print("XXXXXXXXXXXXXXXX\n");
            return;
        }
//        list(head,rear);
        int mediu=(head+rear)/2;                                        //计算中间点
//        System.out.println(head+"-"+rear+"\tmediu:"+mediu);
        for(int index=head;index<mediu;index++){                        //循环从头到中间节点
//            System.out.print("index:"+index+"  left  jump  \n");
            if(array[index]>array[mediu]){
//                System.out.print("index:"+index+"\tvalue:"+array[index]+" aaa\n");
                moveToRight(rear,index);                                //移动左侧的元素到右侧
                mediu--;                                                //当数组移动后，中间节点改变了，所以要修改下标
                index--;
//                System.out.print("mediu:"+mediu+" AAA\n");
                list(head,rear);
            }
        }
        for(int index=rear;index>mediu;index--){                        //循环从尾到中间节点
//            System.out.print("index:"+index+"  right  jump  \n");
            if(array[mediu]>array[index]){
//                System.out.print("move:"+index+"\tvalue:"+array[index]+" bbb\n");
                moveToLeft(head,index);
                mediu++;
                index++;
//                System.out.print("mediu:"+mediu+" BBB\n");
                list(head,rear);
            }
        }
//        System.out.print("OOOOOOOOOOOOOOOO\n");
        sort(head,mediu-1);
        sort(mediu+1,rear);
    }
    public static void moveToRight(int boundary,int index){
        int temp=array[index];
        for(int count=index;count<boundary;count++){
            array[count]=array[count+1];
        }
        array[boundary]=temp;
    }
    public static void moveToLeft(int boundary,int index){
        int temp=array[index];
        for(int count=index;count>boundary;count--){
            array[count]=array[count-1];
        }
        array[boundary]=temp;
    }
}
