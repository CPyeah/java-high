package org.cp.collection;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * map 测试
 * create by CP on 2019/8/22 0022.
 */
public class MapTest {

    /**
     * HashMap 底层是一个Entry/Node数组,默认容积是16
     * 来了一个键值对,对key做散列计算(hashCode方法),得出应该在数组中的位置
     * 看该位置上有没有元素,没有的话直接存入该位置
     * 若有元素, 与该元素和该元素所在链表上的元素逐一比较,若无equals相等
     * 加入该单向链表上
     * 拓展: 当数组使用率达到0.75, 数组扩容2倍;
     *      jdk8:当一个数组索引位置上的链表长度大于8,且 当前数组长度大于64(这时map里的
     *      数据已经相当多了), 取消双向链表结构, 改为红黑树存储
     */
    @Test
    public void hashMapTest() {
        HashMap<Object, Object> map = new HashMap<>();
        //put
        map.put(1, 1);
        map.put("A", "B");
        map.put(new Person("jingjing", 18), "jingjing");
        map.put(new Person("jingjing", 18), "cc");
        //get
        System.out.println(map.get("A"));
        //forEach
        map.forEach((k, v)->{
            System.out.println(k+ ":" +v);
        });
        //keySet
        Set<Object> objects = map.keySet();//获取到所有的key 的Set
        //values
        Collection<Object> values = map.values();//获取到所有的value 的集合
        //entrySet
        Set<Map.Entry<Object, Object>> entries = map.entrySet();//获取到entry(包含键值对)的Set
        //iterator
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        //iterator遍历
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ("cc".equals(value)) {
                iterator.remove();//可移除
            }
        }
        map.forEach((k, v)->{
            System.out.println(k+ ":" +v);
        });
        //size
        System.out.println(map.size());
        //remove
        System.out.println(map.remove("A"));
        //clone
        Map newMap = (Map) map.clone();
        System.out.println(newMap);
    }

    /**
     * LinkedHashMap继承自HashMap, 大体上与HashMap一样
     * 不同点再与LinkedHashMap对Node进行了再次包装(java.util.LinkedHashMap.Entry),
     * 添加了Entry<K,V> before, after; head, tail等内部属性,
     * 对存储单元进行了链表化(双向), 在遍历的时候更加的高效
     */
    @Test
    public void linkedHashMapTest() {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("AA", "aa");
        linkedHashMap.put(new Person("cp", 18), "CP");
        System.out.println(linkedHashMap);
    }

    /**
     * TreeMap会在put的时候,调用key的compareTo()方法, 进行自然排序
     * 也可以在new TreeMap的时候,传入comparator进行定制排序
     */
    @Test
    public void treeMapTest() {
        //自然排序TreeMap
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put(new Person("cp", 18), "CP");
        treeMap.put(new Person("zj", 19), "ZJ");
//        treeMap.put("AA", "aa");//key 的类型必须一致, 不然compareTo()方法报错
        System.out.println(treeMap);
        //定制排序TreeMap
        TreeMap<String, Object> comparatorTreeMap = new TreeMap<String, Object>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String)
                    return ((String) o1).compareTo((String) o2);
                throw new RuntimeException("cast error");
            }
        });
        comparatorTreeMap.put("A", "A");
        comparatorTreeMap.put("D", "D");
        comparatorTreeMap.put("a", "a");
        comparatorTreeMap.put("B", "B");
        System.out.println(comparatorTreeMap);//{A=A, B=B, D=D, a=a}
    }

    /**
     * 几个特性:
     *      与HashMap一样, 实现Map接口, 可以存储键值对
     *      方法都用synchronized修饰, 线程安全, 效率低下
     *      古老类, 起源于JDK1.0
     *      底层原理与HashMap相似, 方法相同
     *      key 和 value 都不能为 null
     *      现实使用不多, 多数需要线程安全时,会使用Collections.synchronizedMap(new HashMap<>());
     *      它的子类 Properties 会在一些特殊情况下使用
     */
    @Test
    public void hashtableTest() {
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        hashtable.put("AA", "aa");
//        hashtable.put(null, "aa");//这里会报空指针
//        hashtable.put("BB", null);//这里会报空指针
        Collections.synchronizedMap(new HashMap<>());
        Properties properties = new Properties();

        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
    }

    /**
     * Properties 测试
     * 继承自Hashtable
     * 通常用来处理配置文件,资源文件(.properties)
     * 一般key和value都为字符串
     */
    @Test
    public void propertiesTest() throws IOException {
        Properties properties = new Properties();
        properties.put("A", "a");
        properties.put(new Person("cp",18), "cp");
        System.out.println(properties);//{A=a, Person{name='cp', age=18}=cp}
        String absolutePath = new File(".").getAbsolutePath();
        absolutePath = absolutePath.substring(0, absolutePath.length()-1);
        properties.load(new FileInputStream(absolutePath+"src\\org\\cp\\collection\\props.properties"));
        System.out.println(properties);//{A=a, Person{name='cp', age=18}=cp, ZJ=zj, C=c, B=b}
        String value = properties.getProperty("ZJ");
        System.out.println(value);//zj
    }



}
