package org.cp.entities;

/**
 * create by CP on 2019/11/5 0005.
 */
public class Employee {

    String name;

    Integer age;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(Integer age) {
        this.age = age;
    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
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
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
