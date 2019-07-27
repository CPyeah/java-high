package org.cp;

/**
 * create by CP on 2019/7/22 0022.
 */
public class Synchrozined {
    synchronized void m1() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("M1 running...");
        }

    }

    synchronized void m2() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("M2 running...");
        }
    }
    synchronized static void m3() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("M3 running...");
        }
    }
    synchronized static void m4() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("M4 running...");
        }
    }

}

class Test2{
    public static void main(String[] args) {
        Synchrozined synchrozined = new Synchrozined();
        new Thread(() -> synchrozined.m3()).start();
        new Thread(() -> synchrozined.m1()).start();
        new Thread(() -> synchrozined.m2()).start();

        new Thread(() -> synchrozined.m4()).start();
    }
}
