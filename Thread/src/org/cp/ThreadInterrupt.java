package org.cp;

/**
 * create by CP on 2019/7/29 0029.
 */
public class ThreadInterrupt {

    private static Object o = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(10000);//Thread的今天方法
            } catch (InterruptedException e) {
                System.out.println("Thread 1 被打断");
                e.printStackTrace();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (o) {//wait()方法一定要在synchronized里面调用
                try {
                    o.wait();//Object的方法，同步监视器（锁）对象调用
                } catch (InterruptedException e) {
                    System.out.println("Thread 2 被打断");
                    e.printStackTrace();
                }
            }
        });
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.interrupt();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }
}
