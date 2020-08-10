import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestCanlendar {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = new GregorianCalendar(2999,10,1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.set(2019,1,0);
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.add(Calendar.YEAR,1);
        System.out.println(calendar.get(Calendar.YEAR));
        //日期和日历对象的转化
        Date d = new Date();
        calendar.setTime(d);
        printCalendar(calendar);
        System.out.println("请输入日期，格式(2020-1-1)");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        printCalendarByString(date);

    }
    public static void printCalendar(Calendar calendar){
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;//月份从0开始，需要+1
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)-1;//1-7 1周日 2周一 变为 0是周日，1是周一
        String stringDayOfWeek = dayOfWeek == 0?"日":dayOfWeek+"";
        System.out.println(year + "年" + month + "月" + dayOfMonth + "日" + " 周" + stringDayOfWeek);
    }
    public static void printCalendarByString(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = df.parse(date);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date1);
        int currentDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        calendar.set(Calendar.DAY_OF_MONTH,1);//从1号开始打印
        for (int i = 1;i<calendar.get(Calendar.DAY_OF_WEEK);i++){//之所以是小于，是因为要留一个1号的位置
            System.out.print("\t");
        }
        int maxDayOfMonth = calendar.getActualMaximum(Calendar.DATE);
        for (int i =1;i<= maxDayOfMonth;i++){//本月的日期最大值
            System.out.print(calendar.get(Calendar.DAY_OF_MONTH));
            if (calendar.get(Calendar.DAY_OF_MONTH) == currentDayOfMonth){
                System.out.print("*");
            }
            System.out.print("\t");
            if (calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
                System.out.println();//周六换行
            }
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
    }
}
