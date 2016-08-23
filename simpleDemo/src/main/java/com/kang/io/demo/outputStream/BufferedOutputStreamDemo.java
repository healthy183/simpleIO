package com.kang.io.demo.outputStream;

import java.io.*;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class BufferedOutputStreamDemo {

    public static void main(String[] args) {
        String readPath = "D:\\javaio\\F4.mp3";
        String copePath = "D:\\javaio\\F4Cope2.mp3";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream  = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileInputStream = new FileInputStream(readPath);
            fileOutputStream = new FileOutputStream(copePath);

            bufferedInputStream  =  new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new  BufferedOutputStream(fileOutputStream);
            int temp = 0;
            byte[] bytes = new byte[1024];
            while((temp = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,temp);
            }
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                    if(bufferedOutputStream != null){
                        bufferedOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
