package org.cp.inet;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

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
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            serverSocket = new ServerSocket(8899);
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buf = new byte[5];
            int len;
            while ((len = inputStream.read(buf)) != -1) {
                byteArrayOutputStream.write(buf, 0, len);
                //因为传输过来的是字节流, 在缓存时最后可能是半个字, 所以可能出现乱码
//                System.out.print(new String(buf, 0, len));
            }
            //你��，���是客��端mm你好，我是客户端mm
            System.out.println(byteArrayOutputStream.toString());
            System.out.println("收到了来自于：" + accept.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(byteArrayOutputStream, inputStream, accept, serverSocket);
        }
    }

    /**
     * 客户端
     * @throws IOException
     */
    @Test
    public void client() {
        Socket socket = null;
        OutputStream out = null;
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            socket = new Socket(localHost, 8899);
            out = socket.getOutputStream();
            out.write("你好，我是客户端mm".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(out, socket);
        }
    }

}
