package org.cp.io;

import org.junit.Test;

import java.io.*;

/**
 * simple io stream practise
 *  * (节点流, 处理流 / xxxPutStream, xxxReader / BufferedXXXPutStream, BufferedReader)
 *  * (字节流, 字符流 / InputStream / Reader)
 *  * (输入流, 输出流 / InputStream, Reader / OutputStream, Writer)
 * create by CP on 2019/9/4 0004.
 */
public class SimpleStream {
    
    @Test
    public void test1() throws IOException {
        //字节 输入
        FileInputStream fileInputStream = new FileInputStream("aa/hi.txt");
        //字节 输出
        FileOutputStream fileOutputStream = new FileOutputStream("aa/hi.txt");
        //字符 输入
        FileReader fileReader = new FileReader("aa/hi.txt");
        //字符 输出
        FileWriter fileWriter = new FileWriter("aa/hi.txt");
        //缓冲流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    }
    
    
}
