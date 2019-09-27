package org.cp.reflection;

import org.cp.reflection.entities.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * 调用运行时类的指定结构
 * create by CP on 2019/9/25 0025.
 */
public class ClassSpecialStructureTest {

    /**
     * 属性获取
     */
    @Test
    public void getField() throws Exception {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        person.setName("zh");
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        Object o = name.get(person);
        System.out.println(o);
        name.set(person, "zhuzhu");
        System.out.println(person.getName());
        System.out.println(name.getType().getName());// 数据类型
        /**
         * 修饰
         * PUBLIC: 1
         * PRIVATE: 2
         * PROTECTED: 4
         * STATIC: 8
         * FINAL: 16
         * SYNCHRONIZED: 32
         * VOLATILE: 64
         * TRANSIENT: 128
         * NATIVE: 256
         * INTERFACE: 512
         * ABSTRACT: 1024
         * STRICT: 2048
         */
        int modifiers = name.getModifiers();//2
        System.out.println(Modifier.toString(modifiers));//private
        System.out.println(name.getName());
        System.out.println(name.getAnnotations()[0].toString());
        System.out.println(Modifier.toString(modifiers) + "    "
        + name.getType().getName() + "    " + name.getName());

    }
    
    @Test
    public void getMethod() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        Method sayHi = clazz.getDeclaredMethod("sayHi", String.class, int.class);
        sayHi.setAccessible(true);
        Object invoke = sayHi.invoke(person, "你好", 21);
        System.out.println(invoke);
        Annotation[] annotations = sayHi.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
        int modifiers = sayHi.getModifiers();
        String s = Modifier.toString(modifiers); //修饰
        System.out.print(s + "\t");
        Type genericReturnType = sayHi.getGenericReturnType();
        System.out.print(genericReturnType + "\t");
        String name = sayHi.getName();
        System.out.print(name + "\t");
        System.out.print("(");
        Parameter[] parameters = sayHi.getParameters();
        for (Parameter parameter : parameters) {
            Class<?> type = parameter.getType();
            String name1 = parameter.getName();
            System.out.print(type.toString() + " ");
            System.out.print(name1 + ", ");
        }
        System.out.print(")" + "\t" + "throws"+ "\t");
        Type[] genericExceptionTypes = sayHi.getGenericExceptionTypes();
        for (Type type : genericExceptionTypes) {
            System.out.print(type + "\t");
        }
    }

    /**
     * 构造器获取
     */
    @Test
    public void getConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, Integer.class);
        constructor.setAccessible(true);
        Person zz = constructor.newInstance("zz", 18);
        System.out.println(zz);

        System.out.println(constructor.getAnnotations());
        System.out.println(Modifier.toString(constructor.getModifiers()));
        System.out.println(constructor.getName());
        System.out.println(constructor.getParameters().length);
    }
}
