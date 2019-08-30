package org.cp.generics;

/**
 * Order的子类, 泛型继承
 * create by CP on 2019/8/29 0029.
 */
public class SubOrder<T> extends Order<T>{

    public SubOrder(int i, String subOrder, T v) {
    }

    //这个泛型方法
    public <E>E valueOf(E key) {
        return key;
    }
}
