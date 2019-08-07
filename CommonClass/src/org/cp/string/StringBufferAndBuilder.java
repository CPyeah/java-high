package org.cp.string;

import org.junit.Test;

/**
 * StringBuffer和StringBuilder 都是继承自抽象类 AbstractStringBuilder
 * 具体实现也都是在AbstractStringBuilder类里面实现的
 * 但是在封装的时候，StringBuffer 的方法都加了synchronized修饰，所以都是现成安全的，但是效率稍差
 * StringBuilder不是线程安全的，但是效率高，一般使用StringBuilder
 * create by CP on 2019/8/5 0005.
 */
public class StringBufferAndBuilder {

    @Test
    public void bufferTest() {
        StringBuffer sb = new StringBuffer("abc");
        System.out.println(sb.reverse());
        StringBuffer stringBuffer = new StringBuffer(100);//初始化定义容量，默认预留16个字符
        stringBuffer.append(5)
                .append('e')
                .append(1.2)
                .append("ff");
        System.out.println(stringBuffer);

    }

    @Test
    public void builderTest() {
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb.reverse());
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append(5)
                .append('e')
                .append(1.2)
                .append("ff");
        System.out.println(stringBuilder);
    }

    /**
     * 设计代码，比较三者效率 从1加到20000
     * 从高到低排列：StringBuilder > StringBuffer > String
     * 18795462397
     */
    @Test
    public void efficiencyTest() {
        String s1 = "";
        StringBuffer s2 = new StringBuffer();
        StringBuilder s3 = new StringBuilder();
        long beginTime;
        long endTime;

        //String
        beginTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            s1 += String.valueOf(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("String : " + (endTime-beginTime));

        //StringBuffer
        beginTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            s2.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer : " + (endTime-beginTime));

        //StringBuilder
        beginTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            s3.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder : " + (endTime-beginTime));
    }
}
