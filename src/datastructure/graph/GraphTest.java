package datastructure.graph;

import java.util.Scanner;
import datastructure.list.*;

/**
 * Created by Administrator on 2017/1/8.
 * 目前只处理有向图
 */
public class GraphTest {

    public static void main(String[] args) {
        Node[] vertexs=null;
        vertexs=createAdjacencyList(vertexs);
        show(vertexs);
        traversal(vertexs);
        System.out.println("=========END==========");
    }

    public static void traversal(Node[] vertexs){
        System.out.println("display");
        display(vertexs,vertexs[0]);
    }

    public static void display(Node[] vertexs,Node node){
        String vec=getQueue(node);
        while(vec!=null){
            int vector=Integer.valueOf(vec);
            System.out.println(node.value+"----->"+vertexs[vector].value);
            display(vertexs,vertexs[vector]);
            vec=getQueue(node);
        }
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
            String line=sc.nextLine();
            if (line.isEmpty()){
                break;
            }
            String[] context = line.split(",");
            for (int count = 0; count < context.length; count++) {         //循环输入的节点
                String value=null;
                for(int order=0;order<vertexs.length;order++){
                    if (vertexs[order].value.equals(context[count])) {
                        value=String.valueOf(order);
                        break;
                    }
                }
                vertexs[index].next=LinkedList.add(vertexs[index].next, 1, value);
            }
        }
        return vertexs;
    }

    public static void show(Node[] vertexs){
        for(int index=0;index<vertexs.length;index++){
            System.out.print(vertexs[index].value+":");
            LinkedList.list(vertexs[index].next);
            System.out.println();
        }
    }

    public static String getQueue(Node head){
        String retu=LinkedList.get(head,2).toString();
        if(retu!=null&&LinkedList.delete(head,2)){
            return retu;
        }else{
            return null;
        }
    }
}
