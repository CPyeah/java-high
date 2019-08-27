package org.cp.generics;

import org.junit.Test;

/**
 * hello java 泛型
 * create by CP on 2019/8/27 0027.
 */
public class GenericsTest {

    @Test
    public void test1() {
        Type<StringBuilder> abc = new Type<>(new StringBuilder("abc"));
//        Type<StringBuilder> def = new Type<>(new StringBuffer("abc"));//这种情况编译不通过
        System.out.println(abc.getType());//abc
        System.out.println(abc.getType().getClass().getName());//java.lang.StringBuilder

        NoType abc1 = new NoType(new StringBuilder("abc"));
        NoType def1 = new NoType(new StringBuffer("def"));
        System.out.println(abc1.getType());//abc
        System.out.println(abc1.getType().getClass().getName());//java.lang.StringBuilder
        System.out.println(def1.getType().getClass().getName());//java.lang.StringBuffer
    }

}
