package com.kang.io.demo.outputStream.systemOut;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/8/1.
 * @Author Healthy
 * @Version
 */
public class SystemOutDemo {

    public static void main(String[] args) {
        OutputStream outputStream = System.out;
        try {
            outputStream.write("tom is here!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
