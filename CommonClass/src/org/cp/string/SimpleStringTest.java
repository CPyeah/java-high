/**
 * Copyright (C)
 * FileName: SimpleStringTest
 * Author:   cp
 * Date:     2019/7/29 22:08
 * Description: String类简单概述例子
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp.string;

/**
 * 〈一句话功能简述〉<br> 
 * 〈String类简单概述例子〉
 *  final修饰
 *  Serializable
 *  Comparable
 *  private final char value[];内部属性   不可变的特性
 *
 * @author cp
 * @create 2019/7/29
 * @since 1.0.0
 */
public class SimpleStringTest {
    public static void main(String[] args) {
        //字符串常量池（方法区）不存在两个相同的字符串
        //abc 放在字符串常量池（方法区）
        String s1 = "abc";//字面量的定义方式
        //池子中找下有没有abc，有的话共用同一个，没有就再造一个
        String s2 = "abc";
        //这个时候，s1、s2共用同一个abc
        System.out.println(s1 == s2);
        //找一下有没有hello，没有新建一个，s1指向hello
        s1 = "hello";
        System.out.println(s1=="hello");

        System.out.println(s1);
        System.out.println(s2);

        System.out.println("*****************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s2);
        System.out.println(s3);

        System.out.println("*****************");

        String s4 = "abc";
        //只要有变化，都会新造，不会再原来的上面修改。
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc
    }

}
