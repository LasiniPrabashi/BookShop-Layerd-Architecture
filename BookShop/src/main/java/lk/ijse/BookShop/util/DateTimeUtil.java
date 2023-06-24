package lk.ijse.BookShop.util;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;

public class DateTimeUtil {

    public static String dateNow(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
       return format.format(new Date());
    }

    public static String timeNow(){
        SimpleDateFormat format=new SimpleDateFormat("hh:mm:ss");
        return format.format(new Date());
    }
    public static int getDays(int year, int month) {
        YearMonth yearMonthObject = YearMonth.of(year, month);
        return yearMonthObject.lengthOfMonth();
}
}
