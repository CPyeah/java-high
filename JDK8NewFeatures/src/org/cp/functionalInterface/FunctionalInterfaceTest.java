package org.cp.functionalInterface;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口
 * > 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。
 * > 我们可以在一个接口上使用 @FunctionalInterface 注解，这样做可以检查它是否是一个函数式接口。
 * > Lambda表达式的本质：作为函数式接口的实例
 * 
 * create by CP on 2019/10/21 0021.
 */
public class FunctionalInterfaceTest {

    /**
     * 消费者 Consumer 接口
     * 一个参数, 没有返回值
     */
    @Test
    public void test1() {
        Consumer<String> consumer = str -> {
            System.out.println("hello " + str + "!");
        };
        consumer.accept("zhuzhu");
    }

    /**
     * 供给者 Supplier 函数接口
     * 没有参数 有返回值
     */
    @Test
    public void test2() {
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        Supplier<LocalDateTime> supplier1 = LocalDateTime::now;
        System.out.println(supplier.get());
        System.out.println(supplier1.get());
    }

    /**
     * 函数 Function 函数式接口
     * 有一个参数, 一个返回值
     */
    @Test
    public void test3() {
        Function<String, Integer> getAsc= (str) -> {
            byte[] bytes = str.getBytes();
            return Integer.valueOf(bytes[0]);
        };
        System.out.println(getAsc.apply("A"));
    }

    /**
     * 断言判断 Predicate
     * 一个参数, 返回一个Boolean类型
     */
    @Test
    public void test4() {
        Predicate<Character> isK = character -> 'k' == character || 'K' ==character;
        System.out.println(isK.test('k'));
        System.out.println(isK.test('b'));
        System.out.println(isK.test('K'));
    }
    
}
