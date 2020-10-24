package datastructure;

/**
 * Created by Administrator on 2018/10/2.
 */
public enum MediaType {
    MUSIC("lalala"), VEDIO("dididi"),UNKNOWN("UNKNOWN");

    String code;

    MediaType(String code) {
        this.code = code;
    }



    public static MediaType get(String str) {
        System.out.println("str=" + str);
        try {
            System.out.println("valueOf(str)=" + valueOf(str));
            return valueOf(str);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("....");
            return UNKNOWN;
        }
    }


}
