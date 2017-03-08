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
    // 如下测试营业执照百度的
    static String  test = "110108000000016" ; // 营业执照号
    static String  test1 = "320300000174110" ; // 营业执照号

    public static void main(String[] args ){
        System.out.println(test);
        isBusinesslicense(test);
    }

    /**
     * 校验 营业执照注册号
     * @param businesslicense
     * @return
     */
    public static String isBusinesslicense(String businesslicense){
        if ("".equals(businesslicense)||" ".equals(businesslicense)){ System.out.println(error_Businesslicense_Empty);
            return  error_Businesslicense_Empty;
        }else if(businesslicense.length()!=15){ System.out.println(error_Businesslicense_No);
            return error_Businesslicense_No;
        }
        String businesslicensePrex14 = businesslicense.substring(0,14);// 获取营业执照注册号前14位数字用来计算校验码
        String businesslicense15 = businesslicense.substring(14,businesslicense.length());// 获取营业执照号的校验码
        System.out.println(businesslicense15.equals(""+getCheckCode(getIntArrayForString(businesslicensePrex14)))); // 比较 填写的营业执照注册号的校验码和计算的校验码是否一致
        if(1 == getCheckCode(getIntArrayForString(businesslicense))){// 传入15位 只校验营业执照的有效性推荐用这个
            System.out.println(isBusinesslicense);
            return  isBusinesslicense;
        }else {
            System.out.println(error_Businesslicense);
            return error_Businesslicense;
        }
    }

    private static int[] getIntArrayForString(String str){
        char[] chars = str.toCharArray();
        int[] ints = new int[chars.length];
        for(int i=0; i<chars.length;i++){
            ints[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return ints;
    }

    /**
     * 获取 营业执照注册号的校验码
     * @param ints 为15为返回1为有效，否则无效；传入14为则会计算出第15位的校验码。
     * @return
     */
    private static int  getCheckCode(int[] ints){
        int result = -1;
        String tag = "result: ";
        if (null != ints && ints.length > 1) {
            int ti = 0;
            int si = 0; // pi|11+ti
            int cj = 0; // （si||10==0？10：si||10）*2
            int pj = 10; // pj=cj|11==0?10:cj|11
            for (int i=0;i< ints.length;i++) {
                ti = ints[i];
                si = pj + ti;
                cj = (0 == si % 10 ? 10 : si % 10) * 2;
                pj = (cj % 11) == 0 ? 10 : (cj % 11);
                if (i == ints.length-1) {
                    if (ints.length == 14){
                        tag = "校验码： ";
                        pj = (cj % 11) == 0 ? 10 : (cj % 11);
                        result  = 1- pj < 0 ? 11 - pj : 1- pj;// 返回营业执照注册号的校验码
                    }else if ( ints.length == 15){
                        tag = "有效营业执照标志： ";
                        result  = si % 10; // 返回1 表示是一个有效营业执照号
                    }
                }
                System.out.println(i+" ti="+ti+", si="+si+", cj="+cj+", pj="+pj);
            }
        }
        System.out.println(tag+result);
        return result;
    }
}
