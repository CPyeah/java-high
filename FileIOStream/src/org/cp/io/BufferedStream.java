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
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            //1. 造文件
            File file = new File("aa/dream.txt");
            //2.1 造节点流
            fileReader = new FileReader(file);
            //2.2 造缓冲流
            bufferedReader = new BufferedReader(fileReader);
            //3. 读取数据
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            NodeStream.closeStream(fileReader, bufferedReader);
        }


    }

}
