package Java;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Desc:
 * Author: Yehu
 * Created by kachesiji on 2016/5/31.
 */
public class DateDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(2016, 3 , 30);
        Date date =calendar.getTime();
        System.out.println(date.toString());
        System.out.println(year + "年" + month + "月" + day + "日");
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(myFmt.format(date));
        System.out.println("****************************************");

////        calendar.setTime(date);
//        year = calendar.get(Calendar.YEAR);
//        month = calendar.get(Calendar.MONTH) + 1;
//        day = calendar.get(Calendar.DAY_OF_MONTH);
//        date = calendar.getTime();
//        System.out.println(date.toString());
//        System.out.println(year + "年" + month + "月" + day + "日");
//        System.out.println(date.getYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日");
        BigInteger big = new BigInteger("999999999999999999999999999");
        System.out.println(big);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println((Long.MAX_VALUE+"").length());

    }
}
