package org.cp.inet;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * create by CP on 2019/9/20 0020.
 */
public class UDPTest {
    /**
     * 信息发送者
     */
    @Test
    public void sender() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress host = InetAddress.getLocalHost();
            int port = 9988;
            byte[] data = "我是UDP方式发送的导弹...".getBytes();
            //数据包
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, host, port);
            //发送1
            socket.send(packet);
            //发送2
            packet.setPort(9999);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(socket);
        }
    }

    /**
     * 接受者1
     */
    @Test
    public void receiver1() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9988);
            byte[] content = new byte[1024];
            // 数据接收包
            DatagramPacket packet = new DatagramPacket(content, 0, content.length);
            //接收
            socket.receive(packet);
            byte[] data = packet.getData();//接收数据
            System.out.println("接收者1");
            System.out.println(new String(data, 0, data.length));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(socket);
        }
    }

    /**
     * 接受者2
     */
    @Test
    public void receiver2() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9999);
            byte[] content = new byte[1024];
            // 数据接收包
            DatagramPacket packet = new DatagramPacket(content, 0, content.length);
            //接收
            socket.receive(packet);
            byte[] data = packet.getData();//接收数据
            System.out.println("接收者2");
            System.out.println(new String(data, 0, data.length));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(socket);
        }
    }
    
}
