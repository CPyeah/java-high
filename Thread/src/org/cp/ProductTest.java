/**
 * Copyright (C)
 * FileName: ProductTest
 * Author:   cp
 * Date:     2019/7/28 21:28
 * Description: 生产者消费者问题 基础写法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp;

import java.util.LinkedList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈生产者消费者问题 基础写法〉
 *
 * @author cp
 * @create 2019/7/28
 * @since 1.0.0
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        producer.setName("生产者 1 ");
        Consumer consumer = new Consumer(clerk);
        consumer.setName("消费者 1 ");
        Consumer consumer2 = new Consumer(clerk);
        consumer2.setName("消费者 2 ");

        producer.start();
        consumer.start();
//        consumer2.start();
    }
}

/**
 * 店员类 存放商品
 */
class Clerk{
    //剩余商品数量
    Integer productCount = 0;

    Integer maxCount = 10;
    private LinkedList<Object> list = new LinkedList<>();

    public synchronized void produce() throws InterruptedException {
        while (productCount>=maxCount) {//尽量用while来代替if
            System.out.println(Thread.currentThread().getName()+"等待...");
            wait();
        }

        productCount++;

        System.out.println(Thread.currentThread().getName()+"生产第 "+productCount+" 个产品");
        notifyAll();//尽量使用notifyAll()
    }

    public synchronized void consume() throws InterruptedException {
        while (productCount<1) {
            System.out.println(Thread.currentThread().getName()+"等待...");
            wait();
        }

        System.out.println(Thread.currentThread().getName()+"消费第 "+productCount+" 个产品");
        productCount--;
        notifyAll();
    }
}

/**
 * 生产者
 *
 */
class Producer extends Thread{

    private Clerk clerk;

    Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            //生产产品
            try {
                Long time;
                synchronized (this) {
                    time = (Long.valueOf(clerk.maxCount)-Long.valueOf(clerk.productCount))/Long.valueOf(clerk.maxCount)*4000;
                    System.out.println(time);
                }
                Thread.sleep(time);
                clerk.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread {

    private Clerk clerk;

    Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            //消费产品
            try {
                Long time;
                synchronized (this) {
                    time = Long.valueOf(clerk.productCount)/Long.valueOf(clerk.maxCount)*4000;
                }
                Thread.sleep(time);//sleep应该写在外面，synchronized里在允许的情况下，代码越少越好
                clerk.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
