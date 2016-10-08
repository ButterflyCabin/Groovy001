package Groovy

/**
 * Desc: 社会信用代码证 检验
 * Author: Yehu
 * Created by kachesiji on 2016/5/21.
 */
class Regex_CreditCode {
    static String creditCode1 = "91110105355299937Y";// 公司
    static String creditCode2 = "91350100M000100Y43";// 测试
    static String creditCode3 = "52370100MJD692273E";// 公司
    static String isCreditCode = "true";
    static String error_CreditCode = "社会信用代码有误";
    static String error_CreditCode_min = "社会信用代码不足18位，请核对后再输！";
    static String error_CreditCode_max = "社会信用代码大于18位，请核对后再输！";
    static String error_CreditCode_empty ="社会信用代码不能为空！";
    private static Map<String,Integer> datas = null;
    private static char[] pre17s;
    static int[] power = [1,3,9,27,19,26,16,17,20,29,25,13,8,24,10,30,28];
    static char[] code = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','T','U','W','X','Y']
        static  void main(def args){
            String temp = creditCode1;
            initDatas(code.length);
            println ""
            println temp
            println power
            pre17(temp);
            isCreditCode(temp);
    }
    static def isCreditCode(String creditCode){
        if("".equals(creditCode)||" ".equals(creditCode)){
            return error_CreditCode_empty;
        }else if(creditCode.length()<18){
            return  error_CreditCode_min;
        }else if(creditCode.length()>18){
            return  error_CreditCode_max;
        }else{
          int sum =  sum(pre17s);
            int temp = sum%31;
            println 31-temp;//todo
            println """${code[31-temp]} ${creditCode.substring(17,18).equals(code[31-temp].toString())}""";//todo
            return creditCode.substring(17,18).equals(code[31-temp])?isCreditCode:error_CreditCode;
        }
        return error_CreditCode;
    }
    private static int sum(char[] chars){
        int sum = 0;
        println ""
        for(int i=0;i<chars.length;i++){
            int code = datas.get(chars[i]);
//            print """ ${code}*${power[i]}=${power[i]*code}"""
//            println ""
            sum+=power[i]*code
        }
        println ""
        println sum ;
        return sum;

    }

   static  void  pre17(String creditCode){
        String pre17 = creditCode.substring(0,17);
         pre17s = pre17.toCharArray();
    }

   static def initDatas(int count){
       datas = new HashMap<>();
       for(i in 0..<code.length){
           datas.put(code[i],i)
           print """ ${code[i]}:${datas.get(code[i])}"""
       }
   }
}
