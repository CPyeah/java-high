package org.cp.javadate;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java时间测试
 * create by CP on 2019/8/7 0007.
 */
public class DateTest {

    @Test
    public void getCurrentDate() {
        Long mills = System.currentTimeMillis();
        System.out.println(mills);
    }

    @Test
    public void utilDateTest() {
        java.util.Date date = new java.util.Date();
        System.out.println(date);
        System.out.println(date.getTime());
    }

    @Test
    public void sqlDateTest() {
        java.sql.Date date = new java.sql.Date(1565163217760L);
        System.out.println(date);
        System.out.println(date.getTime());//获取时间戳
        java.util.Date date1 = new Date(date.getTime());//sql Date 转到 util Date
        System.out.println(date1);
    }

    /**
     * DateFormat 测试
     */
    @Test
    public void dateFormatTest() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(new Date()));
        Date parse = dateFormat.parse("2019-07-31");
        System.out.println(parse);
    }

}
