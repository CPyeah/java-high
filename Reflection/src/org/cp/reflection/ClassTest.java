package org.cp.reflection;

import org.cp.reflection.entities.Person;
import org.junit.Test;

/**
 * create by CP on 2019/9/24 0024.
 */
public class ClassTest {

    /**
     * 获取Class对象的4中方法
     * @throws ClassNotFoundException
     */
    @Test
    public void getClassTest() throws ClassNotFoundException {
        //1.
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //2.
        Person person = new Person();
        Class<? extends Person> clazz2 = person.getClass();
        System.out.println(clazz2);
        //3.
        Class<?> clazz3 = Class.forName("org.cp.reflection.entities.Person");
        System.out.println(clazz3);
        //4.
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("org.cp.reflection.entities.Person");
        System.out.println(clazz4);

        //取的class对象都是同一个class对象, 在运行是会先缓存一个class对象
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz1 == clazz4);
        System.out.println(clazz2 == clazz3);
        System.out.println(clazz2 == clazz4);
        System.out.println(clazz3 == clazz4);

    }

}
