package com.kang.io.demo.writer.fileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class FileWriterDemo {

    public static void main(String[] args) {

        File file  = new File("D:/javaio/fileWriter.txt");
        Writer out = null;
        try {
            out = new FileWriter(file);
            String writerStr = "helloWorld";
            out.write(writerStr);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                if(out != null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }


    }
}
