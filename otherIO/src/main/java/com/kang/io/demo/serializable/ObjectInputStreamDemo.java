package com.kang.io.demo.serializable;

import java.io.*;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class ObjectInputStreamDemo {

    public static void main(String[] args) {

        File file  = new File("D:/javaio/objectOutputStreamDemo.txt");
        ObjectInputStream objectInputStream = null;
        try {
             objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Object obj =objectInputStream.readObject();
            System.out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
