package org.cp.javadate;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * Duration 时间间隔
 * Period 日期间隔
 * create by CP on 2019/8/9 0009.
 */
public class DurationAndPeriodTest {

    /**
     * 时间间隔测试
     */
    @Test
    public void durationTest() {
        LocalDateTime begin = LocalDateTime.of(2019, 12, 15, 8, 30, 0);
        LocalDateTime end = LocalDateTime.of(2019, 12, 15, 8, 30, 1);
        Duration between = Duration.between(begin, end);
        System.out.println(between.toMillis());//1000 ms
        System.out.println(between.toNanos());//1000000000 ns
        System.out.println(between.toDays());//0 days

    }

    /**
     * 时间间隔测试
     */
    @Test
    public void durationTest1() {
        LocalDateTime begin = LocalDateTime.of(2018, 12, 15, 8, 30, 0);
        LocalDateTime end = LocalDateTime.of(2019, 12, 15, 8, 30, 1);
        Duration between = Duration.between(begin, end);
        // to 是转为 以什么为单位的形式
        System.out.println(between.toMillis());//31536001000 ms
        System.out.println(between.toNanos());//31536001000000000 ns
        //用这个算天数很好用
        System.out.println(between.toDays());//365 days

        //get 是获取 Duration的属性
        System.out.println(between.getNano());//0
    }

    @Test
    public void periodTest() {
        LocalDate begin = LocalDate.of(2020, 12, 15);
        LocalDate end = LocalDate.of(2022, 11, 17);
        Period period = Period.between(begin, end);
        System.out.println(period);//P1Y11M2D 相差 1年 11个月 2天
        System.out.println(period.toTotalMonths());//23
        // period 没有 toXXX() 方法，不能方便的查看他有多少天、小时，分钟
    }

}
