/**
 * Copyright (C)
 * FileName: SetTest
 * Author:   cp
 * Date:     2019/8/24 11:35
 * Description: 测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp.collection.test;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试类〉
 *
 * Set存储各个Employee
 * 按照 姓名、年龄、生日 排序
 * @author cp
 * @create 2019/8/24
 * @since 1.0.0
 */
public class SetTest {

    /**
     * 按照姓名自然排序
     */
    @Test
    public void sortByNameNature() {
        Set set = setDataInit(new TreeSet());
        set.forEach(System.out::println);
    }

    /**
     * 按照生日定制排序
     */
    @Test
    public void sortByBirthday() {
        TreeSet<Employee> employees = new TreeSet<>((e1, e2) -> (e1.getBirthday().compareTo(e2.getBirthday())));
        Set set = setDataInit(employees);
        set.forEach(System.out::println);
//        Employee{name='liudehua', age=58, birthday=MyDate{year=1961, month=9, day=27}}
//        Employee{name='guofucheng', age=54, birthday=MyDate{year=1965, month=10, day=26}}
//        Employee{name='liming', age=53, birthday=MyDate{year=1966, month=12, day=11}}
        //张学友和刘德华同岁,比较时,是按照生日年份比较,所以张学友没有添加进来
    }

    /**
     * 按照生日自然排序
     */
    @Test
    public void sortByBirthdayNature() {
        Set set = setDataInit(new TreeSet());
        set.forEach(System.out::println);
    }

    //数据初始化
    private Set setDataInit(TreeSet<Employee> set) {
        set.add(new Employee("liudehua", LocalDate.now().getYear()-1961, new MyDate(1961, 9, 27)));
        set.add(new Employee("zhangxueyou", LocalDate.now().getYear()-1961, new MyDate(1961, 7, 10)));
        set.add(new Employee("guofucheng", LocalDate.now().getYear()-1965, new MyDate(1965, 10, 26)));
        set.add(new Employee("liming", LocalDate.now().getYear()-1966, new MyDate(1966, 12, 11)));
        return set;
    }

}
