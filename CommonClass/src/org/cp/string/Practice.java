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
     *
     * @param s _ab_
     */
    public static String myTrim(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        int startIndex = 0;
        int endIndex = size - 1;
        for (int i = 0; i < size - 1; i++) {
            if (chars[i] != ' ') {
                startIndex = i;
                break;
            }
        }
        for (int i = size - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                endIndex = i;
                break;
            }
        }
        System.out.println("startIndex: " + startIndex + " ; endIndex: " + (endIndex + 1));
        return s.substring(startIndex, endIndex + 1);
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
     *
     * @param string     目标字符串
     * @param beginIndex 左保留位
     * @param endIndex   右保留位
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

    /**
     * 获取一个字符串在另一个字符串中出现的次数。
     * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
     */
    @Test
    public void findStringTest() {
//        String ss = "ab";
//        String ls = "abkkcadkabkebfkabkskab";
        String ss = "aa";
        String ls = "aaakkcadkaakebfkaakskaa";
        int count = 0;
        int i = 0;
        while ((i = ls.indexOf(ss, i)) >= 0) {
            count++;
//            i++;//往后移一个
            i += ss.length();//如果字符串不能重合，往后移ss的长度个
        }
        System.out.println(count);
    }

    /**
     * 获取两个字符串中最大相同子串。比如：
     * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
     * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
     * <p>
     * 循环小串所有子串，找出合适的最长的，效率不高
     */
    @Test
    public void getMaxSubStringTest() {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        String maxLong = "";
        int count = 0;
        for (int i = 0; i < str2.length(); i++) {
            for (int j = str2.length(); j > i; j--) {
                count++;
                String sub = str2.substring(i, j);
                if (str1.contains(sub) && sub.length() > maxLong.length()) {
                    maxLong = sub;
                }
            }
        }
        System.out.println(maxLong);
        System.out.println(count);
    }

    /**
     * 按照长度进行遍历
     * 效率稍高
     */
    @Test
    public void getMaxSubStringTest1() {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        int count = 0;
        outer:
        for (int j = str2.length(); j > 0; j--) {//j 代表长度
            for (int i = 0; i < str2.length(); i++) {// 代表左边索引
                count++;
                if (i + j <= str2.length()) {
                    String sub = str2.substring(i, i + j);
                    if (str1.contains(sub)) {
                        System.out.println(sub);
                        System.out.println(count);
                        break outer;
                    }
                } else {
                    break;
                }
            }
        }
    }


}
