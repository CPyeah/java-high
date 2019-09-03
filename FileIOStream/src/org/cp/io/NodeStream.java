package org.cp.io;


import org.junit.Test;

import java.io.File;
import java.io.FileReader;
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
}
