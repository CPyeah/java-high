package org.cp.io;

import org.cp.entities.Person;
import org.junit.Test;

import java.io.*;

/**
 * 对象流
 * create by CP on 2019/9/16 0016.
 */
public class ObjectStream {

    @Test
    public void simpleObjectStreamTest() throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("aa/hello.dat"));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("aa/hello.dat"));
        objectOutputStream.writeObject(new String("你好你好!"));
        Object o = objectInputStream.readObject();
        String s = (String) o;
        System.out.println(s);
        NodeStream.closeStream(objectInputStream, objectOutputStream);
    }

    @Test
    public void personStreamTest() {
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
//            objectOutputStream = new ObjectOutputStream(new FileOutputStream("aa/person.dat"));
            objectInputStream = new ObjectInputStream(new FileInputStream("aa/person.dat"));
//            objectOutputStream.writeObject(new Person("jingjing", 25));
            Object o = objectInputStream.readObject();
            Person s = (Person) o;
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            NodeStream.closeStream(objectInputStream, objectOutputStream);
        }
    }

}
