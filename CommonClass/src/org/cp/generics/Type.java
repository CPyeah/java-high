package org.cp.generics;

/**
 * 带泛型的类
 * create by CP on 2019/8/27 0027.
 */
public class Type<T> {

    T type;

    Type(T type) {
        this.type = type;
    }

    public T getType() {
        return type;
    }
}
