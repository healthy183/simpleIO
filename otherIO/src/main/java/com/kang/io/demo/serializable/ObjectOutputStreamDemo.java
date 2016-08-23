package com.kang.io.demo.serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Title 类名
 * @Description 乱码
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class ObjectOutputStreamDemo {

    public static void main(String[] args) {

        File file  = new File("D:/javaio/objectOutputStreamDemo.txt");
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            Person person = new Person("tom",12);
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
