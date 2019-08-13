/**
 * Copyright (C)
 * FileName: Practice04
 * Author:   cp
 * Date:     2019/8/12 22:35
 * Description: 第四天习题（时间、比较器）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp.others;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈第四天习题（时间、比较器）〉
 *
 * @author cp
 * @create 2019/8/12
 * @since 1.0.0
 */
public class Practice04 {

    /**
     *1.    将字符串”2017-08-16”转换为对应的java.sql.Date类的对象。
     * （使用JDK8之前或JDK8中的API皆可）
     */
    @Test
    public void test1() {
        String s = "2017-08-16";
        LocalDate localDate = LocalDate.parse(s);
        System.out.println(localDate);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        Instant instant = zonedDateTime.toInstant();
        System.out.println(instant);
        Date d = Date.from(instant);
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        System.out.println(sqlDate);

        // 这种方式很简单
        java.sql.Date date = java.sql.Date.valueOf(localDate);
        System.out.println(date);
    }

    /**
     * 2.    解释何为编码？解码？ 何为日期时间的格式化？解析？
     */
    @Test
    public void test2() {

        String name = "程鹏";
        // 字符串编码
        byte[] bytes = name.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        //解码
        String s = new String(bytes);
        System.out.println(s);

    }

    /**
     *  3. 自定义Person类如下，如何实现自然排序（按姓名从小到大排序），代码说明
     */
    @Test
    public void test3() {

    }

    /**
     *  4. 提供定制排序涉及到的接口的实现类对象，并按Person类的年龄从大到小排序
     */
    @Test
    public void test4() {

    }

    /**
     *  5. JDK 8之前和JDK8中日期、时间相关的类分别有哪些？
     */
    @Test
    public void test5() {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        Instant instant = Instant.now();

        System.out.println(date);
        System.out.println(sqlDate);
        System.out.println(calendar);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(instant);
    }


}
