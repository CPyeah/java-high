package org.cp.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * create by CP on 2019/7/31 0031.
 */
public class CommonMethod {
    @Test
    public void test() {
        System.out.println("This is junit test!");
    }

    /**
     * int length()：返回字符串的长度： return value.length
     * char charAt(int index)： 返回某索引处的字符return value[index]
     * boolean isEmpty()：判断是否是空字符串：return value.length == 0
     * String toLowerCase()：使用默认语言环境，将 String 中的所字符转换为小写
     * String toUpperCase()：使用默认语言环境，将 String 中的所字符转换为大写
     * String trim()：返回字符串的副本，忽略前导空白和尾部空白
     * boolean equals(Object obj)：比较字符串的内容是否相同
     * boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
     * String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
     */
    @Test
    public void baseMethod() {
        String s1 = "HelloWorld";//final char value[]
        System.out.println(s1.length());//10  value.length
        System.out.println(s1.charAt(5));//W  value[index]
        System.out.println(s1.isEmpty());//false value.length == 0
        System.out.println(s1.toUpperCase());//HELLOWORLD value循环转大写（国际化）
        String s2 = "   HelloWorld    ";
        System.out.println(s1 == s2.trim().intern());//true substring(左空格索引, 右空格索引) 去除前后空格后，两者字面量相等
        System.out.println(s1.equals(s2));//false 字符串比较
        System.out.println(s1.equals(s2.trim()));//true 字符串比较 循环比较字符
        String s3 = "helloworld";
        System.out.println(s1.equalsIgnoreCase(s3));//true 字符转大写比较，（补偿措施：Georgian alphabet格鲁吉亚字母需要转小写比较）
        System.out.println(s1.concat(s2));//HelloWorld   HelloWorld    字符数组的操作
    }

    /**
     * int compareTo(String anotherString)：比较两个字符串的大小
     * String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
     * String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
     *
     * boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
     * boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
     * boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
     */
    @Test
    public void baseMethod2() {
        String s1 = "abcd";
        String s2 = "abcf";
        System.out.println(s1.compareTo(s2));//-2  按位相减
        System.out.println(s1.substring(2));//cd 第2位及以后
        System.out.println(s1.substring(1,2));//b 1、2之间 [1,2)
        System.out.println(s1.endsWith("cd"));//true 是不是cd结尾
        System.out.println(s1.startsWith("ab"));//true 是不是ab开头
        System.out.println(s1.startsWith("bc",1));//true 从第一位（b）开始，是不是bc开头
    }

    /**
     * boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
     * int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
     * int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
     * int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
     * int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
     *
     * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
     */
    @Test
    public void baseMethod3() {
        String s = "hellohelloworldword";
        System.out.println(s.contains("world"));//true
        System.out.println(s.indexOf("world"));//10
        System.out.println(s.indexOf("hello", 3));//5
        System.out.println(s.lastIndexOf("hello"));//5
        System.out.println(s.lastIndexOf("hello", 4));//0
        System.out.println(s.lastIndexOf("hello", 5));//5 第5个位置刚好是hello
    }

    /**
     * String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所 oldChar 得到的。
     * String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所匹配字面值目标序列的子字符串。
     * String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所匹配给定的正则表达式的子字符串。
     * String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
     */
    @Test
    public void replaceMethod() {
        String s = "hello worlld123";
        System.out.println(s.replace('o', 'z'));//hellz wzrlld123  o->z 字符替换 全部替换
        System.out.println(s.replace("ll", "yy"));//heyyo woryyd123 字符串替换 全部替换
        System.out.println(s.replaceAll("\\d", "a"));//hello worlldaaa 正则替换 全部替换
        System.out.println(s.replaceFirst("ll", "k"));//heko worlld123 字符串（正则）替换 第一个匹配项
        System.out.println(s.replaceFirst("\\d", "k"));//hello worlldk23 正则替换第一个匹配项

    }

    /**
     * boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
     */
    @Test
    public void matchesMethod() {
        String regex = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        String email = "chengpeng天才@c.com";
        System.out.println(email.matches(regex));//true
        System.out.println("helloworld".matches(regex));//false

    }

    /**
     * String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
     * String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
     */
    @Test
    public void splitMethod() {
        String s = "a1b1c3c886d6e";
        String[] split = s.split("\\d");//数字匹配
        System.out.println(Arrays.toString(split));//[a, b, c, c, , , d, e] 按正则切割
        String[] split1 = s.split("\\d", 5);
        System.out.println(Arrays.toString(split1));//[a, b, c, c, 86d6e] 限制为5长度
    }
}
