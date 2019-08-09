package org.cp.javadate;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 *      练习一：字符串"2020-09-08"转换为java.sql.Date
 *
 *     练习二："三天打渔两天晒网"   1990-01-01  xxxx-xx-xx 打渔？晒网？
 *
 *     举例：2020-09-08 ？ 总天数
 *
 *     总天数 % 5 == 1,2,3 : 打渔
 *     总天数 % 5 == 4,0 : 晒网
 *
 *     总天数的计算？
 *     方式一：( date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
 *     方式二：1990-01-01  --> 2019-12-31  +  2020-01-01 -->2020-09-08
 * create by CP on 2019/8/7 0007.
 */
public class Practice {

    @Test
    public void test1() throws ParseException {
        String s = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date utilDate = sdf.parse(s);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println(sqlDate);
    }

    @Test
    public void test2() throws ParseException {
        String begin = "1990-01-01";
        String end = "2020-09-08";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = df.parse(begin);
        Date endDate = df.parse(end);
        Long interval = endDate.getTime() - beginDate.getTime();
        System.out.println("间隔毫秒数： " + interval);
        Long days = interval / (1000 * 60 * 60 * 24) + 1;
        System.out.println("间隔天数： " + days);
        int i = days.intValue() % 5;
        String action = i <= 3 ? "打渔" : "晒网";
        System.out.println("这是第 " + i + " 天， 所以在" + action);//4 第四天，所以在晒网
    }

    /**
     * 三天打鱼两天晒网 新版 LocalDate 写法
     *         String begin = "1990-01-01";
     *         String end = "2020-09-08";
     */
    @Test
    public void test2_1() {
        LocalDate begin = LocalDate.of(1990, 1, 1);
        LocalDate end = LocalDate.of(2020, 9, 8);
        Period between = Period.between(begin, end);
        //The Epoch Day count is a simple incrementing count of days where day 0 is 1970-01-01 (ISO). This definition is the same for all chronologies, enabling conversion.
        System.out.println(begin.toEpochDay());
        int days = (int) (end.toEpochDay() - begin.toEpochDay()) + 1;
        System.out.println("间隔天数： " + days);
        int i = days % 5;
        String action = i <= 3 ? "打渔" : "晒网";
        System.out.println("这是第 " + i + " 天， 所以在" + action);//4 第四天，所以在晒网
    }

}
