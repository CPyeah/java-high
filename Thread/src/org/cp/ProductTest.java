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

    Integer maxCount = 100;
    private LinkedList<Object> list = new LinkedList<>();

    public  void produce() throws InterruptedException {
        synchronized (list) {
            while (productCount>=maxCount) {
                System.out.println(Thread.currentThread().getName()+"等待...");
                list.wait();
            }
            Thread.sleep(500);
            productCount++;

            System.out.println(Thread.currentThread().getName()+"生产第 "+productCount+" 个产品");
            list.notifyAll();
        }
    }

    public  void consume() throws InterruptedException {
        synchronized (list) {
            while (productCount<1) {
                System.out.println(Thread.currentThread().getName()+"等待...");
                list.wait();
            }
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+"消费第 "+productCount+" 个产品");
            productCount--;
            list.notifyAll();
        }
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
            System.out.println("shengchan");
            //生产产品
            try {
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
            System.out.println("xiaofei");
            //消费产品
            try {
                clerk.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
