package com.kang.io.demo.reader.bufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/1.
 * @Author Healthy
 * @Version
 */
public class BufferedReaderDemo {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(System.in));
        String str  = null;
        System.out.println("enter any key:");
        try {
            str =  bufferedReader.readLine();
            System.out.println("your key is "+str);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
