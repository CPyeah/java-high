package org.cp.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    public void createTest() throws IOException {
        //文件创建
        File file1 = new File("aa/bb/hello.txt");
        boolean newFile = file1.createNewFile();
        if (newFile) {
            System.out.println(file1.getName()+" created success!");
        }
        File file2 = new File("aa/ee/hello2.txt");
//        boolean newFile2 = file2.createNewFile();//java.io.IOException: 系统找不到指定的路径。
//        if (newFile2) {
//            System.out.println(file2.getName()+" created success!");
//        }
        //目录创建 mkdir/mkdirs
        File cc = new File("aa/bb/cc");
        if (!cc.exists()) {
            boolean mkdir = cc.mkdir();
            if (mkdir) {
                System.out.println("mk success");
            }
        }
        File file = new File("aa/bb/dd/helloworld");
        if (!file.exists()) {
            boolean mkdir = file.mkdir();
            if (mkdir) {
                System.out.println("mkdir success");
            } else {
                boolean mkdirs = file.mkdirs();
                if (mkdirs) {
                    System.out.println("mkdirs success");
                }
            }
        }
        //完整套路
        File file3 = new File("aa/xx/yy/zz/jingjing.txt");
        if (!file3.getParentFile().exists()) {
            boolean mkdirs = file3.getParentFile().mkdirs();
            if (mkdirs) {
                boolean jingjing = file3.createNewFile();
                if (jingjing) System.out.println(file3.getName()+" created success!");
            }
        } else {
            boolean jingjing = file3.createNewFile();
            if (jingjing) System.out.println(file3.getName()+" created success!");
        }
    }

    /**
     * 删除测试
     * delete() 只能删除 空的目录
     */
    @Test
    public void deleteTest() {
        File file = new File("aa/bb/cc");
        boolean delete = file.delete();
        if (delete) System.out.println(file.getName()+" deleted success");

        File file1 = new File("aa/bb/hello.txt");
        boolean delete1 = file1.delete();
        if (delete1) System.out.println(file1.getName()+ " deleted success");

        File file2 = new File("aa/gg/zz");
        boolean delete2 = file2.delete();
        if (delete2) System.out.println(file2.getName()+ " deleted success");
    }

    /**
     * 1. 利用File构造器，new 一个文件目录file
     *      1)在其中创建多个文件和目录
     *      2)编写方法，实现删除file中指定文件的操作
     */
    @Test
    public void practice1() throws IOException {
        File fileDir = new File("file");
        fileDir.mkdir();//创建父目录 file
        File aaDir = new File(fileDir, "aaDir");
        aaDir.mkdir();//创建子目录 aaDir
        File bbFile = new File(fileDir, "bbFile.txt");
        bbFile.createNewFile();//创建文件 bbFile
        bbFile.delete();//删除bbFile
        aaDir.delete();//删除aaDir
    }

    /**
     * 2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
     */
    @Test
    public void practice2() {
        File file = new File("file");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File item = files[i];
            if (item!=null && item.getName().endsWith(".jpg")) {
                System.out.println(item.getName());
            }
        }
    }

    /**
     * 3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
     *      拓展1：并计算指定目录占用空间的大小
     *      拓展2：删除指定文件目录及其下的所有文件
     */
    @Test
    public void practice3() throws IOException {
        //创建目录和文件
        createDirsAndFiles();
        //遍历
        iteratorDir("root");
        //删除
        deleteAll(new File("root"));
    }

    /**
     * 递归删除
     */
    private void deleteAll(File node) {
        if (!node.exists()) {//不存在
            return;
        }
        if (node.isFile()) {//是文件, 直接删除
            node.delete();
            return;
        }
        if (node.isDirectory()) {//是目录
            File[] files = node.listFiles();
            if (files!=null&&files.length>0) {//有子文件或子目录
                for (File child : files) {//循环递归
                    deleteAll(child);
                }
                //子文件删除完了之后, 再删除该目录
                node.delete();//删除该目录
            } else {//没有子文件或子目录
                node.delete();//删除该目录
            }
        }

    }

    /**
     * 遍历
     * hello.txt size is 5
     * hi.txt size is 2
     * helloworld.txt size is 10
     * @param node
     */
    private void iteratorDir(String node) {
        File nod = new File(node);
        if (nod.isFile()) {//是文件 输出大小
            System.out.println(nod.getName() + " size is " + nod.length());
        } else {// 是目录
            File[] files = nod.listFiles();
            if (files!=null&&files.length>0) {
                for (int i = 0; i <files.length; i++) {
                    iteratorDir(files[i].getAbsolutePath());
                }
            } else {

            }
        }
    }

    /**
     *  root
     *      dir1
     *          dir2
     *          hello.txt
     *      helloworld.txt
     *      dir3
     *      dir4
     *          hi.txt
     */
    private void createDirsAndFiles() throws IOException {
        File root = new File("root");
        root.mkdir();
        File dir1 = new File(root, "dir1");
        dir1.mkdir();
        File dir2 = new File(dir1, "dir2");
        dir2.mkdir();
        File hello = new File(dir1, "hello.txt");
        hello.createNewFile();
        File helloworld = new File(root, "helloworld.txt");
        helloworld.createNewFile();
        File dir3 = new File(root, "dir3");
        dir3.mkdir();
        File dir4 = new File(root, "dir4");
        dir4.mkdir();
        File hi = new File(dir4, "hi.txt");
        hi.createNewFile();
    }

}
