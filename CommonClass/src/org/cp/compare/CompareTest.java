/**
 * Copyright (C)
 * FileName: CompareTest
 * Author:   cp
 * Date:     2019/8/12 21:28
 * Description: java类 比较
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 〈一句话功能简述〉<br> 
 * 〈java类 比较〉
 *
 * @author cp
 * @create 2019/8/12
 * @since 1.0.0
 */
public class CompareTest {

    /**
     * String 类 比较
     * Arrays.sort()
     * 自然排序
     */
    @Test
    public void stringArrayCompareTest() {
        String[] strings = new String[7];
        strings[0] = "BB";
        strings[1] = "CC";
        strings[2] = "FF";
        strings[3] = "AA";
        strings[4] = "DD";
        strings[5] = "CCC";
        strings[6] = "EE";
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));//[AA, BB, CC, CCC, DD, EE, FF]
    }

    /**
     * 鼠标实体类比较
     */
    @Test
    public void mouseCompareTest() {
        ArrayList<Mouse> mice = new ArrayList<>();
        mice.add(new Mouse("dell", 60.0));
        mice.add(new Mouse("hp", 77.0));
        mice.add(new Mouse("mi", 40.0));
        Collections.sort(mice);
        for (Mouse m : mice) {
            System.out.println(m);
        }
        //Mouse{name='mi', price=40.0}
        //Mouse{name='dell', price=60.0}
        //Mouse{name='hp', price=77.0}
    }

    /**
     * comparator 接口 自定义排序
     * 当元素的类型没实现java.lang.Comparable接口而又不方便修改代码，
     * 或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
     * 那么可以考虑使用 Comparator 的对象来排序
     *
     * 字符串数据从大到小排序
     *
     */
    @Test
    public void comparatorStringArrayTest() {
        String[] strings = new String[7];
        strings[0] = "BB";
        strings[1] = "CC";
        strings[2] = "FF";
        strings[3] = "AA";
        strings[4] = "DD";
        strings[5] = "CCC";
        strings[6] = "EE";
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(strings));//[FF, EE, DD, CCC, CC, BB, AA]
    }

    /**
     * 通过 comparator 对 鼠标列表排序
     */
    @Test
    public void comparatorMouseTest() {
        ArrayList<Mouse> mice = new ArrayList<>();
        mice.add(new Mouse("dell", 60.0));
        mice.add(new Mouse("hp", 77.0));
        mice.add(new Mouse("mi", 40.0));
        //按名称大小倒序
        Collections.sort(mice, new Comparator<Mouse>() {
            @Override
            public int compare(Mouse o1, Mouse o2) {
                return -o1.getName().compareTo(o2.getName());
            }
        });
        for (Mouse m : mice) {
            System.out.println(m);
        }
        //Mouse{name='mi', price=40.0}
        //Mouse{name='hp', price=77.0}
        //Mouse{name='dell', price=60.0}
    }


}
