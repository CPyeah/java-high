package org.cp.entities;

import java.io.Serializable;

/**
 * 声明 serialVersionUID
 * 在属性有变化时, 反序列化过程中也不会报错
 *
 * create by CP on 2019/9/16 0016.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1993472872099008242L;

    String name;
    Integer age;
    Boolean isMen;

    public Person() {
    }

    public Person(String name, Integer age, Boolean isMen) {
        this.name = name;
        this.age = age;
        this.isMen = isMen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMen=" + isMen +
                '}';
    }
}
