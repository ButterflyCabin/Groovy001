package Java;

/**
 * Desc: 营业执照编号 验证
 * Created by kachesiji on 2016/5/14.
 */
public class Regex_BusinessLicenseNumber {

    /**
     * 营业执照注册号校验正确返回码
     */
    public static String isBusinesslicense = "true";
    private static String error_Businesslicense_Empty = "请输入营业执照注册号";
    public static String error_Businesslicense = "您输入的营业执照注册号有误，请核对后再输!";
    public static String error_Businesslicense_No = "您输入的营业执照注册号不足15位，请核对后再输!";
    // 如下测试营业执照百度的13位：4419002334401，1305822900365
    static String[] test = {
            "310117003171688", "330282602082220", "430524600099555",
            "350205200033663", "320507000045918", "440301104041144",
            "440307811872564", "130903000004802", "370125200024527",
            "330225000051892", "340100000400528", "445381600190918",
            "441900001868015", "310230000419464", "440301103072002",
            "320483000067847", "110108000000016", "320300000174110"
    };

    public static void main(String[] args) {
        String temp = test[0];
        System.out.println(temp);
        isBusinesslicense(temp);
    }

    /**
     * 校验 营业执照注册号
     *
     * @param businesslicense
     * @return
     */
    public static String isBusinesslicense(String businesslicense) {
        if ("".equals(businesslicense) || " ".equals(businesslicense)) {
            System.out.println(error_Businesslicense_Empty);
            return error_Businesslicense_Empty;
        } else if (businesslicense.length() != 15) {
            System.out.println(error_Businesslicense_No);
            return error_Businesslicense_No;
        }
        /** 方案1*/
        if (1 == getCheckCode(getIntArrayForString(businesslicense))) {// 传入15位 只校验营业执照的有效性推荐用这个
            System.out.println(isBusinesslicense);
            return isBusinesslicense;
        }
        /** 方案2*/
       /* String businesslicensePrex14 = businesslicense.substring(0,14);// 获取营业执照注册号前14位数字用来计算校验码
        String businesslicense15 = businesslicense.substring(14,businesslicense.length());// 获取营业执照号的校验码
        System.out.println(businesslicense15.equals(""+getCheckCode(getIntArrayForString(businesslicensePrex14)))); // 比较 填写的营业执照注册号的校验码和计算的校验码是否一致
        if(businesslicense15.equals(getCheckCode(getIntArrayForString(businesslicensePrex14)) + "")){
            System.out.println(isBusinesslicense);
            return  isBusinesslicense;
        }*/

        System.out.println(error_Businesslicense);
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
    private static int getCheckCode(int[] ints) {
        int result = -1;
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
                if (i == 14) {
                    System.out.println("校验码：" + (1 - pj < 0 ? 11 - pj : 1 - pj));
                }
                if (i == ints.length - 1) {
                    if (ints.length == 14) {
                        pj = (cj % 11) == 0 ? 10 : (cj % 11);
                        result = 1 - pj < 0 ? 11 - pj : 1 - pj;// 返回营业执照注册号的校验码
                    } else if (ints.length == 15) {
                        result = si % 10; // 返回1 表示是一个有效营业执照号
                        System.out.println("有效营业执照标志： " + result);
                    }
                }
                System.out.println(i + " ti=" + ti + ", si=" + si + ", cj=" + cj + ", pj=" + pj);
            }
        }
        return result;
    }
}
