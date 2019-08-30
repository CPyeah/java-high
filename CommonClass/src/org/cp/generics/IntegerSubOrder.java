package org.cp.generics;

/**
 * Integer泛型Order实现, 确定orderT的类型
 * 在IntegerSubOrder中是不带泛型了
 * create by CP on 2019/8/30 0030.
 */
public class IntegerSubOrder extends Order<Integer> {
    public IntegerSubOrder(int i, String s, Integer i1) {
        this.setId(i);
        this.setName(s);
        this.setOrderT(i1);
    }
}
