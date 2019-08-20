package org.cp.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * create by CP on 2019/8/20 0020.
 */
public class ListTest {

    @Test
    public void test1() {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();
        //增
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        vector.add("A");
        vector.add("B");
        vector.add("C");
        printAll(arrayList, linkedList, vector);//[A, B, C]
        //删
        arrayList.remove(1);//删了 B
        linkedList.remove("B");//删了 B
        vector.remove(1);
        printAll(arrayList, linkedList, vector);//[A, C]
        //改
        arrayList.set(0, "D");
        linkedList.set(0, "D");
        vector.set(0, "D");
        printAll(arrayList, linkedList, vector);//[D, C]
        //查
        System.out.println(arrayList.get(1));//C
        System.out.println(linkedList.get(1));
        System.out.println(vector.get(1));
        //插
        arrayList.add(1, "E");
        linkedList.add(1, "E");
        vector.add(1, "E");
        printAll(arrayList, linkedList, vector);//[D, E, C]
        //遍历
        arrayList.forEach(item-> System.out.println(item));
        linkedList.forEach(item-> System.out.println(item));
        vector.forEach(item-> System.out.println(item));
    }

    private void printAll(List<String> arrayList, List<String> linkedList, List<String> vector) {
        System.out.println(arrayList);
        System.out.println(linkedList);
        System.out.println(vector);
    }

}
