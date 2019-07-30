package org.cp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Executors.newFixedThreadPool 简单用法
 * create by CP on 2019/7/30 0030.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) service;
        Runnable runnable1 = () -> run1();
        Runnable runnable2 = () -> run1();
        Callable callable = () -> {
            run1();
            return null;
        };
        System.out.println(executor.getCorePoolSize());//核心线程数量，初始化为 10
        executor.setCorePoolSize(12);//设置核心线程数 12
        System.out.println(executor.getPoolSize());//活动的线程数，现在没有活动线程，为0
        service.execute(runnable1);
        service.execute(runnable1);
        executor.execute(runnable2);
        executor.submit(callable);
        System.out.println(executor.getCorePoolSize());//这里为设置过的核心线程数 12
        System.out.println(executor.getPoolSize());//加了4个任务进来，活动线程数为 4
    }

    private static void run1() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
