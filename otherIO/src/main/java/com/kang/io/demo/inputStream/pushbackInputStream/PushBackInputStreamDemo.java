package com.kang.io.demo.inputStream.pushbackInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * @Title 类名
 * @Description 回退流操作
 * @Date 2016/7/31.
 * @Author Healthy
 * @Version
 */
public class PushBackInputStreamDemo {

    public static void main(String[] args) {


        String str = "hello,tom";
        PushbackInputStream push = null;
        ByteArrayInputStream bat = null;

        bat = new ByteArrayInputStream(str.getBytes());
        push = new PushbackInputStream(bat);
        int temp = 0;
        try {
            while((temp = push.read())!= -1){
                if(temp == ','){
                    push.unread(temp);
                    temp = push.read();
                    System.out.print("(回退" +(char) temp + ") ");
                }else{
                    System.out.print((char) temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
