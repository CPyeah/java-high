package org.cp.enumeration;

import org.junit.Test;

import java.util.Arrays;

import static org.cp.enumeration.Season.AUTUMN;
import static org.cp.enumeration.Season.SPRING;
import static org.cp.enumeration.Season.SUMMER;

/**
 * 枚举类测试
 * create by CP on 2019/8/14 0014.
 */
public class EnumTest {

    @Test
    public void test() {
        System.out.println(SPRING);
        Season[] values = Season.values();
        System.out.println(Arrays.toString(values));
        System.out.println(Season.getSeasonByMonth("10"));
        System.out.println(Arrays.toString(AUTUMN.getTimes()));
        System.out.println(SUMMER.getName() + " 是 " + SUMMER.getDesc());
    }
}
