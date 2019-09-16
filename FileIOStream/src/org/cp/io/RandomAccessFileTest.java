package org.cp.io;

import org.junit.Test;

import java.io.*;

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
    
    @Test
    public void insertOverRide() throws IOException{
        RandomAccessFile rw = new RandomAccessFile("aa/abc.txt", "rw");

        //在第8个位置上添加,及覆盖后面的字符
//        rw.seek(8);

        // 在最后添加
//        rw.seek(new File("aa/abc.txt").length());

        // 在第6个位置插入
        rw.seek(6);
        byte[] bytes = new byte[8];
        int len;
        //ByteArrayOutputStream 替换 StringBuilder
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        StringBuilder stringBuilder = new StringBuilder((int) new File("aa/abc.txt").length());
        while ((len = rw.read(bytes))!=-1) {
            byteArrayOutputStream.write(bytes, 0, len);
            stringBuilder.append(new String(bytes, 0, len));
        }
        rw.seek(6);//指针调回到初始位置:6
        rw.writeBytes("121");

        byte[] bytes1 = byteArrayOutputStream.toByteArray();
//        rw.writeBytes(new String(bytes1));

        rw.writeBytes(stringBuilder.toString());


        NodeStream.closeStream(rw);
    }

}
