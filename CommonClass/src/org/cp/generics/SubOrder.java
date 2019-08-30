package org.cp.generics;

/**
 * Order的子类, 泛型继承
 * create by CP on 2019/8/29 0029.
 */
public class SubOrder<T> extends Order<T>{

    public SubOrder(int i, String subOrder, T v) {
    }

    //正常带泛型的方法, 不能声明为静态的. 因为static先加载, 这时候泛型T还未确定
//    public static T valuesOf1(T key) {
//        return (T) new Object();
//    }

    //这个泛型方法
    public <E>E valueOf(E key) {
        return key;
    }

    //静态方法也可以
    public static <K>K valuesOf(K key) {
        return key;
    }
}
