package com.kang.io.demo.outputStream.byteArrayOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Title 类名
 * @Description 描述
 * @Date 2016/7/31.
 * @Author Healthy
 * @Version
 */
public class ToLowerCase {

    public static void main(String[] args) {
        String context = "HI,TOM!";
        ByteArrayInputStream byteArrayInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try{
            byteArrayInputStream = new ByteArrayInputStream(context.getBytes());
            byteArrayOutputStream  = new ByteArrayOutputStream();

            int temp =  0;
            while((temp = byteArrayInputStream.read())!= -1){
                char ch = (char)temp;
                byteArrayOutputStream.write(Character.toLowerCase(ch));
            }
            String downContext = byteArrayOutputStream.toString();
            System.out.println(downContext);
        }catch (Exception ex){
        }finally {
            if(byteArrayInputStream != null){
                try {
                    byteArrayInputStream.close();
                    byteArrayInputStream = null;
                    if(byteArrayOutputStream != null){
                        byteArrayOutputStream.close();
                        byteArrayOutputStream = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
