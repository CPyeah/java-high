package org.cp.io;

import org.junit.Test;

import java.io.*;
import java.util.*;

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

    /**
     * 获取文本文件中， 每一个字符出现的次数
     */
    @Test
    public void charCounter() {
        HashMap<Character, Integer> counterMap = new HashMap<>();
        BufferedReader txtReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            txtReader = new BufferedReader(new FileReader("aa/text.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("aa/txt_counter.txt"));
            int data;
            while ((data=txtReader.read()) != -1) {
                char c = (char) data;
                if (counterMap.containsKey(c)) {
                    Integer count = counterMap.get(c);
                    count++;
                    counterMap.put(c, count);
                } else {
                    counterMap.put(c, 1);
                }
//                System.out.println(c);
            }
            Set<Map.Entry<Character, Integer>> entries = counterMap.entrySet();
            ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);
            Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
            for (Map.Entry<Character, Integer> item : list) {
                Character key = item.getKey();
                Integer value = item.getValue();
                bufferedWriter.write(key + ": " + value);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            NodeStream.closeStream(txtReader, bufferedWriter);
        }
    }
    
}
