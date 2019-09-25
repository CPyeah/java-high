package org.cp.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * java 反射
 *
 * create by CP on 2019/9/24 0024.
 */
public class ReflectionTest {

    @Test
    public void helloReflection() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        System.out.println("---------对象反射------------");
        Class<?> clazz = Class.forName("org.cp.reflection.Person");
        Person o = (Person) clazz.newInstance();
        o.setName("jj");
        o.setAge(25);
        o.setPhone(120);
        System.out.println(clazz);
        System.out.println(o);
        System.out.println("---------属性反射------------");
        Field phone = clazz.getField("phone");//获取公有属性
        Field name = clazz.getDeclaredField("name");//获取任意属性
        Field tag = clazz.getDeclaredField("TAG");
        name.setAccessible(true);//设为可见
        tag.setAccessible(true);
        System.out.println(phone.get(o));
        System.out.println(name.get(o));
        System.out.println(tag.get(o));
        System.out.println("---------构造器反射------------");
        Constructor<?> constructor = clazz.getConstructor();
        Constructor<?> constructor1 = clazz.getDeclaredConstructor(String.class, Integer.class);
        constructor1.setAccessible(true);
        Object o1 = constructor.newInstance();
        Object o2 = constructor1.newInstance("cp", 27);
        System.out.println(o1);
        System.out.println(o2);
        System.out.println("---------方法反射------------");
        Method method = clazz.getMethod("sayHi");
        Method method1 = clazz.getDeclaredMethod("sayHi", String.class);
        Method method2 = clazz.getDeclaredMethod("sayHi", String.class, int.class);
        method1.setAccessible(true);
        method2.setAccessible(true);
        Object r = method.invoke(o2);
        System.out.println(r);
        Object r1 = method1.invoke(o1, "jj");
        System.out.println(r1);
        int r3 = (int) method2.invoke(o2, "zhuzhu", 12);
        System.out.println(r3);
    }

}
