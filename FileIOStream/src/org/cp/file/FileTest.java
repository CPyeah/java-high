package org.cp.file;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

/**
 * create by CP on 2019/9/2 0002.
 */
public class FileTest {

    @Test
    public void fileConstruct() {
//        相对路径：相较于某个路径下，指明的路径。
//        绝对路径：包含盘符在内的文件或文件目录的路径
//        IDEA中：
//        如果大家开发使用JUnit中的单元测试方法测试，相对路径即为当前Module下。
//        如果大家使用main()测试，相对路径即为当前的Project下。
//        Eclipse中：
//        不管使用单元测试方法还是使用main()测试，相对路径都是当前的Project下。
        File file = new File("aa/hello.txt");//相对路径 文件
        File file1 = new File("c:aa/hello.txt");//绝对路径 文件
        File file2 = new File("aa");//相对路径 目录(文件夹)
        File file3 = new File("aa", "hello.txt");//目录 + 文件
        File file4 = new File(file2, "hello.txt");//目录对象 + 文件
        System.out.println(file.exists());
        System.out.println(file1.exists());
        System.out.println(file2.exists());
        System.out.println(file3.exists());
        System.out.println(file4.exists());
    }

    /**
     * file 常用获取方法
     */
    @Test
    public void getMethod() {
        File file = new File("aa/hello.txt");//绝对路径: E:\CP\spring-boot-quick\FileIOStream\aa\hello.txt
        System.out.println("绝对路径: "+file.getAbsolutePath());//构造路径: aa\hello.txt
        System.out.println("构造路径: "+file.getPath());//文件名称: hello.txt
        System.out.println("文件名称: "+file.getName());//父目录路径: aa
        System.out.println("父目录路径: "+file.getParent());//文件长度: 5
        System.out.println("文件长度: "+file.length());//:最近修改时间(戳) 1567389845757
        System.out.println("最近修改时间(戳): "+file.lastModified());//同级所有文件及目录: [Ljava.lang.String;@22927a81
        System.out.println("同级所有文件及目录名称: "+ Arrays.toString(file.getParentFile().list()));//同级所有文件及目录: [bb, hello.txt, hi.txt]
        System.out.println("同级所有文件及目录: "+Arrays.toString(file.getParentFile().listFiles()));//同级所有文件及目录: [aa\bb, aa\hello.txt, aa\hi.txt]
    }

    /**
     * 文件重命名, 可以移动路径
     */
    @Test
    public void renameTest() {
        File file = new File("aa/hi.txt");
        File dest = new File("aa/bb/hi.txt");
        boolean b = file.renameTo(dest);
        if (b) {
            System.out.println("重命(移动)名成功!");
        }
        else {
            boolean b1 = dest.renameTo(file);
            if (b1) {
                System.out.println("文件回来成功!");
            }
        }
    }
    
    @Test
    public void judgeTest() {
        File file = new File("aa/hello.txt");
//        file = new File("aa/hello1.txt");//没有文件, 下列判断全false
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }

    /**
     * 创建方法测试
     */
    @Test
    public void createTest() {
    
    }
    
}
