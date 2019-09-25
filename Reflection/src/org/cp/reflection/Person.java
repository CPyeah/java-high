package org.cp.reflection;

/**
 * create by CP on 2019/9/24 0024.
 */
public class Person {

    private final static String TAG = "PersonTag";

    private String name;
    private Integer age;
    public Integer phone;

    public Person() {
    }

    private Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name, Integer age, Integer phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void sayHi() {
        System.out.println("hello everybody!");
    }

    private void sayHi(String name) {
        System.out.println("hello " + name);
    }

    private int sayHi(String name, int f) {
        System.out.println("hello " + name);
        return f;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }
}
