package com.kang.io.demo.inputStream.fileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Title 类名
 * @Description 文件字节输入流转字节流
 * @Date 2016/7/30.
 * @Author Healthy
 * @Version
 */
@Deprecated //不建议学习
public class SimpleRead {

    static String fileUrl  = "D:/javaio/in.txt";


    public static void main(String[] args) {
        //readAll();//一次读整文件
        //readByte();//单字节读取
        stopReadByteIfEnd();
    }


    public static void readAll(){
        File f = new File(fileUrl);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(f);
            byte[] b  = new byte[(int)f.length()];
            fileInputStream.read(b);
            fileInputStream.close();
            System.out.println(new String(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                    fileInputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void readByte(){
        File f = new File(fileUrl);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(f);
            byte[] b  = new byte[(int)f.length()];
           for(int i =0;i<b.length;i++){
               b[i] = (byte)fileInputStream.read();
           }
            System.out.println(new String(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                    fileInputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void stopReadByteIfEnd(){
        File f = new File(fileUrl);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(f);
            byte[] b  = new byte[1024];
            int count = 0;
            int temp = 0;
            while ((temp =fileInputStream.read())!= -1){
                b[count++]=(byte)temp;
            }
            System.out.println(new String(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                    fileInputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
