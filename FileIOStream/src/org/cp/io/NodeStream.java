package org.cp.io;


import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 节点流
 * (节点流, 处理流 / xxxPutStream, xxxReader / BufferedXXXPutStream, BufferedReader)
 * (字节流, 字符流 / InputStream / Reader)
 * (输入流, 输出流 / InputStream, Reader / OutputStream, Writer)
 * create by CP on 2019/9/3 0003.
 */
public class NodeStream {

    /**
     * simple to read a txt file
     * 常规操作：
     * 1、File实例化
     * 2、流对象实例化
     * 3、流读写
     * 4、关闭资源
     */
    @Test
    public void readFileTest(){
        //字符流, 适合读取文本文件, 一个字符一个字符的读取,
        FileReader fileReader = null;
        try {
            File file = new File("helloIO.txt");
            fileReader = new FileReader(file);
            int data;
            //方式一: 一个字符 一个字符的读
//            while ((data = fileReader.read())!=-1) {//data 返回的是字符编码
//                System.out.print((char) data);//helloWorld_IO
//            }
            //方式二: 数组缓存读取
            char[] buf = new char[5];//容量为5的容器
            while ((data = fileReader.read(buf))!=-1) {//data 返回的是字符个数
//                System.out.print(buf);//helloWorld_IOldD 由于buf容器没有清空, 最终输出有缓存
                System.out.print(new String(buf,0, data));//helloWorld_IO 这样截取是正解
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//流资源关闭
            if (fileReader!=null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * write sth in the file test
     */
    @Test
    public void writeFileTest(){
        FileWriter fileWriter = null;
        try {
            //1. writer创建
            //若没有该文件, 会自动创建
            //@param append (default false)
            // true-会在原有文件末尾接着写入; false-源文件清空,从头开始写入,会覆盖掉原来字符
            fileWriter = new FileWriter("aa/dream.txt");
            //若没有上层路径, 会报 java.io.FileNotFoundException: dd\dream.txt (系统找不到指定的路径。)
//            fileWriter = new FileWriter("dd/dream.txt", false);

            //2.写入数据
            fileWriter.write("I have big a dream!\n");
            fileWriter.write("You have a big dream too.\n");
            fileWriter.write(121);//int作为字符编码会转成字符 121->y
            fileWriter.write(new char[]{'a','b','c'});
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
