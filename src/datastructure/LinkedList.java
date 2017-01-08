package datastructure;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/1/3.
 */
public class LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node();
        head.value = "shit";

        boolean retu = false;
        while (!retu) {
            String word = "1:显示list\n2:增加一个元素\n3:删除一个元素\n4:修改一个元素\n5:退出\n";
            System.out.print(word);
            String[] piece = null;
            retu = false;
            switch (sc.nextLine()) {
                case "1":
                    list(head);
                    break;
                case "2":
                    System.out.print("请输入序号和内容，以英文逗号隔开\n");
                    piece = sc.nextLine().split(",");
                    head = add(head, Integer.valueOf(piece[0]), piece[1]);
                    System.out.println("----------------------------------------");
                    break;
                case "3":
                    System.out.print("请输入序号和内容\n");
                    delete(head, Integer.valueOf(sc.nextLine()));
                    System.out.println("----------------------------------------");
                    break;
                case "4":
                    System.out.print("请输入序号和内容，以英文逗号隔开\n");
                    piece = sc.nextLine().split(",");
                    update(head, Integer.valueOf(piece[0]), piece[1]);
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

    public static Node add(Node head, int index, String value) {
        Node current = head;
        for (int count = 0; count < index - 2; count++) {
            current = current.next;
        }
        Node ne = new Node();
        ne.value = value;
        if (index == 1) {
            ne.next = head;
            head = ne;
        } else {
            ne.next = current.next;
            current.next = ne;
        }
        return head;
    }

    public static Node delete(Node head, int index) {
        for (int count = 0; count < index - 1; count++) {

        }

        return head;
    }

    public static void update(Node node, int index, String value) {

    }

    public static void list(Node node) {
        if (node != null) {
            System.out.println(node.value + "\t");
            list(node.next);
        }
    }

}

class Node {
    public String value;
    public Node next;
}


