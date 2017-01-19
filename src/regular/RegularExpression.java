package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/1/19.
 */
public class RegularExpression {
    public static void main(String[] args){
        // 按指定模式在字符串查找
        String line = "This order was placed for QT\t30004481! OK?";
        String pattern = "\t+[0-9]*";
/**
 * 对于zo来说，
 * +会匹配zo开头的所有情况，
 * *会匹配包含z或o或zo任意一种情况，例如z,zo,zoo
 */
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        //循环出所有匹配的
        while(m.find()){
            if(!m.group().isEmpty()){
                System.out.print(m.group()+"\n");
            }
        }
        System.out.println("\nEND");

    }
}
