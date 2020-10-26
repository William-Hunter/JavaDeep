package datastructure.list;

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
    /**
     * index从1开始
     */
    public static Node add(Node head, int index, Object value) {
        Node current = head;
        for (int count = 1; count < index - 1; count++) {
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
    /**
     * index从1开始
     */
    public static boolean delete(Node head, int index) {
        try {
            Node previous = null;
            Node current = head;
            for (int count = 1; count < index; count++) {
                previous = current;
                current = current.next;
            }
            if (index == 1) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
            return true;
        } catch (NullPointerException e) {
//            e.printStackTrace();
            return false;
        }
    }
    public static boolean update(Node head, int index, Object value) {
        try {
            Node current = head;
            for (int count = 1; count < index; count++) {
                current = current.next;
            }
            current.value = value;
            return true;
        } catch (NullPointerException e) {
//            e.printStackTrace();
            return false;
        }
    }
    public static Object get(Node head, int index) {
        try {
            Node current = head;
            for (int count = 1; count < index; count++) {
                current = current.next;
            }
            return current.value;
        } catch (NullPointerException e) {
//            e.printStackTrace();
            return null;
        }
    }
    public static void list(Node node) {
        if (node != null) {
            System.out.print(node.value.toString() + "\t");
            list(node.next);
        }
    }
}




