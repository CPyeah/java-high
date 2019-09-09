package org.cp.io;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流
 * create by CP on 2019/9/5 0005.
 */
public class BufferedStream {

    @Test
    public void simpleTest() {
        long before = System.currentTimeMillis();
        bufferedCopy("aa/soga.txt", "aa/soga2.txt");
        long after = System.currentTimeMillis();
        System.out.println("cost " + (after-before) + " ms");//cost 7 ms
    }

    private void bufferedCopy(String src, String dest) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //1. 造文件
            File file = new File(src);
            File file1 = new File(dest);
            //2.1 造节点流
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file1);
            //2.2 造缓冲流
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            //3. 读取数据
            //方法一: readLine() 方法
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
////                System.out.println(line);
//                //不换行
////                bufferedWriter.write(line);//没操作, 不换行
//                //换行1: 手动加换行符
////                bufferedWriter.write(line + "\n");
//                //换行2: newLine() 方法换行
//                bufferedWriter.write(line);
//                bufferedWriter.newLine();
//            }
            //方法二: read(buffer) 方法
            int len;
            char[] cbuf = new char[128];
            while ((len = bufferedReader.read(cbuf)) != -1) {
                bufferedWriter.write(cbuf, 0, len);
            }
            //把最后剩余的缓存数据全部输出
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源, 关闭资源的时候, 关闭最外层的流就可以了
            NodeStream.closeStream(bufferedReader, bufferedWriter);
        }
    }

}
