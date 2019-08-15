package org.cp.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * create by CP on 2019/8/15 0015.
 */
@Inherited //继承的子类保留此注解
@Retention(RetentionPolicy.RUNTIME)//生命周期 （运行时）
@Target({METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})//注解的目标对象类型
public @interface CP {

    //参数
    String value() default "yeah";

}
