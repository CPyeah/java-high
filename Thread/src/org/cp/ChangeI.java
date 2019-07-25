package org.cp;

/**
 * create by CP on 2019/7/24 0024.
 */
public class ChangeI {
    public static int I =20;
    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            @Override
            public void run() {
                int i = 0;
                while (i<20) {
                    I++;
                    i++;
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                int i = 0;
                while (i<20) {
                    I--;
                    i++;
                }
            }
        }.start();
        Thread.sleep(1000);
        System.out.println(I);
    }

}
