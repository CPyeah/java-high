package org.cp.constructerReference;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 数组的构造器引用
 * create by CP on 2019/11/5 0005.
 */
public class ArrayRefTest {

    @Test
    public void test1() {
        Supplier<String[]> supplier = () -> new String[1];
        System.out.println(supplier.get());

        //没有无参构造器, 编译不通过
//        Supplier<String[]> supplier1 = String[]::new;
    }

    @Test
    public void test2() {
        Function<Integer, String[]> function = capacity -> new String[capacity];
        System.out.println(function.apply(1));
    }

}
