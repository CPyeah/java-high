package org.cp.inet;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 使用tcp传输文件
 * create by CP on 2019/9/20 0020.
 */
public class TCP4File {

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            ss = new ServerSocket(9988);
            socket = ss.accept();
            inputStream = socket.getInputStream();
            outputStream = new BufferedOutputStream(new FileOutputStream("java1.jpg"));
            byte[] buf = new byte[52];
            int len;
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            System.out.println("文件接收成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(outputStream, inputStream, socket, ss);
        }
    }

    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            InetAddress host = InetAddress.getLocalHost();
            socket = new Socket(host, 9988);
            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream("java.jpg");
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] buf = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            System.out.println("文件发送成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(bufferedInputStream, fileInputStream, outputStream, socket);
        }
    }

}
