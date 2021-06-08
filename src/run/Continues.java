package run;

/**
 * Created by Administrator on 2016/12/3.
 */
public class Continues {
    public static void main(String args[]) {
        int index;
        for (index = 0; index < 10; index++) {
            if (index % 2 != 0) {
                continue;
            }
            System.out.println(index);
        }
        System.out.println("final:"+index);

    }

}
