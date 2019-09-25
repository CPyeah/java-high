package org.cp.reflection;

import org.junit.Test;

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
        Properties properties = new Properties();
        properties.load(stream);
        String name = properties.getProperty("name");
        System.out.println(name);
    }
}
