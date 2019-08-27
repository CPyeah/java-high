package org.cp.generics;

/**
 * 不带泛型的类
 * create by CP on 2019/8/27 0027.
 */
public class NoType {

    Object type;

    NoType(Object type) {
        this.type = type;
    }

    public Object getType() {
        return type;
    }
}
