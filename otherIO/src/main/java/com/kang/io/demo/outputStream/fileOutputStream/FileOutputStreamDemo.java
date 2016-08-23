package com.kang.io.demo.outputStream.fileOutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/7/31.
 * @Author Healthy
 * @Version
 */
public class FileOutputStreamDemo {

    public static void main(String[] args) {
        //writeThoughtByteArray();
        //writeThoughtByte();
        append();
    }

    public static void append(){
        File wirterFile = new File("D:/javaio/writeThoughtByte.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(wirterFile,true);//true表示追加模式，否则为覆盖
            String writerContent = "append tom!";
            byte[] transByte = writerContent.getBytes();
            for(int i = 0;i<transByte.length;i++){
                fileOutputStream.write(transByte[i]);
            }
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                    fileOutputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void  writeThoughtByte(){
        File wirterFile = new File("D:/javaio/writeThoughtByte.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(wirterFile);
            String writerContent = "writeThoughtByte tom!";
            byte[] transByte = writerContent.getBytes();
            for(int i = 0;i<transByte.length;i++){
                fileOutputStream.write(transByte[i]);
            }
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                    fileOutputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writeThoughtByteArray(){
        File wirterFile = new File("D:/javaio/wirterFile.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(wirterFile);
            String writerContent = "writer tom!";
            byte[] transByte = writerContent.getBytes();
            fileOutputStream.write(transByte);
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
