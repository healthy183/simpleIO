package com.kang.io.demo.reader.fileWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class FileWriterDemo {

    public static void main(String[] args) {
        String readPath = "D:\\javaio\\fileReaderDemo.txt";
        String  zwriterPath = "D:\\javaio\\fileWriterDemo.txt";
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        int temp  = 0;
        try {
            fileWriter  = new  FileWriter(zwriterPath);
            fileReader =  new FileReader(readPath);

            //方式1 单字节读取
            /*while((temp = fileReader.read())!= -1){
                fileWriter.write(temp);
            }*/
            //方式二 写入字符数组
            char[] chars = new char[1024];
            while((temp = fileReader.read(chars))!= -1){
                fileWriter.write(chars,0,temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null ) {
                try {
                    fileReader.close();
                    if(fileWriter != null){
                        fileWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
