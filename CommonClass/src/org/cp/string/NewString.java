package org.cp.string;

/**
 * create by CP on 2019/7/30 0030.
 */
public class NewString {
    public static void main(String[] args) {
        String s1 = "cp";
        String s2 = "cp";//这种放在方法区，字符串常量池， s1和s2共用一个cp
        String s3 = new String("cp");//这种是在堆内存中开辟一块区域
        String s4 = new String("cp");//s3和s4 是两个不同的cp
        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s3==s4);//false
    }
}
