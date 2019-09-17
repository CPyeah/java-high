package org.cp.inet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * create by CP on 2019/9/17 0017.
 */
public class TCPTest {

    /**
     * 服务端
     *
     * @throws IOException
     */
    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buf = new byte[8];
        int len;
        while ((len = inputStream.read(buf)) != -1) {
            byteArrayOutputStream.write(buf, 0, len);
        }
        System.out.println(byteArrayOutputStream.toString());
        System.out.println("收到了来自于：" + accept.getInetAddress().getHostAddress() + "的数据");
        //关闭资源
        byteArrayOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }

    /**
     * 客户端
     * @throws IOException
     */
    @Test
    public void client() throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        Socket socket = new Socket(localHost, 8899);
        OutputStream out = socket.getOutputStream();
        out.write("你好，我是客户端mm".getBytes());
        out.close();
        socket.close();
    }

}
