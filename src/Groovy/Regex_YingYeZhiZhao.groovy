package Groovy
/**
 * Desc: 营业执照注册号 验证
 * Author: Yehu
 * Created by kachesiji on 2016/5/19.
 */
class Regex_YingYeZhiZhao {
    static main(def args){
//        String test = "110108000000016" // 营业执照号 百度查的
        String test = "131125600053703"// 营业执照号 朋友给的
        String testPrex14 = test.subSequence(0,14)
        String test15 = test.substring(14,test.length())
        println test;println testPrex14
        char[] chars = testPrex14.toCharArray();
        def ints = new int[chars.length];
        for(i in 0..<chars.size()){
            ints[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
         def getcode= {
            if (null != ints && ints.size() > 1) {
                int ti = 0,si = 0;// pi|11+ti
                int cj = 0;// （si||10==0？10：si||10）*2
                int pj = 10;// pj=cj|11==0?10:cj|11
                println """i\tti\tsi\tcj\tpj"""
                for (i in 0..ints.size()) {
                    ti = ints[i]
                    pj = (cj % 11) == 0 ? 10 : (cj % 11);
                    si = pj + ti;
                    cj = (0 == si % 10 ? 10 : si % 10) * 2;
                    println """${i + 1}\t$ti\t$si\t$cj\t$pj"""
                    if (i == 13) {
                        pj = (cj % 11) == 0 ? 10 : (cj % 11);
                        ti = -1;
                        si = 1;
                        cj = 0;
                        println """${i + 2}\t$ti\t$si\t$cj\t$pj"""
                        println pj == 1 ? 1 : 11 - pj;
                        return pj == 1 ? 1 : 11 - pj;
                    }
                }
            }
        }
        getcode()
        println test15.equals(getcode()+"");
    }
}
