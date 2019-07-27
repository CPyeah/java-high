package org.cp;

/**
 * 继承方式线程
 * 同步代码块 线程安全
 * create by CP on 2019/7/25 0025.
 */
public class Window1_1 extends Thread {
    private static int ticket = 100;
    public static Object o = new Object();
    @Override
    public void run() {
        while (true) {
//            synchronized (o) { //静态成员对象 锁 唯一
            synchronized (this.getClass()) {//类对象 唯一
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

class WindowTest1_1 {
    public static void main(String[] args) {
        Window1_1 window1 = new Window1_1();
        Window1_1 window2 = new Window1_1();
        Window1_1 window3 = new Window1_1();
        window1.setName("窗口1 ");
        window2.setName("窗口2 ");
        window3.setName("窗口3 ");
        window1.start();
        window2.start();
        window3.start();
    }
}
