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
        consumer.setName("消费者 1");

        producer.start();
        consumer.start();
    }
}

/**
 * 店员类 存放商品
 */
class Clerk{
    //剩余商品数量
    Integer productCount = 0;

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
        //生产产品
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
        //消费产品
    }

}
