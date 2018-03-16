package Java.test;

import Java.utils.BusinessUtils;
import Java.utils.IDCardUtils;
import org.junit.Test;

/**
 * Desc:
 * Author: Yehu
 * Created by kachesiji on 2016/5/21.
 */
public class RegexTest {

    @Test // 如下测试营业执照百度的15位：
    public void testRegexBusiness() {
        String[] test = {
                // 有效数据
                "310117003171688", "330282602082220", "430524600099555",
                "350205200033663", "320507000045918", "440301104041144",
                "440307811872564", "130903000004802", "370125200024527",
                "330225000051892", "340100000400528", "445381600190918",
                "441900001868015", "310230000419464", "440301103072002",
                "320483000067847", "110108000000016", "320300000174110",
                // 错误测试数据
                "320483000067848", "32048300006784", "3204830000678481", ""

        };
        for (int i = 0; i < test.length; i++) {
            String temp = test[i];
            System.out.println(temp + " 校验码：" + BusinessUtils.getComputeCheckCode(temp) + " " + BusinessUtils.isBusinesslicense15(temp));
        }
    }

    @Test // 测试身份证号
    public void testRegexIDCard() {
        String[] cards = {
                // 有效数据
                "44522119940201887X", "15010219810707645X", "371326197911207560",
                // 年份
                "44522120180201887X", "15010220190707645X", "371326201811207560", "44522120180229887X",
                // 错误测试数据
                "87522119940201887X", "15010229810707645X", "371326197921207560", ""
        };
        for (int i = 0; i < cards.length; i++) {
            String temp = cards[i];
            System.out.println("精确校验：" + temp + " " + IDCardUtils.isCard(temp, false)
                    + " 性别：" + IDCardUtils.getIDCardGender(temp) + " BirthDay：" + IDCardUtils.getBirthday(temp)
                    + " 年：" + IDCardUtils.checkCardYear(temp) + " 月：" + IDCardUtils.checkCardMonth(temp) + " 日：" + IDCardUtils.checkCardDay(temp));
            System.out.println("正则校验：" +temp + " " + IDCardUtils.isCard(temp, true)
                    + " 性别：" + IDCardUtils.getIDCardGender(temp) +" BirthDay：" + IDCardUtils.getBirthday(temp)
                    + " 年：" + IDCardUtils.checkCardYear(temp) + " 月：" + IDCardUtils.checkCardMonth(temp) + " 日：" + IDCardUtils.checkCardDay(temp));
        }
    }


}