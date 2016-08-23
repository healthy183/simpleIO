package com.kang.io.demo.reader.inputStreamReader;

import java.io.*;

/**
 * @Title 类名
 * @Description  将字节输入流变为字符输入流
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class InputStreamReaderDemo {

    public static void main(String[] args) {

        String fileUrl  = "D:/javaio/in.txt";
        File file = new File(fileUrl);
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            char[] b = new char[100];
            int len = reader.read(b);
            System.out.println(new String(b,0,len));
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
    }
}
