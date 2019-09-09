package org.cp.io;

import org.junit.Test;

import java.io.*;

/**
 * 关于流的一些练习
 * create by CP on 2019/9/9 0009.
 */
public class Practice {

    /**
     * 图片资源加密、解密
     */
    @Test
    public void encryptImage() {
        BufferedInputStream img = null;
        BufferedOutputStream img_encrypted = null;
        try {
            //加密
//            img = new BufferedInputStream(new FileInputStream("aa/java.jpg"));
//            img_encrypted = new BufferedOutputStream(new FileOutputStream("aa/java_encrypted.jpg"));
            //解密
            img = new BufferedInputStream(new FileInputStream("aa/java_encrypted.jpg"));
            img_encrypted = new BufferedOutputStream(new FileOutputStream("aa/java_decrypted.jpg"));
            int data;
            while ((data = img.read()) != -1) {
                img_encrypted.write(data^7);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            NodeStream.closeStream(img, img_encrypted);
        }
    }
    
}
