package org.cp;

/**
 * 继承方式线程
 * 同步方法 线程安全
 * create by CP on 2019/7/25 0025.
 */
public class Window1_2 extends Thread {
    public static int ticket = 100;
    public static Object o = new Object();
    @Override
    public void run() {
        while (true) {
            if (sell()) {
                break;
            }

        }
    }


    /**
     * 这里要声明静态，要不然锁不唯一
     * @return
     */
    private synchronized static boolean sell() {
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

class WindowTest1_2 {
    public static void main(String[] args) {
        Window1_2 window1 = new Window1_2();
        Window1_2 window2 = new Window1_2();
        Window1_2 window3 = new Window1_2();
        window1.setName("窗口1 ");
        window2.setName("窗口2 ");
        window3.setName("窗口3 ");
        window1.start();
        window2.start();
        window3.start();
    }
}
