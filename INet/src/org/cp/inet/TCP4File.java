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
        OutputStream outputStream1 = null;
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

//            socket.

            //再返回成功信息
            outputStream1 = socket.getOutputStream();
            outputStream.write("文件已收到, over.".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(outputStream, inputStream, socket, ss, outputStream1);
        }
    }

    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
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

            //接收成功信息
            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            while ((len = inputStream.read(buf)) != 1) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(byteArrayOutputStream, inputStream, bufferedInputStream, fileInputStream, outputStream, socket);
        }
    }

}
