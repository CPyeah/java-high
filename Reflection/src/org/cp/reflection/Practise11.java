package org.cp.reflection;

import org.cp.reflection.entities.Person;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * create by CP on 2019/10/8 0008.
 */
public class Practise11 {

    /**
     * 写出获取Class实例的三种常见方式
     */
    @Test
    public void test1() throws ClassNotFoundException {
        //1
        Class<Person> clazz1 = Person.class;
        //2
        Person person = new Person();
        Class<? extends Person> clazz2 = person.getClass();
        //3
        Class<?> clazz3 = Class.forName("org.cp.reflection.entities.Person");
        //4
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("org.cp.reflection.entities.Person");

    }

    /**
     * 通过clazz创建对象, 不使用new关键字
     * 需要满足的条件
     *  1. 类需要空参构造器
     *  2. 构造器权限要足够
     */
    @Test
    public void test2() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    /**
     * 在工程或module的src下有名为”jdbc.properties”的配置文件，
     * 文件内容为：name=cp。如何在程序中通过代码获取Tom这个变量值。
     * 代码实现(classloader)
     */
    @Test
    public void test3() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        //获取资源
        InputStream resource = classLoader.getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(resource);
        Object name = properties.get("name");
        System.out.println(name);
    }

    /**
     * 通过反射调用方法
     */
    @Test
    public void test4() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Person> clazz = Person.class;//获取类
        Person person = clazz.newInstance();//获取对象
        //获取方法
        Method sayHi = clazz.getDeclaredMethod("sayHi", String.class, int.class);
        sayHi.setAccessible(true);//每次都声明, 保证通用性
        //反射调用
        Object r = sayHi.invoke(person, "zhuzhu", 18);
        System.out.println(r);
    }
    
}
