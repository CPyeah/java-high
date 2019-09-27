package org.cp.reflection;

import org.cp.reflection.entities.Person;
import org.junit.Test;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

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
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
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
    public void getMethod() {

    }

}
