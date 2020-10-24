import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/2.
 */
public class ShortCut {

    public final String id;
    public final String name;


    public ShortCut(String id, String name) {
        this.id = id;
        this.name=name;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(new Date());
        ShortCut sh=new ShortCut("1", "zhangsan");
        ShortCut sh2=new ShortCut("2", "lisi");
        System.out.println(sh.id);
        System.out.println(sh2.id);
        if (sh != null) {
            System.out.println("不为空就好");
        }
        File file=new File("");
        InputStream is=new FileInputStream(file);
    }
}
