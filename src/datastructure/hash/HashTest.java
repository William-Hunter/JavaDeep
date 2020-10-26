package datastructure.hash;

import datastructure.list.LinkedList;
import datastructure.list.Node;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/1/3.
 */
public class HashTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTable hashtable = new HashTable();
        boolean retu = false;
        while (!retu) {
            String word = "1:显示所有\n2:增加一个数字\n3:删除一个数字\n4:修改一个数字\n5:退出\n";
            System.out.print(word);
            String[] piece = null;
            retu = false;
            switch (sc.nextLine()) {
                case "1":
                    hashtable.list();
                    break;
                case "2":
                    System.out.print("请输入数字：\t");
                    hashtable.add(Integer.valueOf(sc.nextLine()));
                    System.out.println("----------------------------------------");
                    break;
                case "3":
                    System.out.print("请输入数字：\t");
                    hashtable.delete(Integer.valueOf(sc.nextLine()));
                    System.out.println("----------------------------------------");
                    break;
                case "4":
                    System.out.print("请输入原数字和现数字，以英文逗号隔开\t");
                    piece = sc.nextLine().split(",");
                    hashtable.update(Integer.valueOf(piece[0]), Integer.valueOf(piece[1]));
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
}
class HashTable {
    Node[] hasharray;
    static final int MOD = 13;
    HashTable() {
        hasharray = new Node[13];
    }                   //固定散列地址
    public void update(int originally, int afterward) {         //修改数字，
        delete( originally);                                    //先删除，再添加
        add( afterward);
    }
    public void delete( Integer number) {                       //从hash表里面删除一个数字
        int remainder = number % MOD;                           //计算散列地址
        Node current = hasharray[remainder];
        Node previous = null;
        while (current!=null) {                                 //循环链表
            if (current.value.equals(number)) {                 //判断当前节点是否为所要寻找的
                if (previous == null) {                         //如果是头节点，
                    hasharray[remainder] = current.next;        //跳过这个节点即可
                } else {
                    previous.next = current.next;
                }
                break;
            } else {
                previous = current;                              //继续循环
                current = current.next;
            }
        }
    }
    public void add(int number) {                   //添加一个数字到哈希表
        int remainder = number % MOD;                   //计算散列值
        if (hasharray[remainder] == null) {             //如果没有头
            hasharray[remainder] = new Node();          //就添加到头上去
            hasharray[remainder].value = number;
        } else {                                        //否则添加到后面去
            hasharray[remainder] = LinkedList.add(hasharray[remainder], 1, number);
        }
    }
    public void list() {
        for (Node e : hasharray) {
            LinkedList.list(e);
            System.out.println();
        }
        System.out.println();
    }
}

