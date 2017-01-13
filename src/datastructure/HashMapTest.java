package datastructure;

/**
 * Created by Administrator on 2017/1/13.
 * 尝试理解用hash实现的map，键值对存储方式，
 */
public class HashMapTest {

    static void main(String[] args) {


    }

}

class Map{
    int key;
    Object value;
    HashTable next;
}

class HashMap {
    Map[] hasharray;

    HashMap(){
        hasharray=new Map[13];
    }
    void setter(int key, Object value) {

    }

    Object getter(int key) {

        return null;
    }

    boolean remove(int key) {

        return false;
    }
}
