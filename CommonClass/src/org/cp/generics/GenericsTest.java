package org.cp.generics;

import org.junit.Test;

import java.util.*;

/**
 * hello java 泛型
 * create by CP on 2019/8/27 0027.
 */
public class GenericsTest {

    /**
     * 没有泛型的List 测试
     * 1. 添加元素是, 没有严格校验, 导致所有的类型都能添加进来, 有隐患
     * 2. 由于类型都是Object, 在之后的强转处理时候, 可能会报'ClassCastException'
     * 3. 添加一个Integer, 在list中会当成Object对象, 在之后使用中, 又需要转成Interger使用, 操作繁琐
     *
     */
    @Test
    public void notUsedGenerics() {
        ArrayList list = new ArrayList();//new 一个不带泛型的list
        list.add(78);//存放学生的成绩
        list.add(61);
        list.add(53);
//        list.add("Tom");//类型不安全 任何类型都可以添加
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Object next = iterator.next();
//        }
        for (Object score : list) {
            Integer intScore = (Integer) score;//强转可能出异常
            System.out.println(intScore);
            //在类型强转时, 可能发生类型转换异常
            //java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        }
    }

    /**
     * 使用泛型 类型安全
     * 1. 添加其他类型, 编译时就发现问题
     * 2. 使用时, 不用强转, 直接使用
     * 3. 在存储时, 直接是Integer类型, 避免后面的类型转换的繁琐操作
     */
    @Test
    public void usedGenerics() {
        //泛型不能是基本数据类型
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);//存放学生的成绩
        list.add(61);
        list.add(53);
        Iterator<Integer> iterator = list.iterator();// iterator可加泛型, 和容器泛型保持一致
        while (iterator.hasNext()) {
            Integer i = iterator.next();
        }
//        list.add("Tom");//这时编译会报错, 提前发现问题
        for(Integer i : list) {//可直接声明为 Integer类型, 后面不用强转, 直接使用
            System.out.println(i);
        }
    }

    /**
     * map 泛型测试
     * key, value 各有一个泛型  HashMap<String, Integer>
     *
     * 泛型的嵌套  ArrayList<Map<String, Integer>>
     *
     */
    @Test
    public void mapGenericsTest() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Tom", 78);
        map.put("Jerry", 66);
        map.put("Tony", 54);
//        map.put(45, "ok");// 编译报错
        map.forEach((k, v)->{
            System.out.println(k+":"+v);
        });
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            //有泛型, 不用强转
            Map.Entry<String, Integer> item = iterator.next();
            String key = item.getKey();
            Integer value = item.getValue();
        }
        //泛型的嵌套
        ArrayList<Map<String, Integer>> maps = new ArrayList<>();
        maps.add(map);
        System.out.println(maps);
    }

    @Test
    public void test1() {
        Type<StringBuilder> abc = new Type<>(new StringBuilder("abc"));
//        Type<StringBuilder> def = new Type<>(new StringBuffer("abc"));//这种情况编译不通过
        System.out.println(abc.getType());//abc
        System.out.println(abc.getType().getClass().getName());//java.lang.StringBuilder

        NoType abc1 = new NoType(new StringBuilder("abc"));
        NoType def1 = new NoType(new StringBuffer("def"));
        System.out.println(abc1.getType());//abc
        System.out.println(abc1.getType().getClass().getName());//java.lang.StringBuilder
        System.out.println(def1.getType().getClass().getName());//java.lang.StringBuffer
    }

}
