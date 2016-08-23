package com.kang.io.demo.reader.fileReader;

import java.io.*;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/1.
 * @Author Healthy
 * @Version
 */
public class FileReaderDemo {

    public static void main(String[] args){
       //readFile();
        cycileReadFile();
    }


    /**
     * 循环读，保证完整读取文件
     */
    public static void cycileReadFile(){

        File file  = new File("D:/javaio/printStreamSystem.txt");
        char[] ch = new char[100];
        int  count  = 0;
        int temp = 0;
        Reader reader = null;
        try {
            reader = new FileReader(file);
            while((temp = reader.read()) != -1 ){
                    ch[count++] = (char)temp;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("file context is:"+new String(ch,0,count));
    }

    public static void readFile(){

        File file  = new File("D:/javaio/printStreamSystem.txt");
        char[] ch = new char[100];
        int  count  = 0;
        Reader reader = null;
        try {
            reader = new FileReader(file);
            count = reader.read(ch);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("file context is:"+new String(ch,0,count));
    }
}
