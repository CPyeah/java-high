package org.cp;

/**
 * create by CP on 2019/7/22 0022.
 */
public class MyThread extends Thread {

    static Integer ticket = 100;

    @Override
    public void run() {
        while (true) synchronized (ticket) {
            if (ticket < 0) {
                break;
            }
            System.out.println(getName() + ": " + ticket);
            ticket--;
        }
    }
}

class Test {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        Thread t4 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (MyThread.ticket) {
                        if (MyThread.ticket < 0) {
                            break;
                        }
                        System.out.println(getName() + ": " + MyThread.ticket);
                        MyThread.ticket--;
                    }
                }
            }
        };

        t1.setName("窗口1 ");
        t2.setName("窗口2 ");
        t3.setName("窗口3 ");
        t4.setName("窗口4 ");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}
