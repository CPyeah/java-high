package org.cp.reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * 获取运行时类的完整结构
 * create by CP on 2019/9/25 0025.
 */
public class ClassStructureTest {

    /**
     * 类的属性获取
     */
    @Test
    public void getFieldsTest() {
        Class<Person> clazz = Person.class;
        //获取所有 public 属性(当前类 与 父类)
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("---------------------------");
        //getDeclaredFields():获取当前运行时类中声明的所属性。（不包含父类中声明的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            System.out.println(f);
        }
    }

    /**
     * 方法获取
     */
    @Test
    public void getMethodsTest() {
        Class<Person> clazz = Person.class;
        //获取所有public 方法 (当前类 与 父类)
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("---------------------------");
        //getDeclaredMethods():获取当前运行时类中声明的所方法。（不包含父类中声明的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }

    /*
    获取构造器结构

     */
    @Test
    public void getConstructorTest(){

        Class clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println();
        //getDeclaredConstructors():获取当前运行时类中声明的所的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }

    }

    /**
     * 获取父类
     */
    @Test
    public void getSuperClassTest() {
        Class<Person> clazz = Person.class;
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);//class org.cp.reflection.Animal
    }

    /*
   获取运行时类的带泛型的父类
    */
    @Test
    public void test3(){
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
//        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
//        //获取泛型类型
//        Type[] actualTypeArguments = paramType.getActualTypeArguments();
////        System.out.println(actualTypeArguments[0].getTypeName());
//        System.out.println(((Class)actualTypeArguments[0]).getName());

    }

    /**
     * 获取接口
     */
    @Test
    public void getInterfacesTest() {
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }
    }

    /**
     * 获取包
     */
    @Test
    public void getPackageTest() {
        Class<Person> clazz = Person.class;
        Package p = clazz.getPackage();
        System.out.println(p);
    }

    /**
     * 获取注解
     */
    @Test
    public void getAnnotationsTest() {
        Class<Person> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annos : annotations){
            System.out.println(annos);// @java.lang.Deprecated()
        }
    }
    
}
