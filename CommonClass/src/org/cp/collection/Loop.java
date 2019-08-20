package org.cp.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 集合循环遍历
 * create by CP on 2019/8/20 0020.
 */
public class Loop {

    private static ArrayList<String> list = new ArrayList<>();

    static {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
    }
    
    @Test
    public void loopPrint() {
        System.out.println("---------iterator-----------------");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
        System.out.println("---------for (String s : list)-----------------");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------for (int i = 0; ...)----------------");
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            System.out.println(item);
        }
        System.out.println("-----------list.forEach---------------");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("-----------list.forEach(lambda) ---------------");
        list.forEach(item-> System.out.println(item));
    }
    
}
