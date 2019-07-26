package org.cp;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

/**
 * notifyAll(), wait()要写在synchronized里面
 * notifyAll(), wait()调用的对象是监视器里的对象，本DEMO里面是Object o
 * 尽量使用notifyAll()来替代notify()
 * create by CP on 2019/7/26 0026.
 */
public class Print100By2Thread {

    public static int i = 1;
    public static Object o = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (o) {
                        if (i>100) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                        i++;
                        o.notifyAll();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    synchronized (o) {
                        if (i>100) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                        i++;
                        o.notifyAll();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
