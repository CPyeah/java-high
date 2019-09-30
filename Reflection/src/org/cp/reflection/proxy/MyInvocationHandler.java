package org.cp.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * create by CP on 2019/9/30 0030.
 */
public class MyInvocationHandler<T> implements InvocationHandler {

    private T target;

    public void setTarget(T target) {
        this.target = target;
    }

    public MyInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始代理");
        Object result = method.invoke(target, args);
        System.out.println("方法结束");
        return result;
    }
}
