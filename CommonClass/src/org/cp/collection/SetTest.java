package org.cp.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * create by CP on 2019/8/20 0020.
 */
public class SetTest {

    /**
     * HashSet 的底层是一个HashMap,
     * set中的值放入map的key中的位置,value放一个空的object,
     *  不重复性: 先判断hash值是否相同, 在调用equals()判断内容是否相同(一般对象的equals()和hashCode()方法对应)
     *
     *  hash存储本质:
     *      1.底层new一个数组, 初始容积16(如果数组使用率达到0.75, 则扩容一倍)
     *      2.通过调用对象的hashCode()方法,获取到一个hash值
     *      3.通过散列计算,算出它在数组中的位置
     *      4.看该位置上有没有元素,没有的话,就把该对象放进去
     *      5.如果已有元素, 与该元素equals()比较, 如相等,则表示相同,剔除
     *      6.如不等, 以链表结构接在下面(jdk7以前是接在上面)
     *
     * 无序、不重复
     */
    @Test
    public void test1() {
        HashSet<Object> set = new HashSet<>();
        set.add("A");
        set.add("A");
        set.add("B");
        //如果重写了hashCode()和equals()方法, Person只会存在一个
        set.add(new Person("z", 12));
        set.add(new Person("z", 12));
        set.forEach(item-> System.out.println(item));
        System.out.println(set);//[A, B, Person{name='z', age=12}]
        System.out.println((1<<5)-1);
    }

    /**
     * set 去重
     */
    @Test
    public void removeRepeatItem() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);//[A, A, B, C]
        Set set = new HashSet(list);
        System.out.println(set);//[A, B, C]
        list = new ArrayList<>(set);
        System.out.println(list);//[A, B, C]
    }

}
