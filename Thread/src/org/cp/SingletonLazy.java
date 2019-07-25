package org.cp;

/**
 * 单例模式  懒汉式
 * create by CP on 2019/7/25 0025.
 */
public class SingletonLazy {

    private SingletonLazy(){}

    private static SingletonLazy singletonLazy;

    public static SingletonLazy getInstance() {
        if (singletonLazy==null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }

}
