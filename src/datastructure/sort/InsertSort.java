package datastructure.sort;

import datastructure.list.Node;

public class InsertSort {
    static int[] array={71,22,53,84,91,83,39,65,44};
    public static void main(String[] args) {
        Node<Integer> head=null;
        for(int e:array) {
            System.out.print(e+":\t");
            head=sort(head, e);
        }
        System.out.print("\n==========================\n");
        while(head!=null){
            System.out.print(head.value+"\t");
            head=head.next;
        }
    }
    static Node<Integer> sort(Node<Integer> head,int number){
        if(head==null){                             //如果头为空的话，那么就是没有链表
            head=new Node<Integer>();
            head.value=number;
            return head;
        }
        Node<Integer> current=head;
        Node<Integer> prev=null;
        while(current!=null){                       //循环已有的链表
            if(number<current.value){                 //如果传入的数字小于当前节点值，就插入到当前节点前面
                Node<Integer> ne=new Node<Integer>();         //创建新节点，
                ne.value=number;
                if(prev==null){                         //如果当前节点是头节点，前面没有节点，就把新节点放在前面，然后head指向新节点。
                    ne.next=current;
                    head=ne;
                }else{                                  //插入到当前节点前面
                    prev.next=ne;
                    ne.next=current;
                }
                return head;                            //返回head，插入之后就结束函数
            }else{                                    //如果传入的数字小于当前节点值，就插入到当前节点后面，
                prev=current;                           //先向后面走
                current=current.next;               System.out.println("do...");
            }
        }
        prev.next=new Node<Integer>();              //如果能循环完的话，说明一直都是大于，所以插入在尾部。
        prev.next.value=number;
        return head;
    }
}