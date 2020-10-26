package datastructure.sort;

/**
 * Created by Administrator on 2017/1/17.
 */
public class SelectionSort {
    static int[] array={71,22,53,84,91,84,39,65};
    public static void main(String[] args){
        list();
        for(int index=0;index<array.length-1;index++){
            exchange(getMinIndex(index,array.length-1),index);
        }
        list();
    }
    public static int getMinIndex(int start,int end){
        int minIndex=start;
        for(int index=start+1;index<=end;index++){
            if (array[minIndex]>array[index]){
                minIndex=index;
            }
        }
        return minIndex;
    }
    static void exchange(int index1,int index2){

        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }
    static void list(){
        for(int index=0;index<array.length-1;index++){
            System.out.print(index+":"+array[index]+"\t");
        }
        System.out.println();
    }
}
