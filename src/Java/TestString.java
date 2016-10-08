package Java;

import org.junit.Test;

/**
 * Desc:
 * Author: Yehu
 * Created by kachesiji on 2016/10/8.
 */
public class TestString {
    @Test
    public void testString(){
        int i =0;
        System.out.println(i++);
        System.out.println(i++);
        System.out.println(i++);
        System.out.println(i++);
        System.out.println(i++);
        System.out.println(i);

    }
    @Test
    public void testString_1(){
        String userName = "啊达";
        if (userName.length() > 1) {
            System.out.println("*"+userName.substring(1,userName.length()));
        } else {
            System.out.println("*"+userName);
        }
    }

}
