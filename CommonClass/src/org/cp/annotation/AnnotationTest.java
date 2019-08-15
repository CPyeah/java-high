package org.cp.annotation;

import org.junit.Test;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

/**
 * create by CP on 2019/8/15 0015.
 */
@CP
public class AnnotationTest {
    
    @Test
    public void test1() {
        AnnotationTest.overTime();

        @SuppressWarnings("unused")
        List list = new ArrayList();
        System.out.println(list);
    }

    /**
     * 过时 注解
     */
    @Deprecated
    public static void overTime() {
        System.out.println("overTime");
    }
    @SuppressWarnings("unused")
    public void sayGoodBye() {
        System.out.println("goodbye");
    }
    
}

//抑制警告（代码层面）
@SuppressWarnings("unused")
class Sub extends AnnotationTest{

    /**
     * @Override 重写注解
     */
    @Override
    public void sayGoodBye() {
        System.out.println(88);
    }
}
