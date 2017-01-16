package datastructure.tree;

import static datastructure.tree.BinarySortTree.index;

/**
 * Created by Administrator on 2017/1/15.
 */
public class BinarySortTree {
    static int index=0;
    public static void main(String[] args) {
        Work worker = new Work();
        Point<Integer> head = null;
        int[] array = {58, 13, 65, 42, 61, 88, 3, 76, 92};
        head = worker.create(head, array);
        int[] newarray = worker.sort(head);
        for (int e:newarray) {
            System.out.print(e+"\t");
        }
    }
}

class Work {
    int size;

    int[] sort(Point head) {
        int[] array = new int[size];
        get(head,array);
        return array;
    }
    void get(Point node,int[] array){
        if(node!=null){
            get(node.left,array);               //左子树优先
            array[index]=(int)node.value;
            index++;
            get(node.right,array);
        }
    }

    Work() {
        this.size = 0;
    }

    Point create(Point head, int[] array) {
        for (int e : array) {
            head = put(head, e, 1);
            this.size++;
            System.out.println("size:"+this.size);
        }
        return head;
    }

    Point put(Point<Integer> current, int value, int level) {
        if (current == null) {
            current = new Point<Integer>();
            current.value = value;
            System.out.print("value:"+value+"\tlevel:"+level+"\n");
        } else if (value < (int) current.value) {
            System.out.print("left\t");
            current.left = put(current.left, value, level + 1);
        } else {
            System.out.print("right\t");
            current.right = put(current.right, value, level + 1);
        }
        return current;
    }
}

