import java.time.ZonedDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: JolyouLu
 * @Date: 2021/12/19 13:08
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        String str = "cloud123123";
        Pattern pattern = Pattern.compile("cloud\\w*");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            System.out.println(matcher.group());
        }else {
            System.out.println("未匹配");
        }

    }
}
