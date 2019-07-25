package org.cp;

/**
 * create by CP on 2019/7/24 0024.
 */
public class Toys {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            int i = 1;
            @Override
            public void run() {
                while (i<=3) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("吃 "+i+" 个馒头");
                    i++;
                }
            }
        };
        Thread t2 = new Thread(runnable);

        Thread t1 = new Thread(){
            int toyCount = 1;

            @Override
            public void run() {
                while (toyCount<=50) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("TOY Number: "+toyCount);
                    toyCount++;
                    if (toyCount==21) {
                        try {
                            t2.start();
                            t2.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        t1.start();

    }
}
