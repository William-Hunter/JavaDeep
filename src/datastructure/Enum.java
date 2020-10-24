package datastructure;

/**
 * Created by Administrator on 2018/10/2.
 */
public class Enum {
    static public void main(String[] args){
        MediaType more=MediaType.get("hehehe");
        for (MediaType e:MediaType.values()) {
            System.out.println(e);
        }



    }


}
