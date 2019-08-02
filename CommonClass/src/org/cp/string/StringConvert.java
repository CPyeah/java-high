package org.cp.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * create by CP on 2019/8/1 0001.
 */
public class StringConvert {

    /**
     * String int 互转
     * Integer.parseInt(s)
     * String.valueOf(i) 或 i + ""
     */
    @Test
    public void toInt() {
        String s = "123";
        int i = Integer.parseInt(s);
        System.out.println(i);
        String s1 = String.valueOf(i);//有 new String() 的动作
        System.out.println(s1);
        String s2 = i + "";//plan B
        System.out.println(s2);
        System.out.println(s == s1);
        System.out.println(s == s2);
    }

    /**
     * String 、 char[]互转
     * String 的底层也是char[]
     * s.toCharArray()
     * new String(chars1)
     */
    @Test
    public void toChar() {
        String s = "a1b2c3";
        char[] chars = s.toCharArray();
        System.out.println(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        char[] chars1 = {'a','b','d','e'};
        String s1 = new String(chars1);
        System.out.println(s1);
    }

    /**
     * 中文、 字节码 的相互转换
     * s.getBytes() / s.getBytes("gbk")
     * new String(utf8) / new String(gbks, "gbk")
     * 转换时应当考虑字符集的问题
     * @throws UnsupportedEncodingException
     */
    @Test
    public void toByte() throws UnsupportedEncodingException {
        String s = "hello中国";
        byte[] utf8 = s.getBytes();// 默认utf-8字符集
        System.out.println(Arrays.toString(utf8));//[104, 101, 108, 108, 111, -28, -72, -83, -27, -101, -67]
        byte[] gbks = s.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));//[104, 101, 108, 108, 111, -42, -48, -71, -6]

        String s1 = new String(utf8);
        System.out.println(s1);//hello中国
        String s2 = new String(gbks);
        System.out.println(s2);//中文乱码 hello�й�
        String s3 = new String(gbks, "gbk");
        System.out.println(s3);//hello中国
    }
}
