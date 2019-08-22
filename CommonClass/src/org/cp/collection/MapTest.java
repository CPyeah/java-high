package org.cp.collection;

import org.junit.Test;

import java.util.*;

/**
 * map 测试
 * create by CP on 2019/8/22 0022.
 */
public class MapTest {

    @Test
    public void hashMapTest() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1, 1);
        map.put("A", "B");
        map.put(new Person("jingjing", 18), "jingjing");
        map.put(new Person("jingjing", 18), "cc");
        map.forEach((k, v)->{
            System.out.println(k+ ":" +v);
        });
        Set<Object> objects = map.keySet();//获取到所有的key 的Set
        Collection<Object> values = map.values();//获取到所有的value 的集合
        Set<Map.Entry<Object, Object>> entries = map.entrySet();//获取到entry(包含键值对)的Set
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
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
    }

}
