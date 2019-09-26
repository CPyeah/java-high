package org.cp.reflection.entities;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * create by CP on 2019/9/26 0026.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "";

}
