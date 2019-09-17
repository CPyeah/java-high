package org.cp.ioutil;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * CommonIO 包 测试
 *
 * create by CP on 2019/9/17 0017.
 */
public class CommonIOTest {

    @Test
    public void readTest() throws IOException {
        File file = new File("aa/abc.txt");
        String s = FileUtils.readFileToString(file, "utf-8");
        System.out.println(s);
    }

    @Test
    public void copyFile() throws IOException {
        File src = new File("aa/java.jpg");
        File dest = new File("aa/java_copyByCommonIO.jpg");
        FileUtils.copyFile(src, dest);
    }

}
