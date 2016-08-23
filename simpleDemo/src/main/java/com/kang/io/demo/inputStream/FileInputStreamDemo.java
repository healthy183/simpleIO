package com.kang.io.demo.inputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class FileInputStreamDemo {

    public static void main(String[] args) {
        String readPath = "D:\\javaio\\fileReaderDemo.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(readPath);
            //单字节读取
            /*int ch = 0;
            while((ch = fileInputStream.read())!= -1){
                System.out.println((char)ch);
            }*/
            //字节数组读取
            StringBuilder stringBuilder = new StringBuilder();
            byte[] bytes  = new byte[1024];
            int len = 0;
            while((len = fileInputStream.read(bytes))!= -1){
                stringBuilder.append(new String(bytes,0,len));
            }
            System.out.println(stringBuilder.toString());
            //单此字节数组读取 文件过大，available()会导致内存溢出(慎用)
            /*byte[] buf = new byte[fileInputStream.available()];
            fileInputStream.read(buf);
            System.out.println(new String(buf));*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
