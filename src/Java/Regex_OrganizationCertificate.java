package Java;

/**
 * Desc: 全国组织机构代码 校验
 * Created by kachesiji on 2016/6/6.
 */
public class Regex_OrganizationCertificate {
    private static String str1 = "D2143569-X";// 测试
    private static String str2 = "74371976-1";// 测试
    private static String str3 = "L1832212-3";// 测试
    private static String isOrganizationCertificate = "true";
    private static String error_OrganizationCertificate ="输入的机构代码错误，请核对后再输！";
    private static String error_OrganizationCertificate_num ="输入的机构代码位数不对，请核对后再输！";
    /**
     * 加权因子
     */
    private static int power[] = {3,7,9,10,5,8,4,2};

    public static void main(String[] args) {
        String temp = str2;
        System.out.println(temp);
        isOrganizationCertificate(temp);
    }

    /**
     * 判断机构代码是不是有效的
     * @param organizationCertificate
     * @return
     */
    public static String isOrganizationCertificate(String organizationCertificate) {
        String temp = organizationCertificate.toUpperCase();
        if (temp.contains("-")) {
            temp = temp.replace("-", "");
            System.out.println(temp);
        }
        if(temp.length()!=9){
            System.out.println(error_OrganizationCertificate_num);
            return error_OrganizationCertificate_num;
        }
        // 获取前面8位
        String pre8 = temp.substring(0,8);
        char[] pre8chars = pre8.toCharArray();// 0~z;
        // 获取校验码
        String code = temp.substring(8,9);
        boolean isCode = isCode(code,sum(pre8chars));
        System.out.println(isCode?isOrganizationCertificate:error_OrganizationCertificate);
        return isCode?isOrganizationCertificate:error_OrganizationCertificate;
    }

    /**
     * 求和
     * @param bit
     * @return
     */
    private static int sum(char[] bit){
        int sum = 0;
        for(int i=0;i<bit.length;i++){
            int intTemp = bit[i]>'9'?(bit[i]-'A'+10):Integer.parseInt(bit[i]+"");
            System.out.print(" "+intTemp);
            sum +=intTemp*power[i];
        }
        System.out.println();
        System.out.println(sum);
        return  sum;
    }

    /**
     * 判断机构代码的校验码和计算出的校验码是否一致
     * @param a
     * @param b
     * @return
     */
    private static boolean isCode(String a,int b){
        String codeTEmp = (11- b%11)==10?"X":(11- b%11)==11?0+"":(11- b%11)+"";
        System.out.println(codeTEmp);
        return a.equals(codeTEmp);
    }


}
