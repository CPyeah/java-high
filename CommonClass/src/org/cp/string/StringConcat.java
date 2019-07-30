package org.cp.string;

/**
 * 字符串拼接的一些细节
 *
 * 1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
 * 2.只要其中一个是变量，结果就在堆中。
 * 3.如果拼接的结果调用intern()方法，返回值就在常量池中。
 *
 * create by CP on 2019/7/30 0030.
 */
public class StringConcat {
    public static void main(String[] args) {
        String s1 = "hello";//常量池
        String s2 = "helloworld";//常量池
        String s3 = "hello" + "world";//常量池  两个常量拼接，结果在常量池中
        String s4 = s1 + "world";//堆   只要拼接元素中有一个变量，结果就在堆中
        String s5 = s4.intern();//常量池 intern()方法可以把堆中字符串 转到 常量池 中
        System.out.println(s2==s3);//true
        System.out.println(s2==s4);//false
        System.out.println(s2==s5);//true
        System.out.println("***********************");
        String s6 = new String("hello");
        String s7 = new String("hello");
        System.out.println(s6==s7);//false
        System.out.println(s6.intern()==s7.intern());//true
    }
}
