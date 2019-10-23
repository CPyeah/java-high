package org.cp.methodReference;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * 方法引用
 * 当要传递给Lambda体的操作，已经实现的方法了，可以使用方法引用
 * 类(或对象) :: 方法名
 * create by CP on 2019/10/21 0021.
 */
public class MethodRefTest {

    /**
     * 要求: 形参列表和返回值类型相同
     *  此例中, lambda表达式的形参str与method1的形参str相同
     */
    @Test
    public void test1() {
        //lambda 写法
        Consumer<String> lambda = str -> MethodRefTest.method1(str);
        lambda.accept("lambda");
        System.out.println();

        //方法引用
        Consumer<String> consumer = MethodRefTest::method1;
        consumer.accept("method reference");
    }

    public static void method1(String str) {
        System.out.println("hello " + str);
    }
    
}
