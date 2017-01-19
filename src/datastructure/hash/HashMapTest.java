package datastructure.hash;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/1/13.
 * 尝试理解用hash实现的map，键值对存储方式，
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap map=new HashMap();
        Scanner sc = new Scanner(System.in);
        boolean retu = false;
        while (!retu) {
            String word = "1:增加&覆盖\t2:查找\t3:删除\t4:显示所有\t5:退出\n";
            System.out.print(word);
            String[] piece = null;
            retu = false;
            switch (sc.nextLine()) {
                case "1":
                    System.out.print("请输入key,value：\t");
                    piece=sc.nextLine().split(",");
                    int key=Integer.valueOf(piece[0]);
                    map.remove(key);
                    map.setter(key,piece[1]);
                    System.out.println("----------------------------------------");
                    break;
                case "2":
                    System.out.print("请输入key：\t");
                    Map result= (Map) map.getter(Integer.valueOf(sc.nextLine()));
                    if(result!=null){
                        System.out.println("查找结果:"+result.value);
                    }else{
                        System.out.println("没有结果");
                    }
                    System.out.println("----------------------------------------");
                    break;
                case "3":
                    System.out.print("请输入key：\t");
                    if(map.remove(Integer.valueOf(sc.nextLine()))){
                        System.out.print("删除成功\n");
                    }else{
                        System.out.print("删除失败\n");
                    }
                    System.out.println("----------------------------------------");
                    break;
                case "4":
                    map.list();
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
class HashMap {
    Map[] hasharray;
    final int MOD=13;
    void list(){
        for(Map node:hasharray){
            while(node!=null){
                System.out.print("key:"+node.key+" value:"+node.value+"\t");
                node=node.next;
            }
            System.out.println();
        }
    }
    Object getter(int key) {                //根据key获取元素，
        int remainder=key%MOD;              //算出散列的地址之后
        Map node=hasharray[remainder];
        while(node!=null){                  //循环链表
            if (node.key==key){             //找到key对应的元素
                return node;
            }else{
                node=node.next;
            }
        }
        return null;
    }
    void setter(int key, Object value) {        //存储键值对
        int remainder=key%MOD;                  //计算散列地址
        Map node = new Map();                   //新建节点
        node.key = key;
        node.value = value;
        if(hasharray[remainder]==null){         //如果数组这个地址的元素（链表的第一个元素）是空，那么就新元素存进去
            hasharray[remainder]=node;
//            hasharray[remainder]=new Map();
//            hasharray[remainder].key=key;
//            hasharray[remainder].value=value;
        }else{                                  //否则将新节点存在后面
            node.next = hasharray[remainder];
            hasharray[remainder] = node;
        }
    }
    boolean remove(int key) {                       //根据key移除链表节点
        int remainder=key%MOD;                      //根据key计算散列地址
        Map node=hasharray[remainder];              //获取当前的数组的链表头
        Map prev=null;                              //存储上一个节点的引用
        while(node!=null){                          //循环这个数组的链表
            if(node.key==key){                      //如果key是一致
                if(prev==null){                         //如果当前节点是头节点
                    hasharray[remainder]=node.next;     //直接把当前跳过去
                }else{                                  //否则前节点吧当前节点跳过去
                    prev.next=node.next;
                }
                return true;                            //然后返回true，结束过程
            }else{                                  //否则继续循环
                prev=node;
                node=node.next;
            }
        }
        return false;
    }
    HashMap(){
        hasharray=new Map[13];
    }           //固定hash有13个地址
}
class Map{
    int key;
    Object value;
    Map next;
}