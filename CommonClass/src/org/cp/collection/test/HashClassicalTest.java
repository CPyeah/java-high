/**
 * Copyright (C)
 * FileName: HashClassicalTest
 * Author:   cp
 * Date:     2019/8/24 12:11
 * Description: HashSet 经典问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp.collection.test;

import org.junit.Test;

import java.util.HashSet;

/**
 * 〈一句话功能简述〉<br> 
 * 〈HashSet 经典问题〉
 *
 * @author cp
 * @create 2019/8/24
 * @since 1.0.0
 */
public class HashClassicalTest {

    @Test
    public void pptest() {
//        System.out.println(541234123&7);
        PP p1 = new PP(1001, "AA");
        PP p2 = new PP(1002, "BB");
        HashSet<PP> pps = new HashSet<>();
        pps.add(p1);
        pps.add(p2);
        System.out.println(pps);
        p1.name = "CC";
        pps.remove(p1);//此时p1的属性值变了，计算出的Hash值与之前不同，所以remove不掉
        System.out.println(pps);

        pps.add(new PP(1001, "CC"));//判断Hash值不等，所以能加进去
        System.out.println(pps);

        pps.add(new PP(1001, "AA"));//判断值不等，也能加进入
        System.out.println(pps);
    }

}
