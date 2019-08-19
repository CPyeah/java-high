package org.cp.collection;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 集合collection接口
 * create by CP on 2019/8/19 0019.
 */
public class CollectionTest {

    /**
     * Collection接口常用方法：
     * add(Object obj),addAll(Collection coll),size(),isEmpty(),clear();
     * contains(Object obj),containsAll(Collection coll),
     * remove(Object obj),removeAll(Collection coll),retainsAll(Collection coll),equals(Object obj);
     * hasCode(),toArray(),iterator();
     */
    @Test
    public void test1() {
        Collection c = new ArrayList();
        c.add("AA");
        c.add(123);
        c.add(new Object());
        System.out.println(c.size());//3
        System.out.println(c);//[AA, 123, java.lang.Object@22927a81]
        Collection c1 = new ArrayList();
        c1.add("BB");
        c1.add(456);
        c1.add(LocalDateTime.now());
        c.addAll(c1);
        System.out.println(c.size());//6
        System.out.println(c);//[AA, 123, java.lang.Object@6d7b4f4c, BB, 456, 2019-08-19T09:53:38.160]
        System.out.println(c.contains(123));//true
        System.out.println(c.contains(345));//false
        System.out.println(c1.isEmpty());//false
//        c1.clear();
//        System.out.println(c1.isEmpty());//true
        c.retainAll(c1);// 保留c1，其他移除
        System.out.println(c);//[BB, 456, 2019-08-19T09:53:38.160]
        Iterator iterator = c.iterator();
        System.out.println(iterator.hasNext());//true
        System.out.println(iterator.next());//BB
        iterator.remove();
        System.out.println(c);//[456, 2019-08-19T10:18:34.836]
    }

    /**
     * Collection集合与数组间的转换
     */
    @Test
    public void collectionArrayConvert() {
        //集合 --->数组：toArray()
        Collection c = new ArrayList();
        c.add("a");
        c.add("b");
        c.add("c");
        Object[] array = c.toArray();
        System.out.println(Arrays.toString(array));

        //拓展：数组 --->集合:调用Arrays类的静态方法asList(T ... t)
        String[] strings = new String[3];
        strings[0] = "e";
        strings[1] = "f";
        strings[2] = "g";
        Collection<String> stringList = Arrays.asList(strings);
        System.out.println(stringList);

        List arr1 = Arrays.asList(new int[]{123, 456});//???
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2
    }

    @Test
    public void personInCollection() {
        Person zhangsan = new Person("zhangsan", 14);
        Person lisi = new Person("lisi", 14);
        System.out.println(zhangsan.equals(lisi));
        Collection persons = new ArrayList();
        persons.add(zhangsan);
        persons.add(lisi);
        System.out.println(persons);
    }

}
