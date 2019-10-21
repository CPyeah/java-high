package org.cp.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda的六种情况
 * 总结六种情况：
 * ->左边：lambda形参列表的参数类型可以省略(类型推断)；
 *          如果lambda形参列表只一个参数，其一对()也可以省略
 * ->右边：lambda体应该使用一对{}包裹；
 *          如果lambda体只一条执行语句（可能是return语句，省略这一对{}和return关键字
 * create by CP on 2019/10/21 0021.
 */
public class SixSituation {

    /**
     * 无参, 无返回值
     */
    @Test
    public void test1() {
        Runnable runnable = () -> {
            System.out.println("1");
            System.out.println("2");
        };
        //如果函数体里面只有一行代码的话, 大括号可以省略
        Runnable runnable1 = () -> System.out.println("1");
    }

    /**
     * 有一个参数, 没有返回值
     */
    @Test
    public void test2() {
        Consumer<String> consumer = (String str) -> {
            System.out.println(str);
        };
    }

    /**
     * 有一个参数, 没有返回值
     * 参数类型可以省略, 编译器可自动推断出
     */
    @Test
    public void test3() {
        //参数类型可以简化省略
        Consumer<String> consumer1 = (str) -> System.out.println(str);
    }

    /**
     * 有一个参数, 没有返回值
     * 小括号可省略
     */
    @Test
    public void test4() {
        Consumer<String> consumer = str -> System.out.println(str);
    }

    /**
     * 两个参数, 函数体不一定
     * 形参用小括号包住, 可省略参数类型
     */
    @Test
    public void test5() {
        Comparator<Integer> comparator = (a, b) -> {
            System.out.println(a + " : " + b);
            return Integer.compare(a, b);
        };
    }

    /**
     * 函数体只有一条return语句
     * 可省略大括号与return关键字
     */
    @Test
    public void test6() {
        Comparator<Integer> comparator = (a, b) -> Integer.compare(a, b);
    }

}
