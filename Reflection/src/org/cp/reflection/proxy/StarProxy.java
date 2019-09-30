package org.cp.reflection.proxy;

/**
 * create by CP on 2019/9/30 0030.
 */
public class StarProxy implements Starable {

    private Starable star;

    private StarProxy() {
    }

    public StarProxy(Starable star) {
        this.star = star;
    }

    @Override
    public void sing() {
        System.out.println("proxy before");
        star.sing();
        System.out.println("after");
    }

    @Override
    public String dance() {
        System.out.println("proxy before");
        String dance = star.dance();
        System.out.println("after");
        return dance;
    }

    @Override
    public Object rap(String s) {
        return null;
    }

    @Override
    public void basketball(Object o) {

    }
}
