/**
 * Copyright (C)
 * FileName: Employee
 * Author:   cp
 * Date:     2019/8/24 11:35
 * Description: 雇员类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp.collection.test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈雇员类〉
 *
 * @author cp
 * @create 2019/8/24
 * @since 1.0.0
 */
public class Employee implements Comparable{

    private String name;
    private Integer age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, Integer age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Employee))
            throw new RuntimeException("数据类型不匹配");
//        return this.name.compareTo(((Employee) o).name);//按姓名排序
        //先按年龄,再按姓名排序
        int i = -this.age.compareTo(((Employee) o).age);
        if (i!=0) return i;
        return this.name.compareTo(((Employee) o).name);
    }
}
