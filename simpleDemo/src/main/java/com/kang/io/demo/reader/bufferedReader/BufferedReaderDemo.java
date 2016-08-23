package com.kang.io.demo.reader.bufferedReader;

import java.io.*;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class BufferedReaderDemo {

    public static void main(String[] args) {
        String readPath = "D:\\javaio\\fileReaderDemo.txt";
        String  zwriterPath = "D:\\javaio\\bufferedReaderDemo.txt";
        FileReader fileReader = null;
        FileWriter fileWriter  = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileReader = new  FileReader(readPath);
            fileWriter = new FileWriter(zwriterPath);
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            String lineContext = null;
            while((lineContext = bufferedReader.readLine()) != null){
                bufferedWriter.write(lineContext);
                bufferedWriter.newLine();//换行
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                    if(bufferedWriter != null){
                        bufferedWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
