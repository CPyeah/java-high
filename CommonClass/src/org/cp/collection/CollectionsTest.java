package org.cp.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collections 工具类 测试
 * create by CP on 2019/8/22 0022.
 */
public class CollectionsTest {

    private static List<String> list = new ArrayList<>();
    static {
        list.add("A");
        list.add("C");
        list.add("B");
        list.add("F");
        list.add("E");
    }

    /**
     * 反转
     */
    @Test
    public void reverseTest() {
        printList();//[A, C, B, F, E]
        Collections.reverse(list);
        printList();//[E, F, B, C, A]
    }

    /**
     * 随机排序
     */
    @Test
    public void shuffleTest() {
        printList();//[A, C, B, F, E]
        Collections.shuffle(list);
        printList();// 每次顺序不一样,起一个打乱顺序的作用
    }

    /**
     * 自然排序
     */
    @Test
    public void sortTest() {
        printList();//[A, C, B, F, E]
        Collections.sort(list);//自然排序
        printList();//[A, B, C, E, F]
        //自定义排序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        printList();//[F, E, C, B, A]
    }

    //打印列表工具方法
    private void printList() {
        System.out.println(list);
        System.out.println("***************************");
    }

}
