package Java.utils;

/**
 * 15位营业执照注册号检验工具
 */
public class BusinessUtils {
    public static String ERROR_COMMON = "您输入的营业执照注册号%s，请核对后再输!";

    /**
     * 校验15位的营业执照注册号
     *
     * @param businessLicense
     * @return
     */
    public static String isBusinesslicense15(String businessLicense) {
        String result = "";
        if ("".equals(businessLicense) || " ".equals(businessLicense)) {
            result =  String.format(ERROR_COMMON,"为空");
        } else if (businessLicense.length() != 15) {
            result =  String.format(ERROR_COMMON,"位数有误");
        }else if (isBusinessLicense(businessLicense)) {// 传入15位 只校验营业执照的有效性推荐用这个
            result =  "true";
        }else {
            result = String.format(ERROR_COMMON,"有误");
        }
        return result;
    }

    /**
     * 获取 营业执照注册号的校验码
     *
     * @param businessLicense 为15为返回1为有效，否则无效；传入14为则会计算出第15位的校验码。
     * @return
     */
    private static int getCheckCode(String businessLicense, boolean getCheckCode) {
        int result = -1;
        if (null == businessLicense || businessLicense.trim().equals("")|| businessLicense.length() != 15) {
            return result;
        }else{
            int ti = 0;
            int si = 0; // pi|11+ti
            int cj = 0; // （si||10==0？10：si||10）*2
            int pj = 10; // pj=cj|11==0?10:cj|11
            for (int i = 0; i < businessLicense.length(); i++) {
                ti = Integer.parseInt(businessLicense.substring(i,i+1));
                si = pj + ti;
                cj = (0 == si % 10 ? 10 : si % 10) * 2;
                pj = (cj % 11) == 0 ? 10 : (cj % 11);
                if (i == businessLicense.length()-2 && getCheckCode) {
                    result = (1 - pj < 0 ? 11 - pj : 1 - pj) % 10;// 返回营业执照注册号的校验码
                    return result;
                }
                if (i == businessLicense.length()-1) {
                    result = si % 10; // 返回1 表示是一个有效营业执照号
                }
//                System.out.println(i + " ti=" + ti + ", si=" + si + ", cj=" + cj + ", pj=" + pj);
            }
        }
        return result;
    }

    private static boolean isBusinessLicense(String businessLicense) {
        return 1 == getCheckCode(businessLicense, false);
    }

    /**
     *
     * @param businessLicense
     * @return
     */
    public static int  getComputeCheckCode(String businessLicense){
        return getCheckCode(businessLicense,true);
    }
}
