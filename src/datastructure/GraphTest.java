package datastructure;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/1/8.
 * 有向图
 */
public class GraphTest {

    public static void main(String[] args) {
        Node[] vertexs=null;
        vertexs=createAdjacencyList(vertexs);
        System.out.println("=========END==========");
    }

    public static Node[] createAdjacencyList(Node[] vertexs) {
        System.out.println("请输入节点，请以英文逗号分隔");
        Scanner sc = new Scanner(System.in);
        String[] points = sc.nextLine().split(",");
        vertexs = new Node[points.length];
        for (int index = 0; index < points.length; index++) {   //循环输入的节点
            vertexs[index]=new Node();
            vertexs[index].value = points[index];
            vertexs[index].next =null;
        }
        for (int index = 0; index < vertexs.length; index++) {
            System.out.println("请输入节点" + vertexs[index].value + "的去向，请以英文逗号分隔");
            String[] context = sc.nextLine().split(",");
            for (int count = 0; count < context.length; count++) {         //循环输入的节点
                String value="";
                for(int order=0;order<vertexs.length;order++){
                    if (vertexs[order].value.equals(context[count])) {
                        value=order+"";
                        break;
                    }
                }
                vertexs[index].next=LinkedList.add(vertexs[index].next, 1, value + "");
            }
            LinkedList.list(vertexs[index].next);
        }
        System.out.println("创建完毕");
        return vertexs;
    }


}

class Vertex {


}