package org.cp.string;

import org.junit.Test;

/**
 * String 相关 练习 实践
 * create by CP on 2019/8/5 0005.
 */
public class Practice {

    @Test
    public void trimTest() {
        String s1 = "   a b   ";
        System.out.println(myTrim(s1).equals(s1.trim()));
    }

    /**
     * 模拟一个trim方法，去除字符串两端的空格
     * @param s _ab_
     */
    public static String myTrim(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        int startIndex = 0;
        int endIndex = size -1;
        for (int i = 0; i < size-1; i++) {
            if (chars[i] != ' '){
                startIndex = i;
                break;
            }
        }
        for (int i = size-1; i >= 0; i--) {
            if (chars[i] != ' '){
                endIndex = i;
                break;
            }
        }
        System.out.println("startIndex: "+startIndex+" ; endIndex: "+(endIndex+1));
        return s.substring(startIndex, endIndex+1);
    }

    /**
     * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
     */
    @Test
    public void specialReverseTest() {
        String s = "abcdefg";
        System.out.println(specialReverse(s, 2, 1));
    }

    /**
     * 字符串范围反转
     * @param string 目标字符串
     * @param beginIndex    左保留位
     * @param endIndex  右保留位
     * @return 反转后字符串
     */
    private static String specialReverse(String string, int beginIndex, int endIndex) {
        endIndex = string.length() - endIndex;
        String prefix = string.substring(0, beginIndex);
        String suffix = string.substring(endIndex);
        String target = string.substring(beginIndex, endIndex);
        System.out.println(prefix + " " + target + " " + suffix);
        target = new StringBuilder(target).reverse().toString();
        StringBuilder sb = new StringBuilder(string.length());//初始化定长builder
        sb.append(prefix).append(target).append(suffix);
        return new String(sb);
    }

}
