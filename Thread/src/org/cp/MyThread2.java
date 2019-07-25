package org.cp;

/**
 * create by CP on 2019/7/24 0024.
 */
public class MyThread2 extends Thread{
    private String whoAmI;
    private int delay;

    @Override
    public void run() {
        System.out.println(whoAmI +" 要睡 "+delay + "秒");
        try {
            Thread.sleep(delay*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("醒了！");
    }

    public MyThread2(String whoAmI, int delay) {
        this.whoAmI = whoAmI;
        this.delay = delay;
    }
}

class Test3{
    public static void main(String[] args) throws InterruptedException {
        MyThread2 t2 = new MyThread2("贝贝", (int)(Math.random()*100));
        t2.start();
        t2.join();//加了join方法后，一定会执行完t2的run方法，才会之后后续方法
        //这个打印会在“醒了”后打印
        System.out.println("main over");
    }
}
