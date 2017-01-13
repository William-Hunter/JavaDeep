package datastructure;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/1/3.
 */
public class HashTest {
    static final int MOD=13;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashTable hashtable=new HashTable();
        boolean retu = false;
        while (!retu) {
            String word = "1:显示所有\n2:增加一个数字\n3:删除一个数字\n4:修改一个数字\n5:退出\n";
            System.out.print(word);
            String[] piece = null;
            retu = false;
            switch (sc.nextLine()) {
                case "1":
                    list(hashtable);
                    break;
                case "2":
                    System.out.print("请输入数字：\t");
                    hashtable = add(hashtable, Integer.valueOf(sc.nextLine()));
                    System.out.println("----------------------------------------");
                    break;
                case "3":
                    System.out.print("请输入数字：\t");
                    delete(hashtable, Integer.valueOf(sc.nextLine()));
                    System.out.println("----------------------------------------");
                    break;
                case "4":
                    System.out.print("请输入原数字和现数字，以英文逗号隔开\t");
                    piece = sc.nextLine().split(",");
                    hashtable=update(hashtable, Integer.valueOf(piece[0]), Integer.valueOf(piece[1]));
                    System.out.println("----------------------------------------");
                    break;
                case "5":
                    retu = true;
                    break;
                default:
                    System.out.println("不识别的内容");
                    break;
            }
        }
        System.out.println("Bye Bye");
    }

    static HashTable update(HashTable hashtable, int originally, int afterward) {
        delete(hashtable,originally);
        hashtable=add(hashtable,afterward);
        return hashtable;
    }

    private static void delete(HashTable hashtable, Integer number) {
        int remainder=number%MOD;
        Node current=hashtable.hasharray[remainder];
        Node previous = null;
        while(true){
            if(current.value.equals(number)){
                System.out.println("找到了");
                if (previous==null){
                    hashtable.hasharray[remainder]=current.next;        //第一个
                }else {
                    previous.next=current.next;                         //其后的
                }
                break;
            }else{
                previous=current;                                       //继续循环
                current=current.next;
                System.out.println("do...");
            }
        }
    }

    static HashTable add(HashTable hashtable,int number){
        int remainder=number%MOD;
        if(hashtable.hasharray[remainder]==null){
            hashtable.hasharray[remainder]=new Node();
            hashtable.hasharray[remainder].value=number;
        }else{
            hashtable.hasharray[remainder]=LinkedList.add(hashtable.hasharray[remainder],1,number);
        }
        return hashtable;
    }

    static void list(HashTable hashtable){
        for (Node e:hashtable.hasharray) {
            LinkedList.list(e);
            System.out.println();
        }
        System.out.println();
    }
}

class HashTable{
    Node[] hasharray;

    HashTable(){
        hasharray=new Node[13];


    }
}

