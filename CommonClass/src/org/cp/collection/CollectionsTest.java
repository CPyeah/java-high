package org.cp.collection;

import org.junit.Test;

import java.util.*;

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
//        list.add("A");
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

    /**
     * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
     */
    @Test
    public void swapTest() {
        printList();//[A, C, B, F, E]
        Collections.swap(list, 2,3);
        printList();//[A, C, F, B, E]
    }

    /**
     * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
     */
    @Test
    public void frequencyTest() {
        printList();//[A, C, B, F, E, A]
        int count = Collections.frequency(list, "A");
        System.out.println(count);//2
    }

    /**
     * void copy(List dest,List src)：将src中的内容复制到dest中
     */
    @Test
    public void copyTest() {
//        List newList = new ArrayList();//直接new行不通, Source does not fit in dest
        List newList = Arrays.asList(new Object[list.size()]);//需要初始化相同大小的容器
        System.out.println(newList);//[null, null, null, null, null]
        Collections.copy(newList, list);
        System.out.println(newList);//[A, C, B, F, E]
    }

    /**
     * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所旧值
     */
    @Test
    public void replaceTest() {
        printList();//[A, C, B, F, E]
        Collections.replaceAll(list, "C", "Z");
        printList();//[A, Z, B, F, E]
    }

    //打印列表工具方法
    private void printList() {
        System.out.println("//"+list);
        System.out.println("***************************");
    }

}
