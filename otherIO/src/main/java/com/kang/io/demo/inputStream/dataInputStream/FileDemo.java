package com.kang.io.demo.inputStream.dataInputStream;

import java.io.*;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/7/31.
 * @Author Healthy
 * @Version
 */
public class FileDemo {

    static String fileUrl  = "D:/javaio/in.txt";

    public static void main(String[] args) {

        File file = new File(fileUrl);
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(file));
            char[] ch = new char[10];
            int count = 0;
            char temp;
            while((temp = dataInputStream.readChar())!= 'C'){
                ch[count++] = temp;
            }
            System.out.println(ch);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(dataInputStream != null){
                try {
                    dataInputStream.close();
                    dataInputStream = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
