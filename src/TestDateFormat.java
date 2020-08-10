import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
    public static void main(String[] args) throws ParseException {
        //日期按照指定格式转为字符串
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //定义转化格式
        System.out.println(df.format(new Date())); //转化日期对象
        //字符串按照指定格式转为日期
        System.out.println(df.parse("1992-5-1 20:00:00"));

        DateFormat df1 = new SimpleDateFormat("D"); //定义转化格式
        System.out.println(df1.format(new Date()));
    }
}
