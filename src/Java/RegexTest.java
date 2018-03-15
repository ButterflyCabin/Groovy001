package Java;

import Java.utils.RegexBusinessUtils;
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
                "310117003171688", "330282602082220", "430524600099555",
                "350205200033663", "320507000045918", "440301104041144",
                "440307811872564", "130903000004802", "370125200024527",
                "330225000051892", "340100000400528", "445381600190918",
                "441900001868015", "310230000419464", "440301103072002",
                "320483000067847", "110108000000016", "320300000174110"
        };
        for (int i = 0; i < test.length; i++) {
            String temp = test[i];
            System.out.println(temp);
            RegexBusinessUtils.isBusinesslicense15(temp);
        }
    }


}