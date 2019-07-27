package org.cp;

/**
 * 继承方式线程
 * 同步方法 线程安全
 * create by CP on 2019/7/25 0025.
 */
public class Window2_2 implements Runnable {
    private static int ticket = 100;
    private static Object o = new Object();
    @Override
    public void run() {
        while (true) {
            if (sell()) {
                break;
            }

        }
    }


    /**
     * 这里不用要声明静态
     * @return boolean
     */
//    private static synchronized boolean sell() {
    private synchronized boolean sell() {
        if (ticket>0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ ": "+ticket);
            ticket--;
        } else {
            return true;
        }
        return false;
    }
}

class WindowTest2_2 {
    public static void main(String[] args) {
        Window2_2 window = new Window2_2();
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
