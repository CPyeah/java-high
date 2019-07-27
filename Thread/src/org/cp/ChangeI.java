package org.cp;

/**
 * create by CP on 2019/7/24 0024.
 */
public class ChangeI {
    private static int I =20;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (i<20) {
                I++;
                i++;
            }
        }).start();
        new Thread(() -> {
            int i = 0;
            while (i<20) {
                I--;
                i++;
            }
        }).start();
        Thread.sleep(1000);
        System.out.println(I);
    }

}
