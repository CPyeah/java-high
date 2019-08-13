/**
 * Copyright (C)
 * FileName: SystemTest
 * Author:   cp
 * Date:     2019/8/12 22:02
 * Description: System 类测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp.others;

import org.junit.Test;

import java.io.Console;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈System 类测试〉
 *
 * native long currentTimeMillis()
 * void exit(int status)
 * void gc()
 * String getProperty(String key)
 *
 * @author cp
 * @create 2019/8/12
 * @since 1.0.0
 */
public class SystemTest {

    @Test
    public void test() {
        Properties properties = System.getProperties();// 系统属性
        Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + ": " + value);
        }
        long l = System.currentTimeMillis();// 系统当前时间戳
        System.out.println(l);
        System.gc();//调用一下垃圾收集器
        int i = 0;
        while (true) {
            i++;
            System.out.println(i);
            if (i > 7) {
                System.exit(0);//退出程序
            }
        }

    }


}
