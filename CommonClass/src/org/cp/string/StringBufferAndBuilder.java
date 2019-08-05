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
        StringBuffer stringBuffer = new StringBuffer(100);
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
}
