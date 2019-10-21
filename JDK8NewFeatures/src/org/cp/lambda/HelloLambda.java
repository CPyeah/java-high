package org.cp.lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * lambda
 * create by CP on 2019/10/21 0021.
 */
public class HelloLambda {
    
    @Test
    public void test1() {
        //老式写法
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("old...");
            }
        };
        //lambda写法
        Runnable runnable2 = () -> {
            System.out.println("lambda...");
        };
        //lambda写法(省略大括号)
        Runnable runnable3 = () -> System.out.println("lambda...");

        new Thread(runnable1).start();
        new Thread(runnable2).start();
        new Thread(runnable3).start();
    }


    @Test
    public void test2() {
        //匿名写法
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparator1.compare(11, 14));

        //lambda写法1(完全体)
        Comparator<Integer> comparator21 = (o1, o2) -> {
            return Integer.compare(o1, o2);
        };
        System.out.println(comparator21.compare(11, 14));

        //lambda写法2(简略体)
        Comparator<Integer> comparator22 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator22.compare(11, 14));

        //方法引用(优雅)
        Comparator<Integer> comparator3 = Integer::compareTo;
        System.out.println(comparator3.compare(11, 14));
    }


    
}
