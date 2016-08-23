package com.kang.io.demo.outputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class FileOutputStreamDemo {

    public static void main(String[] args) {
        appendFile();
        copeMp3();
    }

    private static void copeMp3() {
        String readPath = "D:\\javaio\\F4.mp3";
        String copePath = "D:\\javaio\\F4Cope.mp3";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream  = new FileInputStream(readPath);
            fileOutputStream = new FileOutputStream(copePath);
            byte[] buf = new byte[1024];
            int temp = 0;
            while((temp = fileInputStream.read(buf)) != -1){
                fileOutputStream.write(buf,0,temp);
            }
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                    if(fileOutputStream != null){
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void appendFile(){

        String readPath = "D:\\javaio\\fileReaderDemo.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(readPath,true);
            String context = "this is FileOutputStreamDemo!";
            byte[] bytes = context.getBytes();
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
