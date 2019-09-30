package org.cp.reflection.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

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
        Star star = new Star();
        MyInvocationHandler<Starable> invocationHandler = new MyInvocationHandler<>(star);
        ClassLoader classLoader = Star.class.getClassLoader();
        Class<?>[] interfaces = Star.class.getInterfaces();
        Starable proxy = (Starable) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        proxy.sing();
        String dance = proxy.dance();
        System.out.println(dance);
    }
    
}
