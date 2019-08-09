package org.cp.javadate;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Calendar 日历类 测试
 * create by CP on 2019/8/8 0008.
 */
public class CalendarTest {

    /**
     * 构造 calendar 类
     */
    @Test
    public void calendarConstruct() {
        Calendar calendar = new GregorianCalendar();// 直接 new 公历日历对象
        System.out.println(calendar.getClass());
        Calendar calendar1 = Calendar.getInstance();// 通过 单例模式获取 推荐使用
        System.out.println(calendar1.getClass());

    }

    /**
     * Calendar常用方法
     */
    @Test
    public void commonMethods() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();// 2019-08-08
        //get
        System.out.println(simpleDateFormat.format(c.getTime()));//2019-08-08 10:46:47
        System.out.println(c.get(Calendar.DAY_OF_MONTH));//8
        System.out.println(c.get(Calendar.DAY_OF_WEEK));//5 （周四）
        System.out.println(c.get(Calendar.DAY_OF_YEAR));//220
        System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));//2
        System.out.println("-----------------------------------");
        //set 可改变日期
        c.set(Calendar.DAY_OF_MONTH, 22);
        System.out.println(simpleDateFormat.format(c.getTime()));//2019-08-22 10:46:47
        System.out.println("-----------------------------------");
        //add 日期滚动
        c.add(Calendar.DAY_OF_MONTH, -25);// 往前滚 25 天
        System.out.println(simpleDateFormat.format(c.getTime()));//2019-07-28 10:47:56
        c.add(Calendar.MONTH, 3);//往后滚 3 个月
        System.out.println(simpleDateFormat.format(c.getTime()));//2019-10-28 10:49:30
        System.out.println("-----------------------------------");
        c.set(2020, 12, 15, 18, 32, 59);
        System.out.println(simpleDateFormat.format(c.getTime()));//2021-01-15 18:32:59 之前add的偏移量会一直存在，而且新new的Calendar也不行
    }

    /**
     * Calendar 日历对象 月份、星期 偏移量
     */
    @Test
    public void calendarOffsetTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        // 这才是真正的 2018-08-09（星期五）
        calendar.set(2019, 7, 9);// 月份的计算是从0 开始 0-一月 1-二月 ... 11-十二月 12-第二年一月
        Date time = calendar.getTime();
        System.out.println(time);
        System.out.println(simpleDateFormat.format(time));
        //星期天 1；星期一 2；...... 星期六 7
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));//6 （星期五）

    }

}
