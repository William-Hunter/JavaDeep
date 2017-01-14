package datastructure;

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
                    map.setter(Integer.valueOf(piece[0]),piece[1]);
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
                        System.out.print("删除成功\t");
                    }else{
                        System.out.print("删除失败\t");
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

    Object getter(int key) {
        int remainder=key%MOD;
        Map node=hasharray[remainder];
        while(node!=null){
            if (node.key==key){
                return node;
            }else{
                node=node.next;
            }
        }
        return null;
    }

    void setter(int key, Object value) {
        int remainder=key%MOD;
        if(hasharray[remainder]==null){
            hasharray[remainder]=new Map();
            hasharray[remainder].key=key;
            hasharray[remainder].value=value;
        }else{
            Map node = new Map();
            node.key = key;
            node.value = value;
            node.next = hasharray[remainder];
            hasharray[remainder] = node;
        }
    }

    boolean remove(int key) {
        int remainder=key%MOD;
        Map node=hasharray[remainder];
        Map prev=null;
        while(node!=null){
            if(node.key==key){
                if(prev==null){
                    hasharray[remainder]=node.next;
                }else{
                    prev.next=node.next;
                }
                return true;
            }else{
                prev=node;
                node=node.next;
            }
        }
        return false;
    }

    HashMap(){
        hasharray=new Map[13];
    }
}

class Map{
    int key;
    Object value;
    Map next;
}