package algorithm.floydsTortoiseAndHare;

public class Main {

    static public Node createCycle(int length,boolean loop) {
        Node head = null, current = null, last = null;
        for (int index = 1; index <= length; index++) {
            current = new Node(index + "");
            if (1 == index) {           //第一个元素
                head = current;
            }else if(index==length && loop){    //最后一个元素
                last.setNext(current);//下一个关联上
                current.setNext(head);
            } else {
                last.setNext(current);//下一个关联上
            }
            last    = current;
            current = null;
        }
        return head;
    }


    /**
     * 递归式写法
     * @param length
     */
    static public Node createCycleR(int length) {
        Node point=null;
        if(length>0){
            point=new Node(length+"");
            point.setNext(createCycleR(--length));
        }
        return point;
    }


    static public void printLinked(Node point) {
        if (null != point) {
            System.out.println(point.getValue());
            printLinked(point.getNext());
        }
    }


    static public void modifyValue(Node point, int index, String value, int level) {
        if (null != point) {
            if (index == level) {
                point.setValue(value);
            }
            modifyValue(point.getNext(), index, value, ++level);
        }
    }


    static public Node moveToNextNode(Node current,int step){
        for(int index=1;index<=step;index++){
            if(null!=current){
                current=current.getNext();
            }
        }
        return current;
    }

    static public Boolean judgmentIsLoop(Node head,int hareSpeed,int tortoiseSpeed){
        Boolean result=false;
        Node hare=head,tortoise=head;
        int count=1,step=1;
//        hare=moveToNextNode(hare,1);
        while(true){
            tortoise=moveToNextNode(tortoise,tortoiseSpeed);
            hare=moveToNextNode(hare,hareSpeed);

            System.out.println("tortoise:"+tortoise.getValue());
            System.out.println("hare:"+hare.getValue());
            System.out.println(String.format("-------------这是第%s次走步---------------------",step++));

            if(tortoise==hare){
                System.out.println("兔子和乌龟在同一个节点，抓住了");
                result=true;
                break;
            }else if(tortoise==head){
                System.out.println("乌龟转了一圈了");
                if((count--)<=0){
                    System.out.println("转得圈数太多，结束了");
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Node head =null;
        boolean loop=true;
        head = createCycle(37,loop);
//        head=createCycleR(8);

//        if(!loop)printLinked(head);
//        modifyValue(head, 5, "3", 1);
//        if(!loop)printLinked(head);
        if(judgmentIsLoop(head,3,1)){
            System.out.println("这是一个环");
        }else{
            System.out.println("这不是一个环");
        };
        System.out.println();
    }


}
