/**
 * Copyright (C)
 * FileName: MathTest
 * Author:   cp
 * Date:     2019/8/12 22:03
 * Description: Math 类 测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp.others;

import org.junit.Test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Math 类 测试〉
 *
 * java.lang.Math提供了一系列静态方法用于科学计算。
 * 其方法的参数和返回值类型一般为double型。
 *
 * @author cp
 * @create 2019/8/12
 * @since 1.0.0
 */
public class MathTest {

    /**
     *Math.sqrt()//计算平方根
     *Math.cbrt()//计算立方根
     *Math.pow(a, b)//计算a的b次方
     *Math.max( , );//计算最大值
     *Math.min( , );//计算最小值
     */
    @Test
    public void test1() {
        double sqrt = Math.sqrt(26);
        System.out.println(sqrt);
        double cbrt = Math.cbrt(1024.3);
        System.out.println(cbrt);
        double pow = Math.pow(2, 3);//计算 2 的 3 次方
        System.out.println(pow);
        int max = Math.max(12, 21);
        System.out.println(max);
        int min = Math.min(56, 65);
        System.out.println(min);
    }

    /**
     * abs求绝对值
     */
    @Test
    public void test2() {
        int abs = Math.abs(123);
        int abs1 = Math.abs(-123);
        System.out.println(abs == abs1);
    }

    /**
     * ceil天花板的意思，就是返回大的值
     * 进位 取整
     */
    @Test
    public void test3() {
        double ceil = Math.ceil(1.22);
        System.out.println(ceil);
        double ceil1 = Math.ceil(-1.22);
        System.out.println(ceil1);
    }

    /**
     * floor地板的意思，就是返回小的值
     * 舍位 取整
     */
    @Test
    public void test4() {
        double floor = Math.floor(1.22);
        System.out.println(floor);
        double floor1 = Math.floor(-1.22);
        System.out.println(floor1);
    }

    /**
     * random 取得一个大于或者等于0.0小于不等于1.0的随机数
     */
    @Test
    public void test5() {
        double random = Math.random();
        System.out.println(random);
        int r = (int) (random * 100);
        System.out.println(r);
    }

}
