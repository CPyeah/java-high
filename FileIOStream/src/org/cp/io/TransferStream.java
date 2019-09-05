package org.cp.io;

import org.junit.Test;

import javax.xml.soap.Node;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流, 字符集
 * create by CP on 2019/9/5 0005.
 */
public class TransferStream {

    @Test
    public void test1() {
        FileInputStream gbk_fileInputStream = null;
        FileInputStream utf8_fileInputStream = null;
        InputStreamReader gbk_Stream = null;
        InputStreamReader utf_Stream = null;
        try {
            //1. 造文件
            File gbk = new File("aa/GB2312.txt");
            File utf8 = new File("aa/utf-8.txt");
            //2. 造流
            //2.1 字节流
            gbk_fileInputStream = new FileInputStream(gbk);
            utf8_fileInputStream = new FileInputStream(utf8);
            //2.2 字符集对应的转换流
            gbk_Stream = new InputStreamReader(gbk_fileInputStream, "GBK");
            utf_Stream = new InputStreamReader(utf8_fileInputStream, "utf-8");
            //3 读取信息
            int data;
            char[] buffer = new char[5];
            System.out.println("----------gbk----------");
            while ((data=gbk_Stream.read(buffer))!=-1) {
                String s = new String(buffer, 0, data);
                System.out.print(s);
            }
            System.out.println();
            System.out.println("----------utf-8----------");
            while ((data=utf_Stream.read(buffer))!=-1) {
                String s = new String(buffer, 0, data);
                System.out.print(s);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("----------close stream----------");
            NodeStream.closeStream(gbk_fileInputStream, utf8_fileInputStream, gbk_Stream, utf_Stream);
        }


    }

}
