package Java.utils;

import java.util.Arrays;
import java.util.Calendar;

public class IDCardUtils {
    /**
     * 省，直辖市代码表： { 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",
     * 21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
     * 33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",
     * 42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",
     * 51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",
     * 63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}
     */
    protected String provinceAndCode[][] = {{"11", "北京"}, {"12", "天津"},
            {"13", "河北"}, {"14", "山西"}, {"15", "内蒙古"}, {"21", "辽宁"},
            {"22", "吉林"}, {"23", "黑龙江"}, {"31", "上海"}, {"32", "江苏"},
            {"33", "浙江"}, {"34", "安徽"}, {"35", "福建"}, {"36", "江西"},
            {"37", "山东"}, {"41", "河南"}, {"42", "湖北"}, {"43", "湖南"},
            {"44", "广东"}, {"45", "广西"}, {"46", "海南"}, {"50", "重庆"},
            {"51", "四川"}, {"52", "贵州"}, {"53", "云南"}, {"54", "西藏"},
            {"61", "陕西"}, {"62", "甘肃"}, {"63", "青海"}, {"64", "宁夏"},
            {"65", "新疆"}, {"71", "台湾"}, {"81", "香港"}, {"82", "澳门"},
            {"91", "国外"}};
    private static String PROVINCE_CODE[] = {"11", "12", "13", "14", "15", "21",
            "22", "23", "31", "32", "33", "34", "35", "36", "37", "41", "42",
            "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62",
            "63", "64", "65", "71", "81", "82", "91"};

    private static String ERROR_COMMON = "您输入的身份证%s，请核对后再输";
    private static String REGEX_MOUTH_DAY = "(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-9])))";
    // 日期判断 平年和闰年 2月的天数
    private static String REGEX_CARD_1 = "^[1-9]\\d{5}[1-9]\\d{3}" + REGEX_MOUTH_DAY + "\\d{3}([0-9]|X|x)$";// 3 比较精确的
    private String REGEX_CARD_2 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$";// 1
    // 身份证验证 15 18
    private static String REGEX_CARD_3 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$";// 2
    // 每位加权因子
    private static int POWER[] = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    // 第18位校检码
    private static String VERIFY_CODE[] = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

    /**
     * 判断身份证是否符合身份证规则
     *
     * @param card      String
     * @param onlyRegex true：只保证合法性，不能保证有效性；false：合法性和有效性
     * @return String
     */
    public static String isCard(String card, boolean onlyRegex) {
        String msg;
        if (null == card || card.trim().equals("")) {
            msg = String.format(ERROR_COMMON, "为空");
        } else if (card.length() != 18) {
            msg = String.format(ERROR_COMMON, "位数有误");
        } else if (!card.matches(REGEX_CARD_1)) {// 符合身份证编码正则的
            msg = String.format(ERROR_COMMON, "有误");
        } else if (onlyRegex) {// 是符合身份证编码正则的
            msg = "true";
        } else if (!checkCityCode(getIDCardCityCode(card))) { // 获取前两位地址码并校验
            msg = String.format(ERROR_COMMON, "地址编码不对");
        } else if (-1 == checkCardYear(card)) {// 校验合法年份
            msg = String.format(ERROR_COMMON, "年份有误");
        } else if (-1 == checkCardMonth(card)) {
            msg = String.format(ERROR_COMMON, "月份有误");
        } else if (-1 == checkCardDay(card)) {
            msg = String.format(ERROR_COMMON, "日期有误");
        } else if (getIDCardCheckCode(card).equals(getComputeCardCheckCode(card))) {
            msg = "true";
        } else {
            msg = String.format(ERROR_COMMON, "无效");
        }
        return msg;
    }

    /**
     * 根据身份证17位计算出校验码
     *
     * @param IDCard
     * @return
     */
    public static String getComputeCardCheckCode(String IDCard) {
        return VERIFY_CODE[getPowerSum(IDCard) % 11];
    }

    /**
     * 获取出生日期
     *
     * @param IDCard
     * @return
     */
    public static String getBirthday(String IDCard) {
        return getStringForCard(IDCard, 6, 14);
    }

    /**
     * 获取身份证号校验码
     *
     * @param IDCard
     * @return
     */
    public static String getIDCardCheckCode(String IDCard) {
        return getStringForCard(IDCard, 17, 18);
    }

