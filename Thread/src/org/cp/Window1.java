package org.cp;

/**
 * 继承方式线程
 * 线程不安全 原版
 * create by CP on 2019/7/25 0025.
 */
public class Window1 extends Thread {
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
class WindowTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
        Window1 window2 = new Window1();
        Window1 window3 = new Window1();
        window1.setName("窗口1 ");
        window2.setName("窗口2 ");
        window3.setName("窗口3 ");
        window1.start();
        window2.start();
        window3.start();
    }
}
