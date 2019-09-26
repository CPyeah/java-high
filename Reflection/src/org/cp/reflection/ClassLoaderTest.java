package org.cp.reflection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * create by CP on 2019/9/25 0025.
 */
public class ClassLoaderTest {
    /**
     * 使用Classloader加载src目录下的配置文件
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        //以src目录为根目录
        InputStream stream = classLoader.getResourceAsStream("jdbc.properties");
        FileInputStream fis = new FileInputStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(stream);
//        properties.load(fis);// bundle 目录下的jdbc
        String name = properties.getProperty("name");
        System.out.println(name);
    }

    /**
     * 三种类加载器
     */
    @Test
    public void threeClassLoader() {
        ClassLoader classLoader1 = Person.class.getClassLoader();
        ClassLoader classLoader2 = classLoader1.getParent();
        ClassLoader classLoader3 = classLoader2.getParent();
        ClassLoader classLoader4 = String.class.getClassLoader();
        System.out.println(classLoader1);//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader2);//sun.misc.Launcher$ExtClassLoader@452b3a41
        System.out.println(classLoader3);// 核心加载器获取不到
        System.out.println(classLoader4);// 核心加载器获取不到
    }
}
