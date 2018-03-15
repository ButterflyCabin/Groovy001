package Java.utils;

import java.util.Arrays;
import java.util.Calendar;

public class RegexIDCardUtils {
    /**
     * 省，直辖市代码表： { 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",
     * 21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
     * 33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",
     * 42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",
     * 51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",
     * 63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}
     */
    protected String codeAndCity[][] = {{"11", "北京"}, {"12", "天津"},
            {"13", "河北"}, {"14", "山西"}, {"15", "内蒙古"}, {"21", "辽宁"},
            {"22", "吉林"}, {"23", "黑龙江"}, {"31", "上海"}, {"32", "江苏"},
            {"33", "浙江"}, {"34", "安徽"}, {"35", "福建"}, {"36", "江西"},
            {"37", "山东"}, {"41", "河南"}, {"42", "湖北"}, {"43", "湖南"},
            {"44", "广东"}, {"45", "广西"}, {"46", "海南"}, {"50", "重庆"},
            {"51", "四川"}, {"52", "贵州"}, {"53", "云南"}, {"54", "西藏"},
            {"61", "陕西"}, {"62", "甘肃"}, {"63", "青海"}, {"64", "宁夏"},
            {"65", "新疆"}, {"71", "台湾"}, {"81", "香港"}, {"82", "澳门"},
            {"91", "国外"}};
    private static String cityCode[] = {"11", "12", "13", "14", "15", "21",
            "22", "23", "31", "32", "33", "34", "35", "36", "37", "41", "42",
            "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62",
            "63", "64", "65", "71", "81", "82", "91"};
    /**
     * 校验省份证正确返回码
     */
    public static String isCardID = "true";
    private static String error_cityCode = "您输入的身份证地址编码不对，请核对后再输";
    private static String error_year = "您输入的年份有误，请核对后再输";
    private static String error_day = "您输入的生日日期有误，请核对后再输";
    private static String error_cardId = "您输入的身份证有误，请核对后再输";
    private static String error_cardId_num = "您输入的身份证不足18位，请核对后再输";
    private static String mouth_day = "(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-9])))";
    // 日期判断 平年和闰年 2月的天数
    private static String isCard1 = "^[1-9]\\d{5}[1-9]\\d{3}" + mouth_day + "\\d{3}([0-9]|X|x)$";// 3 比较精确的
    private String isCard2 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$";// 1
    // 身份证验证 15 18
    private static String isCarId3 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$";// 2
    // 每位加权因子
    private static int power[] = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    // 第18位校检码
    private static String verifyCode[] = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};


    /**
     * 判断省份证是否符合身份证规则
     *
     * @param card String
     * @return String
     */
    public static String isCard(String card) {
        if ("".equals(card) || " ".equals(card)) {
            System.out.println(error_cardId);
            return error_cardId;
        } else if (card.length() < 18) {
            System.out.println(error_cardId_num);
            return error_cardId_num;
        } else if (card.length() != 18) {
            System.out.println(error_cardId);
            return error_cardId;
        } else if (!card.matches(isCard1)) {
            System.out.println(error_cardId);
            return error_cardId;
        }
        // 获取前两位地址码并校验
        if (!checkCityCode(card.substring(0, 2))) {
            System.out.println(error_cityCode);
            return error_cityCode;
        }

        String IdCard17 = card.substring(0, 17);// 获取前17位
        String idCard18 = card.substring(17, 18);// 获取校验码

        String IdCardYear = card.substring(6, 10);// 年
        String IdCardMonth = card.substring(6, 10);// 月
        String IdCardDay = card.substring(12, 14);// 日
        Calendar calendar = Calendar.getInstance();
        // 校验合法年份
        if (1 > checkCardYear(IdCardYear, calendar)) {
            System.out.println(error_year);
            return error_year;
        }

        if (1 > checkCardMonth(IdCardYear,IdCardMonth, calendar)) {

        }
        if (1 > checkCardDay(IdCardYear,IdCardMonth,IdCardDay,calendar) ){

        }

        char[] cardChars = IdCard17.toCharArray();
        int[] cardInt = new int[IdCard17.length()];
        for (int i = 0; i < cardChars.length; i++) {
            cardInt[i] = Integer.parseInt(String.valueOf(cardChars[i]));
        }
        int power = getPowerSum(cardInt);
        String checkCode = verifyCode[power % 11];
        System.out.println(checkCode);
        if (idCard18.equals(checkCode)) {
            System.out.println(isCardID);
            return isCardID;
        }
        System.out.println(error_cardId);
        return error_cardId;
    }

    /**
     * 有效年份
     *
     * @param cardYear
     * @param calendar
     * @return
     */
    public static int checkCardYear(String cardYear, Calendar calendar) {
        int year = (int) Integer.parseInt(cardYear);
        int currentYear = calendar.get(Calendar.YEAR);// 获取年份
        return currentYear == year ? 0 : currentYear > year ? 1 : -1;
    }

    /**
     * 有效月份
     *
     * @param cardMonth
     * @param calendar
     * @return
     */
    public static int checkCardMonth(String cardYear, String cardMonth, Calendar calendar) {
        int yearCheck = checkCardYear(cardYear, calendar);
        if (yearCheck == 0) {
            int month = (int) Integer.parseInt(cardMonth);
            int currentMonth = calendar.get(Calendar.MONTH) + 1;
            return Integer.compare(currentMonth, month) == 0 ? 0 : currentMonth > month ? 1 : -1;
        } else {
            return yearCheck;
        }
    }

    /**
     * 有效日期
     *
     * @param cardDay
     * @param calendar
     * @return
     */
    public static int checkCardDay(String cardYear, String cardMonth, String cardDay, Calendar calendar) {
        int monthCheck = checkCardMonth(cardYear, cardMonth, calendar);
        int day = (int) Integer.parseInt(cardDay);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        if (monthCheck == 0 && 1 == checkRunnianDay(cardYear, cardMonth, cardDay)) {
            return Integer.compare(currentDay, day) == 0 ? 0 : currentDay > day ? 1 : -1;
        } else if (monthCheck == 1) {
            return checkRunnianDay(cardYear, cardMonth, cardDay);
        } else {
            return monthCheck;
        }
    }

    private static int checkRunnianDay(String cardYear, String cardMonth, String cardDay) {
        return !isRunnian(Integer.parseInt(cardYear)) && "02".equals(cardMonth) && Integer.parseInt(cardDay) == 29 ? -1 : 1;
    }


    public static boolean checkCityCode(String cityCode) {
        return Arrays.asList(cityCode).contains(cityCode);
    }

    /**
     * 判断 平闰年
     *
     * @param year
     * @return
     */
    public static boolean isRunnian(int year) {
        return (Integer.compare(year % 4, 0) == 0 && Integer.compare(year % 100, 0) != 0 || Integer.compare(year % 400, 0) == 0);
    }

    /**
     * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
     *
     * @param bit
     * @return
     */
    private static int getPowerSum(int[] bit) {
        int sum = 0;
        if (power.length != bit.length) {
            return sum;
        }
        for (int i = 0; i < bit.length; i++) {
            for (int j = 0; j < power.length; j++) {
                if (i == j) {
                    sum = sum + bit[i] * power[j];
                }
            }
        }
        return sum;
    }

}
