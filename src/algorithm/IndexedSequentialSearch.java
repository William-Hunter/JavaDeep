package algorithm;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/1/10.
 */
public class IndexedSequentialSearch {
    private static int[] array;
    static final int SET = 4;
    static Index[] table;

    public static void main(String[] args) {
        create();
        list();
        order();
        list();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n请输入你想查找的数字:");
        int number = Integer.valueOf(sc.nextLine());
        find(number);
    }

    /**
     * 创建数组以供使用，索引表的key是关键字，groupIndex是每个关键字所在的分组号
     */
    static void create() {
        array = new int[]{10, 82, 15, 19, 42, 44, 47, 34, 51, 60, 52, 54, 69, 72, 80, 22};
        table = new Index[array.length / SET];
        for (int count = 0,point=0; count < table.length; count ++,point+=4) {
            table[count]=new Index();
            table[count].groupIndex = count*4;
            table[count].key = getMax(array, point, point + SET - 1);

        }
    }

    static void list() {
        for (Index e:table) {
            System.out.print(e.key + ":" + e.groupIndex + "\t");
        }
        System.out.println();
        for(int e:array){
            System.out.print(e+"\t");
        }
        System.out.println();
    }

    /**
     * 对索引表进行排序
     */
    static void order() {
        for (int count = table.length - 2; count > 0; count--) {
            for (int hoiz = 0; hoiz <= count; hoiz++) {
                if (table[hoiz].key > table[hoiz + 1].key) {
                    Index swap = new Index();
                    swap.key=table[hoiz].key;
                    swap.groupIndex=table[hoiz].groupIndex;
                    table[hoiz].key=table[hoiz+1].key;
                    table[hoiz].groupIndex=table[hoiz+1].groupIndex;
                    table[hoiz+1].key=swap.key;
                    table[hoiz+1].groupIndex=swap.groupIndex;
                }
            }
        }
    }

    /**
     *查找数字
     */
    static void find(int number) {
        for(int count=0;count<table.length;count++){
            if(number<=table[count].key){
                System.out.println("******"+count);
                findSub(number,table[count].groupIndex,table[count].groupIndex+3);
                break;
            }else {
                continue;
            }
        }
    }

    /**
     *在区块里查找
     * @param number 要查找的数字;
     * @param head 分组的开头
     * @param rear 分组的结尾
     */
    static void findSub(int number,int head,int rear) {
        for(int count=0;count<=rear;count++){
            if(number==array[count]){
                System.out.println("查找到字符，它的下标是:"+count);
            }
        }
    }

    /**
     * 获取区块里的最大值
     * @param array 要操作的数组
     * @param head 分组的开头
     * @param rear 分组的结尾
     * */
    static int getMax(int[] array, int head, int rear) {
        int max = array[head];
        for (int index = head; index <= rear; index++) {
            if (array[index] > max) {
                max = array[index];
            }
        }
        return max;
    }
}

class Index {
    int key;
    int groupIndex;
}