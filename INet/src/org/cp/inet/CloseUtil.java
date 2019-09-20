package org.cp.inet;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭资源通用工具方法
 * create by CP on 2019/9/20 0020.
 */
public class CloseUtil {

    public static void close(Closeable... closeables) {
        for (Closeable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
