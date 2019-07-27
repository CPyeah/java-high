package org.cp;

/**
 * create by CP on 2019/7/22 0022.
 */
public class MyThread1 implements Runnable {

    Integer ticket = 100;

    @Override
    public void run() {
        while (ticket >= 0) {
            sell();
        }
    }

    synchronized void  sell() {
        synchronized (this.ticket) {

            System.out.println(Thread.currentThread().getName() + ": " + ticket);
            ticket--;
        }
    }
}

class Test1 {
    public static void main(String[] args) {
        MyThread1 t = new MyThread1();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);

        Runnable r = () -> {
            while (t.ticket >= 0) {
                t.sell();
            }
        };
        Thread t4 = new Thread(r);


        t1.setName("窗口1 ");
        t2.setName("窗口2 ");
        t3.setName("窗口3 ");
        t4.setName("窗口4 ");

        t1.start();
        t2.start();
        t3.start();
//        t4.start();
    }
}
