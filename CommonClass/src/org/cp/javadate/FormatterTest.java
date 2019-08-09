package org.cp.javadate;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * 新版时间日期格式化
 * 类似 SimpleDateFormat
 * create by CP on 2019/8/9 0009.
 */
public class FormatterTest {

    @Test
    public void test() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = "2020-12-15 18:01:01";
        TemporalAccessor temporalAccessor = dateTimeFormatter.parse(s);
        System.out.println(temporalAccessor);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(dateTimeFormatter.format(now));
    }

}
