package datastructure;

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
    }

    public void update(int originally, int afterward) {
        delete( originally);
        add( afterward);
    }

    public void delete( Integer number) {
        int remainder = number % MOD;
        Node current = hasharray[remainder];
        Node previous = null;
        while (current!=null) {
            if (current.value.equals(number)) {
                if (previous == null) {
                    hasharray[remainder] = current.next;        //第一个
                } else {
                    previous.next = current.next;                         //其后的
                }
                break;
            } else {
                previous = current;                                       //继续循环
                current = current.next;
            }
        }
    }

    public void add(int number) {
        int remainder = number % MOD;
        if (hasharray[remainder] == null) {
            hasharray[remainder] = new Node();
            hasharray[remainder].value = number;
        } else {
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

