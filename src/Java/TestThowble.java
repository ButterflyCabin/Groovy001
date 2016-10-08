package Java;

import com.sun.xml.internal.bind.v2.util.StackRecorder;

import java.awt.*;

/**
 * Desc:
 * Author: Yehu
 * Created by kachesiji on 2016/6/14.
 */
public class TestThowble {
    public static void main(String[] args) {

        getlog();
    }
    public  static void getlog(){
        getLogMsg();
    }

    public static void getLogMsg() {
        Throwable th = new Throwable().fillInStackTrace();
        System.out.println(th.getMessage());
        System.out.println(th.getLocalizedMessage());
        th.getCause();
        StackTraceElement tack = th.getStackTrace()[2];
//        System.out.println(tack.length);
//        for (int i = 0; i < tack.length; i++) {
//            System.out.println(i + ":" + tack[i].toString());
//            StackTraceElement trace0 = tack[i];
//            System.out.println(i + ":" +trace0.getFileName() + "." + trace0.getClassName() + "." + trace0.getMethodName() + "." + trace0.getLineNumber());
//        }
        System.out.println( ":" +tack.getFileName() + "." + tack.getClassName() + "." + tack.getMethodName() + "." + tack.getLineNumber());

    }

}
