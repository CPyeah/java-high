package org.cp.reflection.proxy;

import org.junit.Test;

/**
 * create by CP on 2019/9/30 0030.
 */
public class ProxyTest {

    /**
     * 静态代理测试
     */
    @Test
    public void staticProxy() {
        Star star = new Star();
        StarProxy starProxy = new StarProxy(star);
        starProxy.sing();
        String dance = starProxy.dance();
        System.out.println(dance);
    }

    /**
     * 动态代理测试
     */
    @Test
    public void autoProxy() {
    
    }
    
}
