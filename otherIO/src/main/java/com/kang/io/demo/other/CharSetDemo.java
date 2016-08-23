package com.kang.io.demo.other;

import java.io.*;

/**
 * @Title 类名
 * @Description 展示乱码
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class CharSetDemo {

    public static void main(String[] args) {
        System.out.println("系统编码:"+System.getProperty("file.encoding"));

        File f = new File("D:/javaio/enccodTest.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(f);
            byte[] bytes = "你好".getBytes("ISO8859-1");
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
