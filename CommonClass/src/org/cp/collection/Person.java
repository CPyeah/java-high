package org.cp.collection;

import java.util.Objects;

/**
 * create by CP on 2019/8/19 0019.
 */
public class Person {

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    /**
     * result = 31 * result + (element == null ? 0 : element.hashCode());
     * hash计算是加权31,再加一个数
     * 31的由来:
     *  好计算, 素数
     *  所以 2的幂 前后的数比较好
     *  2
     *  4 -> 3 5
     *  8 -> 7 9
     *  16 -> 15 17
     *  32 -> 31 33
     *  64 -> 63 65
     *  在以上的数中, 31很合适  可由 (1<<5)-1 得来, 又是素数
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
