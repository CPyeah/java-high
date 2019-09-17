package org.cp.inet;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress类:此类的一个对象就代表着一个具体的IP地址
 *
 * create by CP on 2019/9/17 0017.
 */
public class InetAddressTest {

    /**
     *  2.1实例化
     *      getByName(String host) 、 getLocalHost()
     * @throws UnknownHostException
     */
    @Test
    public void test1() throws UnknownHostException {
        InetAddress mi = InetAddress.getByName("www.mi.com");
        System.out.println(mi);
        InetAddress profeta = InetAddress.getByName("www.profetasupport.com");
        System.out.println(profeta);
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        InetAddress uat = InetAddress.getByName("192.168.0.100");
        System.out.println(uat);
    }

    /**
     * 2.2常用方法
     *  getHostName() / getHostAddress()
     * @throws UnknownHostException
     */
    @Test
    public void test2() throws UnknownHostException {
        InetAddress mi = InetAddress.getByName("www.mi.com");
        System.out.println(mi.getHostName());
        System.out.println(mi.getHostAddress());
    }
}
