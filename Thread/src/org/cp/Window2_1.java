package org.cp;

/**
 * 实现接口方式线程
 * 同步代码块 线程安全
 * create by CP on 2019/7/25 0025.
 */
public class Window2_1 implements Runnable {
    private static int ticket = 100;
    private Object o1 = new Object();
    private static Object o2 = new Object();
    @Override
    public void run() {
        while (true) {
            //Window对象只有一个，所以是不是静态对象锁都可以
//            synchronized (o1) {
//            synchronized (o2) {
            synchronized (this) {
                if (ticket>0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ ": "+ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

class WindowTest2_1 {
    public static void main(String[] args) {
        Window2_1 window = new Window2_1();
        Thread window1 = new Thread(window);
        Thread window2 = new Thread(window);
        Thread window3 = new Thread(window);
        window1.setName("窗口1 ");
        window2.setName("窗口2 ");
        window3.setName("窗口3 ");
        window1.start();
        window2.start();
        window3.start();
    }
}
