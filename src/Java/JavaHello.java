package Java;

import com.trucker.sdk.TKUser;
import sun.util.resources.CalendarData_el;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kachesiji on 2016/5/17.
 */
public class JavaHello {
    static class Student {
        Student(String name) {
            this.name = name;
        }
        String name;
    }

    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        String timeStamp = "1473864497678";
        Date date =new Date(Long.parseLong(timeStamp));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.setTime(date);
        String[] weeks = {"日","一","二","三","四","五","六"};
        String week ="";
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                week = weeks[0];
                break;
            case Calendar.MONDAY:
                week = weeks[1];
                break;
            case Calendar.TUESDAY:
                week = weeks[2];
                break;
            case Calendar.WEDNESDAY:
                week = weeks[3];
                break;
            case Calendar.THURSDAY:
                week = weeks[4];
                break;
            case Calendar.FRIDAY:
                week = weeks[5];
                break;
            case Calendar.SATURDAY:
                week = weeks[6];
                break;
        }
        System.out.println("周"+week);
        System.out.println(sdf.format(calendar.getTime()));
        String month = "";
        String[] months = {"一","二","三","四","五","六","七","八","九","十","十一","十二"};
        switch (calendar.get(Calendar.MONTH)){
            case Calendar.JANUARY:
                month = months[0];
                break;
            case Calendar.FEBRUARY:
                month = months[1];
                break;
            case Calendar.MARCH:
                month = months[2];
                break;
            case Calendar.APRIL:
                month = months[3];
                break;
            case Calendar.MAY:
                month = months[4];
                break;
            case Calendar.JUNE:
                month = months[5];
                break;
            case Calendar.JULY:
                month = months[6];
                break;
            case Calendar.AUGUST:
                month = months[7];
                break;
            case Calendar.SEPTEMBER:
                month = months[8];
                break;
            case Calendar.OCTOBER:
                month = months[9];
                break;
            case Calendar.NOVEMBER:
                month = months[10];
                break;
            case Calendar.DECEMBER:
                month = months[11];
                break;
        }
        System.out.println(month+"月");

      /*  Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DATE,-1);
        Long timeStamp = 1368665666000L;
        Date date = new Date(timeStamp);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-MM-dd HH:mm");
//        String yestoday = sdf.format(new Date());
//        System.out.println(yestoday);
        System.out.println(sdf1.format(date));*/

//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

     /*   long timeStamp =1386665666777L;
            String time = String.valueOf(timeStamp);
            if(time.length()<13){
                int count = 13 - time.length();
                for(int i=0;i<count;i++){
                    time+="0";
                }
                timeStamp =Long.parseLong(time);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(timeStamp));
        System.out.println(time);
        System.out.println(calendar.getWeekYear());*/

      /*  System.out.println(new DecimalFormat("#.00").format(1223));
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        Calendar cal = Calendar.getInstance();
        date.setTime(1474192511000L);
        System.out.println(new Date(1505986708000L));//1386665666777L
        System.out.println(cal.getWeekYear()+" " +cal.get(Calendar.DAY_OF_WEEK));*/

       /* int start = 2;

        int zq= 20160915;
        int zqend= 3;
        long gq = 20161001;
        SimpleDateFormat format =  new SimpleDateFormat("yyyyMMdd");
        long gqend = 7;
        int time = 20161008;
        System.out.println("time "+time);
        System.out.println("zq start "+((20160915-time<=2)&&(20160915-time>=0)));
        System.out.println("zq end "+(time-20160915<3));
        System.out.println("gq start "+((20161001-time<=2)&&(20161001-time>=0)));
        System.out.println("gq end "+(time-20161001<7));*/

//        System.out.println("a".substring(0,1));
//        List<String> list = new ArrayList<>();
//        list.add("001");
//        list.add("002");
//        list.add("003");
//        list.add("004");
//        list.add("005");
//        String[] str = (String[]) list.toArray(new String[]{});
//        for (String s :
//                str) {
//            System.out.println(s);
//        }


       /* String str = "野虎sdhak12ada";
        System.out.println(str.toUpperCase());*/
     /*   System.out.println(Math.round(16.4));
        System.out.println(Math.round(16.5));
        System.out.println(Math.round(16.6));
        int  mRate = (int)Math.round(4*1.0/5*10);*/


      /*  List<JavaHello.Student> lists  = new ArrayList<>();
        for(int i=0;i<5;i++){
            lists.add( new JavaHello.Student(i+""));
        }
        System.out.println(lists.toString());
        for(int i=0;i<lists.size();i++){
            lists.remove(lists.contains(lists.get(i))?lists.get(i):"");
        }
        System.out.println(lists.toString());*/

        /*  SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String time=format.format(d);
        Date date = format.parse(time);
        System.out.println(date.getTime());
        System.out.println(d.getTime());
      long oldTimestamp = 1469607604000l;
        long newTimestamp = d.getTime();
        long timestamp =newTimestamp-oldTimestamp;
        System.out.println(timestamp);*/
        //时间戳转化为Sting或Date
        /*long current =  System.currentTimeMillis();
        long between = (1470585600000L - 1470211917952L) / 1000;//除以1000是为了转换成秒
        long day = between / (24 * 3600);
        long hour = between % (24 * 3600) / 3600;
        long minute = between % 3600 / 60;
        long second = between % 60;
        System.out.println(day+" 天,"+hour+" 时, "+minute+" 分, "
                +second+" 秒");
        System.out.println(current);*/

//        long counttime = 259200-4; // 分
//        System.out.println(counttime/3600/24);
//        System.out.println(counttime/3600%24);
//        System.out.println(counttime%60);

//       String str = "【金木水火土】123456";
//       System.out.println(str.matches("^【[\\u4e00-\\u9fa5]+】"));
//       System.out.println(str.matches("\\w"));

//       Pattern pattern = Pattern.compile("^【[\\u4e00-\\u9fa5]+】|\\w{4,}");
//        String str1 = "【金木水火土】123456";
//       Matcher matcher = pattern.matcher(str1);
//       while (matcher.find()){
//           System.out.println(matcher.group());
//       }
//       String str = "￥1648786";
//       String temp = str.split("[^\\d]")[1];
//       System.out.print(temp);

//        String templong = "123445647";
//        templong = templong.contains(".") ? templong.substring(0, templong.lastIndexOf(".")) : templong;
////       templong = templong.substring(0,templong.length()-1)+"0";
//        long mlong = Long.parseLong(templong);
//        mlong = mlong - (mlong % 10) + (mlong % 10 < 5 ? 0 : 10);
//        System.out.println(templong);
//        System.out.println(mlong);
//
//        String phoneNumber = "15292591161";
//        String regPhoneNumber = "^1[3,4,5,7,8]\\d{9}$";
//        System.out.println(phoneNumber.matches(regPhoneNumber));

       /* double a = 0.000001;
        System.out.println(0==a);

        double c = 2.0002;
        double b = 3.90000;
        System.out.println(c);
        System.out.println(b);
        String lat = String.valueOf(b);
        System.out.println(lat);
        lat = lat.split("\\.")[0];
        System.out.println(lat);*/
    }


}
