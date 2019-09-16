package org.cp.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机存储文件流
 * 可做输出, 也可做输入流
 * 可实现插入功能 (seek(int pos);)
 * create by CP on 2019/9/16 0016.
 */
public class RandomAccessFileTest {

    /**
     * 基础文件复制测试
     */
    @Test
    public void copyTest() {
        RandomAccessFile r = null;
        RandomAccessFile w = null;
        try {
            //读入
            r = new RandomAccessFile("aa/java.jpg", "r");
            //写
            w = new RandomAccessFile("aa/java_w.jpg", "rw");
            byte[] bytes = new byte[1024];
            int len;
            while ((len=r.read(bytes))!=-1) {
                w.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            NodeStream.closeStream(r, w);
        }

    }

}
