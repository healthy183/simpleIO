package com.kang.io.demo.randomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Title 类名
 * @Description 乱码！！！
 * @Date 2016/8/2.
 * @Author Healthy
 * @Version
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) {

        File f = new File("D:/javaio/randomAccessFileDemo.txt");
        try {
            RandomAccessFile randomAccessFile =  new RandomAccessFile(f,"rw");
            randomAccessFile.writeBytes("tom");
            randomAccessFile.writeInt(12);
            randomAccessFile.writeBoolean(true);
            randomAccessFile.writeChar('a');
            randomAccessFile.writeDouble(0.1d);
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
