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
     * 无序、不重复
     */
    @Test
    public void test1() {
        HashSet<Object> set = new HashSet<>();
        set.add("A");
        set.add("A");
        set.add("B");
        System.out.println(set);//[A, B]
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
