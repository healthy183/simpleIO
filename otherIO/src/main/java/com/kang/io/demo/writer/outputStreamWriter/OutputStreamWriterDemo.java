package com.kang.io.demo.writer.outputStreamWriter;

import java.io.*;

/**
 * @Title 类名
 * @Description 将字节输出流转化为字符输出流
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class OutputStreamWriterDemo {

    public static void main(String[] args) {

        File file  = new File("D:/javaio/outputStreamWriter.txt");
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(file));
            writer.write("hello");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
