package org.cp.generics;

/**
 * 自定义泛型类
 * create by CP on 2019/8/29 0029.
 */
public class Order<T> {
    private int id;
    private String name;
    private T orderT;

    public Order() {
    }

    public Order(int id, String name, T orderT) {
        this.id = id;
        this.name = name;
        this.orderT = orderT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //不是泛型方法
    public T getOrderT() {
        return orderT;
    }
    //不是泛型方法
    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
}
