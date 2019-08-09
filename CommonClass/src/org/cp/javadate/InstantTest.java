package org.cp.javadate;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Instant 类
 * 类似时间戳
 * create by CP on 2019/8/9 0009.
 */
public class InstantTest {
    @Test
    public void test1() {
        Instant now = Instant.now();//有时差 Clock.systemUTC().instant();
        System.out.println(now);//2019-08-09T05:59:15.907Z 格林威治时间 早了8小时
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));// 偏移8小时
        System.out.println(offsetDateTime);// 2019-08-09T14:07:44.855+08:00
    }
}
