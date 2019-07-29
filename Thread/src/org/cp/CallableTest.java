package org.cp;

import java.util.concurrent.*;

/**
 * Callable初体验
 * create by CP on 2019/7/29 0029.
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CC cc = new CC();
        FutureTask task = new FutureTask(cc);//封装Callable实现类
        Thread thread = new Thread(task);
        thread.start();

        Object o = task.get();//阻塞式获取
        System.out.println(o);

        try {
            Object o1 = task.get(1, TimeUnit.SECONDS);//阻塞式获取
            System.out.println(o1);
        } catch (TimeoutException e) {
            System.out.println("1 秒后，没取到结果");
            e.printStackTrace();
        }

    }
}

class CC implements Callable {

    @Override
    public Object call() throws Exception {
        Integer sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum+=i;
        }
        Thread.sleep(5000);
        return sum;
    }
}
