package com.kang.io.demo.outputStream.systemOut;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Title 类名
 * @Description 这个类不行！！！
 * @Date 2016/8/1.
 * @Author Healthy
 * @Version
 */
public class SystemSetIn {

    public static void main(String[] args) {

        File file  = new File("D:/javaio/systemSetIn.txt");
        if(!file.exists()){
            return;
        }
            try {
            System.setIn(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] b = new byte[1024];
        int len = 0;
        try {
            len = System.in.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("读入的内容为：" + new String(b, 0, len));
    }
}
