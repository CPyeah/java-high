package org.cp.constructerReference;

import org.cp.entities.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用
 * create by CP on 2019/11/5 0005.
 */
public class ConstructorRefTest {

    @Test
    public void test1() {
        Supplier<Employee> supplier = () -> new Employee("cp", 18);
        System.out.println(supplier.get());

        //找空参构造器
        Supplier<Employee> supplier1 = Employee::new;
        System.out.println(supplier1.get());
    }

    @Test
    public void test2() {
        Function<String, Employee> function = name -> new Employee(name, 18);
        System.out.println(function.apply("jing"));

        //找有一个参数<String>的构造器
        Function<String, Employee> function1 = Employee::new;
        System.out.println(function1.apply("jing"));

        //找有一个参数<Integer>的构造器
        Function<Integer, Employee> function2 = Employee::new;
        System.out.println(function2.apply(22));

    }

    @Test
    public void test3() {
        BiFunction<String, Integer, Employee> biFunction = (name, age) -> new Employee(name, age);
        System.out.println(biFunction.apply("cp", 21));

        //找到有两个参数<String, Integer>的构造器
        BiFunction<String, Integer, Employee> biFunction1 = Employee::new;
        System.out.println(biFunction1.apply("jing", 18));
    }

    @Test
    public void test4() {
        Function<Integer, ArrayList> function = capacity -> new ArrayList(capacity);
        System.out.println(function.apply(6));

        //效果同上
        Function<Integer, ArrayList> function1 = ArrayList::new;
        System.out.println(function1.apply(7));
    }

}
