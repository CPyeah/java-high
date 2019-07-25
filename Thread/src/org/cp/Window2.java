package org.cp;

/**
 * 实现接口方式线程
 * 线程不安全 原版
 * create by CP on 2019/7/25 0025.
 */
public class Window2 implements Runnable {
    public static int ticket = 100;
    @Override
    public void run() {
        while (true) {
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

class WindowTest2 {
    public static void main(String[] args) {
        Window2 window = new Window2();
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
