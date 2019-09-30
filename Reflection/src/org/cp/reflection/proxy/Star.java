package org.cp.reflection.proxy;

import java.util.Date;

/**
 * 被代理类
 * create by CP on 2019/9/30 0030.
 */
public class Star implements Starable {
    @Override
    public void sing() {
        System.out.println("我喜欢唱...");
    }

    @Override
    public String dance() {
        return "不如跳舞";
    }

    @Override
    public Object rap(String s) {
        System.out.println(s + " skr");
        return new Date();
    }

    @Override
    public void basketball(Object o) {
        System.out.println(o + "制霸!");
    }
}
