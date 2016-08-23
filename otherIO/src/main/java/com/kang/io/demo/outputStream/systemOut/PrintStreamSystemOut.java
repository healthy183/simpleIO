package com.kang.io.demo.outputStream.systemOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/1.
 * @Author Healthy
 * @Version
 */
public class PrintStreamSystemOut {

    public static void main(String[] args) {

        System.out.println("tom is runing!");
        File file  = new File("D:/javaio/printStreamSystem.txt");
        try {
            System.setOut(new PrintStream(file));
            System.out.println("see you in printStreamSystem.txt!");
            file  = new File("D:/javaio/printStreamError.txt");
            System.setErr(new PrintStream(file));
            System.err.println("error is work too!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
