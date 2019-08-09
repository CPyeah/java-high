package org.cp.javadate;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * jdk 1.8 提出了新的一套API
 * 本地日期、本地时间、本地日期时间的使用：LocalDate / LocalTime / LocalDateTime
 * create by CP on 2019/8/9 0009.
 */
public class Jdk8LocalDateTimeTest {

    /**
     * LocalDate 测试
     */
    @Test
    public void LocalDateTest() {
        LocalDate localDate = LocalDate.now();//获取当前日期
        System.out.println(localDate);//2019-08-09
        LocalDate localDate1 = LocalDate.of(2020, 12, 15);
        System.out.println(localDate1);//2020-12-15
        System.out.println(localDate1.getDayOfYear());//350
        System.out.println(localDate1.getDayOfMonth());//15
        System.out.println(localDate1.getDayOfWeek());//TUESDAY
        LocalDate localDate2 = localDate1.withYear(2019);//修改年份， 不会影响到原来的localDate
        System.out.println(localDate1);//2020-12-15
        System.out.println(localDate2);//2019-12-15
        LocalDate localDate3 = localDate1.plusMonths(3);
        System.out.println(localDate1);//2020-12-15
        System.out.println(localDate3);//2021-03-15 加三个月
        LocalDate localDate4 = localDate1.plusMonths(3).minusDays(5);// 加三月 减5天
        System.out.println(localDate4);//2021-03-10

    }

    /**
     * 常用LocalDateTime 类
     * 包含 日期和时间
     */
    @Test
    public void LocalDateTimeTest() {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime dateTime = LocalDateTime.of(2020, 12, 15, 9, 30, 5);
        System.out.println(dateTime);

        //获取 12 月有多少天
        LocalDateTime begin = dateTime.withDayOfMonth(1);
        LocalDateTime end = begin.plusMonths(1);
        Duration between = Duration.between(begin, end);
        System.out.println(between.toDays());

    }

}
