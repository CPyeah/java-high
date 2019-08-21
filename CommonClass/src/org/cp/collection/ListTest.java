package org.cp.collection;

import org.junit.Test;

import java.util.*;

/**
 * create by CP on 2019/8/20 0020.
 */
public class ListTest {

    /**
     * ArrayList, LinkedList, Vector都实现List接口,都可以表示
     * 一列数据, 但在存储结构和存储效率上有所不同.
     *
     * ArrayList在底层是数组, 初始容量是10, 是在内存中开辟一块连续的存储空间,
     * 每个空间有自己的索引, 所以在索引、遍历的时候, 效率比较高, 一般开发中用的最多
     * 但在中间插入数据的时候, 会把后面的数据往后移一位, 所以在数据比较多的时候,效率较低
     * 还有一个扩容的问题, 当数据超过当前容量的时候, 会copy一个内容一样的数组,
     * 但是容积更大(一般是扩大1.5倍, capacity+capacity>>1)
     *
     * LinkedList 的存储类型是双向链表的结构, LinkedList里面有个Node内部类,
     * 存储上个节点地址, 核心数据和下个节点地址; LinkedList里面会存储当前链表长度
     * 和头、尾节点地址, 方便遍历和在尾部新增节点. 它的特点是在中间插入和删除的时候效率较高,
     * 影响也较小(只会影响到目标位置的前后两个节点),缺点就是在取值的时候效率较低,需要从头开始遍历
     *
     * Vector是古老的列表类, 底层结构和ArrayList相似,当时它的每一个方法都是加锁的,
     * 所以是线程安全的, 但是在操作的时候, 效率较低, 一般不使用...
     * PS: 如果需要使用线程安全的列表结构, 一般用
     *  List<String> synchronizedList = Collections.synchronizedList(arrayList);
     */
    @Test
    public void test1() {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        Vector<String> vector = new Vector<>();

        List<String> synchronizedList = Collections.synchronizedList(arrayList);

        //增
        arrayList.add("A");//先判断容量, 再在最后位置放入对象
        arrayList.add("B");
        arrayList.add("C");
        linkedList.add("A");//取到最后一个节点地址, 把新来的节点连接上去
        linkedList.add("B");
        linkedList.add("C");
        vector.add("A");
        vector.add("B");
        vector.add("C");
        printAll(arrayList, linkedList, vector);//[A, B, C]
        //删
        arrayList.remove(1);//删了 B 去除该索引上的元素, 再把后面的往前移一位
        arrayList.remove("B");//循环判断是否相等(equals()),找到了,就删掉,后面的往前移一位
        linkedList.remove("B");//删了 B 循环遍历,找相等,找到了就做去节点操作
        vector.remove(1);
        printAll(arrayList, linkedList, vector);//[A, C]
        //改
        arrayList.set(0, "D");// 直接找到该位置,替换掉,很简单
        linkedList.set(0, "D");// 先数到该索引位置,替换掉
        vector.set(0, "D");
        printAll(arrayList, linkedList, vector);//[D, C]
        //查
        System.out.println(arrayList.get(1));//C 直接调用底层数据的elementData[index],一步到位
        System.out.println(linkedList.get(1));//从头开始往后数
        System.out.println(vector.get(1));
        System.out.println(arrayList.indexOf("B"));//循环查找,判断是否相等调用的是对象的equals()方法,有就返回索引,没有返回-1
        System.out.println(linkedList.indexOf("B"));//循环链表, 每一个节点的值做比较,调用的也是equals()方法
        System.out.println(vector.indexOf("B"));// 同ArrayList, 不过方法加了synchronized修饰
        //插
        arrayList.add(1, "E");//先判断容量,再把目标索引后的元素往后移,最后插入
        linkedList.add(1, "E");//找到该索引位置,做加节点的操作
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
