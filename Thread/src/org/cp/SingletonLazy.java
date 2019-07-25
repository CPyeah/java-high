package org.cp;

/**
 * 单例模式  懒汉式
 * create by CP on 2019/7/25 0025.
 */
public class SingletonLazy {

    private SingletonLazy(){}

    private static SingletonLazy singletonLazy;

    public static SingletonLazy getInstance() {
        if (singletonLazy==null) {//高效判断，不用每次都进来锁里面，
            synchronized (SingletonLazy.class) {
                if (singletonLazy==null) {
                    try {
                        Thread.sleep(100);//延迟看效果
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    singletonLazy = new SingletonLazy();

                }
            }
        }
        System.out.println(singletonLazy);//引用地址一样表示线程安全
        return singletonLazy;
    }

}
class SingletonLazyTest{
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                SingletonLazy.getInstance();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                SingletonLazy.getInstance();
            }
        };
        thread1.start();
        thread2.start();
    }
}
