package com.kang.io.demo.outputStream.printStream;

import java.io.*;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/1.
 * @Author Healthy
 * @Version
 */
public class PrintStreamDemo {

    public static void main(String[] args) {

        File outFile = new  File("D:/bin/PrintStreamDemo.txt");
        FileOutputStream fileOutputStream = null;
        PrintStream printStream = null;
        try {
            fileOutputStream = new FileOutputStream(outFile);
            printStream = new PrintStream(fileOutputStream);
            //printStream.print(true);
            printStream.print("i am tom!");
            String name="Rollen";
            int age=20;
            printStream.printf("姓名：%s. 年龄：%d.",name,age);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                    if(printStream != null){
                        printStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
