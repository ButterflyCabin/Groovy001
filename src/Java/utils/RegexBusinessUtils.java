package Java.utils;

/**
 * 15位营业执照注册号检验工具
 */
public class RegexBusinessUtils {
    /**
     * 营业执照注册号校验正确返回码
     */
    public static String isBusinesslicense = "true";
    private static String error_Businesslicense_Empty = "请输入营业执照注册号";
    public static String error_Businesslicense = "您输入的营业执照注册号有误，请核对后再输!";
    public static String error_Businesslicense_No = "您输入的营业执照注册号不足15位，请核对后再输!";

    /**
     * 校验15位的营业执照注册号
     *
     * @param businesslicense
     * @return
     */
    public static String isBusinesslicense15(String businesslicense) {
        String result = "";
        if ("".equals(businesslicense) || " ".equals(businesslicense)) {
            result =  error_Businesslicense_Empty;
        } else if (businesslicense.length() != 15) {
            result =  error_Businesslicense_No;
        }else if (isBusinesslicense(getIntArrayForString(businesslicense))) {// 传入15位 只校验营业执照的有效性推荐用这个
            result =  isBusinesslicense;
        }
        System.out.println(result);
        System.out.println();
        return error_Businesslicense;
    }

    private static int[] getIntArrayForString(String str) {
        char[] chars = str.toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return ints;
    }

    /**
     * 获取 营业执照注册号的校验码
     *
     * @param ints 为15为返回1为有效，否则无效；传入14为则会计算出第15位的校验码。
     * @return
     */
    private static int getCheckCode(int[] ints, boolean getCheckCode) {
        int result = -1;
        if (ints.length < 14) {
            return result;
        }
        if (null != ints && ints.length > 1) {
            int ti = 0;
            int si = 0; // pi|11+ti
            int cj = 0; // （si||10==0？10：si||10）*2
            int pj = 10; // pj=cj|11==0?10:cj|11
            for (int i = 0; i < ints.length; i++) {
                ti = ints[i];
                si = pj + ti;
                cj = (0 == si % 10 ? 10 : si % 10) * 2;
                pj = (cj % 11) == 0 ? 10 : (cj % 11);
                if (i == 13) {
                    System.out.println("校验码：" + (1 - pj < 0 ? 11 - pj : 1 - pj));
                    if (getCheckCode) {
                        result = (1 - pj < 0 ? 11 - pj : 1 - pj) % 10;// 返回营业执照注册号的校验码
                        return result;
                    }
                }
                if (i == 14) {
                    result = si % 10; // 返回1 表示是一个有效营业执照号
                    System.out.println("有效营业执照标志： " + result);
                }
//                System.out.println(i + " ti=" + ti + ", si=" + si + ", cj=" + cj + ", pj=" + pj);
            }
        }
        return result;
    }

    private static boolean isBusinesslicense(int[] ints) {
        return 1 == getCheckCode(ints, false);
    }
}
