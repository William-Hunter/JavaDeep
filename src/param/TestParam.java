package param;

/**
 * Created by Administrator on 2016/11/30.
 */
public class TestParam {
    public static void main(String[] args) {
        Example example = new Example();

        example.value = 100;
        System.out.println("BEFORE:" + example.value);
        changeValue(example.value);
        System.out.println("AFTER:" + example.value);
        System.out.println("---------------------------------------------------------------");
        example.value = 100;
        System.out.println("BEFORE:" + example.value);
        changeRef(example);
        System.out.println("AFTER:" + example.value);
    }


    public static void changeRef(Example example) {
        example.value = 3;
    }

    public static void changeValue(int value) {
        value = 33;
    }
}