    /**
     * 获取日期
     *
     * @param IDCard
     * @return
     */
    public static int getIDCardDay(String IDCard) {
        return Integer.parseInt(getStringForCard(IDCard, 12, 14));
    }

    /**
     * 获取月份
     *
     * @param IDCard
     * @return
     */
    public static int getIDCardMonth(String IDCard) {
        return Integer.parseInt(getStringForCard(IDCard, 10, 12));
    }

    /**
     * 获取年份
     *
     * @param IDCard
     * @return
     */
    public static int getIDCardYear(String IDCard) {
        return Integer.parseInt(getStringForCard(IDCard, 6, 10));
    }

    /**
     * 获取区域编码
     *
     * @param IDCard
     * @return
     */
    public static String getIDCardCityCode(String IDCard) {
        return getStringForCard(IDCard, 0, 2);
    }

    /**
     * 截取数据
     *
     * @param IDCard
     * @param start
     * @param end
     * @return
     */
    public static String getStringForCard(String IDCard, int start, int end) {
        if (null != IDCard && !IDCard.trim().equals("") && IDCard.length() >= end) {
            return IDCard.substring(start, end);
        } else {
            return "-1";
        }
    }

    /**
     * 有效年份
     *
     * @param card
     * @return
     */
    public static int checkCardYear(String card) {
        Calendar calendar = Calendar.getInstance();
        int cardYear = getIDCardYear(card);
        if (-1 != cardYear) {
            int currentYear = calendar.get(Calendar.YEAR);// 获取年份
            return Integer.compare(currentYear, cardYear) == 0 ? 0 : currentYear > cardYear ? 1 : -1;
        }
        return -1;
    }

    /**
     * 有效月份
     *
     * @param card
     * @return
     */
    public static int checkCardMonth(String card) {
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int yearCheck = checkCardYear(card);
        int cardMonth = getIDCardMonth(card);
        if (-1 == cardMonth) {
            return -1;
        } else if (yearCheck == 0) {
            return Integer.compare(currentMonth, cardMonth) == 0 ? 0 : currentMonth > cardMonth ? 1 : -1;
        } else {
            return yearCheck;
        }
    }

    /**
     * 有效日期
     *
     * @param card
     * @return
     */
    public static int checkCardDay(String card) {
        Calendar calendar = Calendar.getInstance();
        int monthCheck = checkCardMonth(card);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int cardDay = getIDCardDay(card);
        if (-1 == cardDay) {
            return -1;
        } else if (monthCheck == 0 && 1 == checkLeapYearDay(getIDCardYear(card), getIDCardMonth(card), cardDay)) {
            return Integer.compare(currentDay, cardDay) == 0 ? 0 : currentDay > cardDay ? 1 : -1;
        } else if (monthCheck == 1) {
            return checkLeapYearDay(getIDCardYear(card), getIDCardMonth(card), cardDay);
        } else {
            return monthCheck;
        }
    }

    /**
     * 校验闰年02月日期
     */
    private static int checkLeapYearDay(int cardYear, int cardMonth, int cardDay) {
        return !isLeapYear(cardYear) && 2 == cardMonth && cardDay == 29 ? -1 : 1;
    }

    /**
     * 校验省级代码
     *
     * @param cityCode
     * @return
     */
    public static boolean checkCityCode(String cityCode) {
        return Arrays.asList(PROVINCE_CODE).contains(cityCode);
    }

    /**
     * 判断 平闰年
     *
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    /**
     * 获取性别
     *
     * @param IDCard
     * @return 1：男；0：女
     */
    public static int getIDCardGender(String IDCard) {
        return Integer.parseInt(getStringForCard(IDCard, 16, 17)) % 2;
    }

    /**
     * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
     *
     * @param IDCard
     * @return
     */
    private static int getPowerSum(String IDCard) {
        int sum = 0;
        if (IDCard.length() < 18 || POWER.length != IDCard.length() - 1) {
            return sum;
        }
        for (int i = 0; i < POWER.length; i++) {
            sum = sum + Integer.parseInt(IDCard.substring(i, i + 1)) * POWER[i];
        }
        return sum;
    }
}
