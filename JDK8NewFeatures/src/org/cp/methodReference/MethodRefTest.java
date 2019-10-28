package org.cp.methodReference;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 * 当要传递给Lambda体的操作，已经实现的方法了，可以使用方法引用
 * 类(或对象) :: 方法名
 * create by CP on 2019/10/21 0021.
 */
public class MethodRefTest {

    /**
     * 类::静态方法
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

    public void method2(String str) {
        System.out.println("hello " + str);
    }

    public String method3() {
        return ("hello !");
    }

    /**
     * 对象::方法
     */
    @Test
    public void test2() {
        PrintStream out = System.out;
        Consumer<String> consumer = out :: println;
        consumer.accept("method reference");

        MethodRefTest methodRefTest = new MethodRefTest();
        Consumer<String> consumer1 = str -> methodRefTest.method2(str);
        Consumer<String> consumer2 = methodRefTest::method2;
        Consumer<String> consumer3 = this::method2;
        consumer1.accept("method reference");
        consumer2.accept("method reference");
        consumer3.accept("method reference");

        Supplier<String> supplier = this::method3;
        System.out.println(supplier.get());
    }

    /**
     * 类 :: 实例方法  (难度)
     */
    @Test
    public void test3() {
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        Comparator<String> comparator1 = String::compareTo;
        System.out.println(comparator.compare("a", "r"));
        System.out.println(comparator1.compare("a", "r"));
    }

    /**
     * 类 :: 实例方法  (难度)
     */
    @Test
    public void test4() {
        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equalsIgnoreCase(s2);

        BiPredicate<String, String> biPredicate1 = String::equalsIgnoreCase;
        System.out.println(biPredicate.test("hello", "hello"));
        System.out.println(biPredicate1.test("hello", "hello"));
    }

    /**
     * 类 :: 实例方法  (难度)
     */
    @Test
    public void test5() {
        Function<MethodRefTest, String> function = methodRefTest -> methodRefTest.method3();
        System.out.println(function.apply(this));

        Function<MethodRefTest, String> function1 = MethodRefTest::method3;
        System.out.println(function1.apply(this));
    }



}
